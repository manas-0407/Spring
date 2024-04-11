package com.example.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(name="created_at", updatable = false)
    LocalDateTime created_at;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    String created_by;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    LocalDateTime updated_at;

    @LastModifiedBy
    @Column(name = "updated_by", insertable = false)
    String updated_by;
}
