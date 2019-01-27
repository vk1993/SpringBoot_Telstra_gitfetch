package com.gitfetch.telstra_gitdemo.controller;

import com.gitfetch.telstra_gitdemo.domain.GitData;
import com.gitfetch.telstra_gitdemo.domain.GitResult;
import com.gitfetch.telstra_gitdemo.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController()
@RequestMapping("rest/v1")
public class GitController {

    @Autowired
    GitService gitService;

    @GetMapping(value = "/gitrepo/{numOfRepo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GitData> helloWorld(@PathVariable("numOfRepo") int number) throws Exception{
        return (List<GitData>) gitService.getData(number);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
