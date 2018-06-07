package com.nuc.lg.ibeacon.controller;

import com.nuc.lg.ibeacon.repository.PeopleRepo;
import com.nuc.lg.ibeacon.vo.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class HtmlController {

    @Autowired
    PeopleRepo peopleRepo;

    private Logger Log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/home")
    public String home(Model model, @RequestParam("id") String id) {
        Log.info(id);
        String name = peopleRepo.findPeopleById(id).getName();
        model.addAttribute("name", name);
        return "home";
    }
}
