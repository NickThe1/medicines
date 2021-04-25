package com.nick.software.medicines.account.controller;

import com.nick.software.medicines.account.service.AccountService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Data
@Controller
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("register")
    public String register(){

        return "index";
    }
}
