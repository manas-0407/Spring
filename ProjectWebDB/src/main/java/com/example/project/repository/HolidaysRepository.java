package com.example.project.repository;

import com.example.project.models.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

@Repository
public class HolidaysRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Holiday> holidays(String type){
        String query = "select * from holidays where type = ?";
        return jdbcTemplate.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, type);
            }
        }, new RowMapper<Holiday>() {
            @Override
            public Holiday mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Holiday(rs.getString("reason"),rs.getString("day_"),type);
            }
        });
    }
}
