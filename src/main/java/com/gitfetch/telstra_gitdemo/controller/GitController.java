package com.gitfetch.telstra_gitdemo.controller;

import com.gitfetch.telstra_gitdemo.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController()
@RequestMapping("rest/v1")
public class GitController {

    @Autowired
    GitService gitService;
    @GetMapping("/gitrepo/{numOfRepo}")
    public Object helloWorld(@PathVariable("numOfRepo") int number){
        return gitService.getData(number);
    }
}
