package com.example.project.sevices;

import com.example.project.models.Holiday;
import com.example.project.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.io.*;

@Service
public class HolidaysService {

    @Autowired
    private HolidaysRepository holidaysRepository;

    public List<Holiday> holidays(String type){
        return holidaysRepository.holidays(type);
    }
}
