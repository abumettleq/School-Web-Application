package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController {
    @RequestMapping("index")
    public String index_alternative()
    {
        return "index";
    }

    @RequestMapping("login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("pricing")
    public String pricing()
    {
        return "pricing";
    }

    @RequestMapping("about-us")
    public String aboutUs()
    {
        return "about-us";
    }
}
