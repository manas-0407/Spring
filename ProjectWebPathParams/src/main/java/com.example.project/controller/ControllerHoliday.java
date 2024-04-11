package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.project.models.Holiday;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ControllerHoliday {

    @GetMapping(value = "/holidays/{display}")
    public String holidayPage(@PathVariable String display,
                              Model model){

        if(display.equals("all")){
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }else if(display.equals("festival")){
            model.addAttribute("festival", true);
            model.addAttribute("federal", false);
        }else{
            model.addAttribute("festival", false);
            model.addAttribute("federal", true);
        }

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
