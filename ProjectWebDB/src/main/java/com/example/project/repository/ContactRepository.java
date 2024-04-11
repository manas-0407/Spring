package com.example.project.repository;

import com.example.project.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

@Repository
public class ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Contact contact){
        String query = "insert into contact_msg (name,mobile_num,email," +
                "subject,message,status,created_at,created_by) values (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(query,contact.getName(),contact.getMobile_num(),contact.getEmail()
        ,contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreated_at(),contact.getCreated_by());
    }

    public List<Contact> getContactByStatus(String status) {
        String query = "select * from contact_msg where status = ?";
        return jdbcTemplate.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        }, (rs, rowNo) -> { // RowMapper
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contact_id"));
            contact.setName(rs.getString("name"));
            contact.setMobile_num(rs.getString("mobile_num"));
            contact.setEmail(rs.getString("email"));
            contact.setSubject(rs.getString("subject"));
            contact.setMessage(rs.getString("message"));
            contact.setStatus(rs.getString("status"));
            contact.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
            contact.setCreated_by(rs.getString("created_by"));
            if(rs.getString("updated_at") != null){
                contact.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
            }
            contact.setUpdated_by(rs.getString("updated_by"));

            return contact;
        });
    }


    public void close_message_(int id, String updated_by) {
        String query = "update contact_msg set status = ?, " +
                "updated_by = ?, updated_at = ? where contact_id = ?";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,"CLOSE");
                ps.setString(2,updated_by);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4,id);
            }
        });
        System.err.println("Closed !");
    }
}
