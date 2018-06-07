package com.nuc.lg.ibeacon.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
