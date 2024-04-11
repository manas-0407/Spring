package com.example.project.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;
import java.io.*;

@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "holiday_id")
    int holiday_id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "day_")
    private String day;

    @Column(name = "type")
    private String type;
}
