package com.ali.demo.controller;

import com.ali.demo.util.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {

    @GetMapping
    public String sayHello() {
        return "Hello welcome to api";
    }

    @GetMapping("welcome")
    public ResponseEntity<ResponseStatus> getContactUsList() {
//        LOGGER.info("function called :" + MarkUtil.getMethodName());
        ResponseStatus status = new ResponseStatus(1, "SUCCESS");
        return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
    }
}
