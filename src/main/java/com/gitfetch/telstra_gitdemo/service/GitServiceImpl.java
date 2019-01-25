package com.gitfetch.telstra_gitdemo.service;

import com.gitfetch.telstra_gitdemo.domain.GitResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class GitServiceImpl implements GitService {


    private LocalDate today = LocalDate.now();

    @Override
    public Object getData(int numebrOfRepo)  {
        log.info("inside getData Impl....");

        String lastweek = today.minus(1, ChronoUnit.WEEKS).toString();

        log.info("Number of ");
        log.info("Last week date:",lastweek);

        String downStreamUrl= "https://api.github.com/search/repositories?q=created:>"+lastweek+"&sort=stars&order=desc&per_page="+numebrOfRepo;

        log.info(downStreamUrl);

        return new RestTemplate().getForObject(downStreamUrl,GitResult.class).getItems();
    }
}
