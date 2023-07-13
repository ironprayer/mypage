package com.example.test_five_week.domain.post.dto;

import lombok.Getter;

@Getter
public class ResultMsgDto {
    private final String msg;

    public ResultMsgDto(String msg) {
        this.msg = msg;
    }
}
