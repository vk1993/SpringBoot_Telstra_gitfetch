package com.gitfetch.telstra_gitdemo.service;

import com.gitfetch.telstra_gitdemo.domain.GitData;
import com.gitfetch.telstra_gitdemo.domain.GitResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
public class GitServiceImpl implements GitService {

    private LocalDate today = LocalDate.now();
    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<GitData>> getData(int numebrOfRepo) {
        log.info("inside getData Impl....");

        String lastweek = today.minus(1, ChronoUnit.WEEKS).toString();

        log.info("Number of repositry :{}", numebrOfRepo);
        log.info("Last week date:{}",lastweek);

        String downStreamUrl= "https://api.github.com/search/repositories?q=created:>"+lastweek+"&sort=stars&order=desc&per_page="+numebrOfRepo;
        ResponseEntity<GitResult> downstreamResult = restTemplate.getForEntity(downStreamUrl,GitResult.class);

        return ResponseEntity.ok().body(downstreamResult.getBody().getItems());
    }
}
