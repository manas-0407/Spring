package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.project.models.Holiday;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ControllerHoliday {

    @GetMapping(value = "/holidays")
    public String holidayPage(@RequestParam(required = false) boolean festival,
                              @RequestParam(required = false) boolean federal,
                              Model model){

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 31 ","New Year's Eve", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
        );

        System.out.println("HERE");

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type t : types){
            model.addAttribute(t.toString(), holidays.stream().
                    filter(x -> x.getType().equals(t)).
                    collect(Collectors.toList()));
        }

        return "holidays.html";
    }
}
