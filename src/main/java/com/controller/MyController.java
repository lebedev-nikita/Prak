package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    //    TODO: УДАЛИТЬ
    @GetMapping("/")
    public String sayHello() {
        return "hello.jsp";
    }

    @GetMapping("/positions")
    public String positions() {
        return "positions.jsp";
    }

    @GetMapping("/employees")
    public String employees() {
        return "employees.jsp";
    }

    @GetMapping("/divisions")
    public String divisions() {
        return "divisions.jsp";
    }

}
