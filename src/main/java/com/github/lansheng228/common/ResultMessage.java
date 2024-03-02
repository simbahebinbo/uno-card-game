package com.github.lansheng228.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResultMessage {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Object data;


    public ResultMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
