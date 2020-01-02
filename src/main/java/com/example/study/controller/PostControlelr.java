package com.example.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post") //localhost:8080/api
public class PostControlelr {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMethod
    public String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParamerter(@RequestParam String id, @RequestParam String password){
        System.out.println("id : "+ id +", password : " + password);

        return id+password;
    }



}
