package com.example.project.controller;

import com.example.project.sevices.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ControllerHoliday {

    @Autowired
    private HolidaysService holidaysService;

    @GetMapping(value = "/holidays/{type}")
    public String holidayPage(@PathVariable String type, Model model){

        if(type.equals("all")){
            model.addAttribute("festival", true);
            model.addAttribute("FESTIVAL" , holidaysService.holidays("FESTIVAL"));

            model.addAttribute("federal", true);
            model.addAttribute("FEDERAL" , holidaysService.holidays("FEDERAL"));
        }
        else if(type.equals("festival")){
            model.addAttribute("festival", true);
            model.addAttribute("FESTIVAL" , holidaysService.holidays("FESTIVAL"));
        }
        else {
            model.addAttribute("federal", true);
            model.addAttribute("FEDERAL" , holidaysService.holidays("FEDERAL"));
        }

        return "holidays.html";
    }
}
