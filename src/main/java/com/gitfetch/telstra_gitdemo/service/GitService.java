package com.gitfetch.telstra_gitdemo.service;


import com.gitfetch.telstra_gitdemo.domain.GitData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GitService {
    ResponseEntity<List<GitData>> getData(int numebrofRepo);
}
