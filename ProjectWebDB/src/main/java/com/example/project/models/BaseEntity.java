package com.example.project.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

@Data
public class BaseEntity {
    LocalDateTime created_at;
    String created_by;
    LocalDateTime updated_at;
    String updated_by;
}
