package com.gitfetch.telstra_gitdemo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Setter
@Getter
@Data
public class GitResult {
    BigInteger total_count;
    boolean incomplete_results;
    List<GitData> items;
}
