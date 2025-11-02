package com.gfss.pms.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PMSUserController {
    @GetMapping("/")
    public String hello(){
        return "HELLO WORLD !!!";
    }

}
