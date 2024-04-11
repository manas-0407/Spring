package com.example.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name="created_at")
    LocalDateTime created_at;

    @Column(name = "created_by")
    String created_by;

    @Column(name = "updated_at")
    LocalDateTime updated_at;

    @Column(name = "updated_by")
    String updated_by;
}
