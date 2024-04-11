package com.example.project.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@ControllerAdvice
public class GlobalErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView err_handle(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addAllObjects(new HashMap<>(){{put("errormsg" , exception.getMessage());}});
        return mv;
    }
}
