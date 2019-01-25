package com.gitfetch.telstra_gitdemo.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Data
@Component
public class GitData {
    private String html_url;
    private BigDecimal watchers_count;
    private String language;
    private String description;
    private String name;
}
