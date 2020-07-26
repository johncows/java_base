package com.kk.security.brower.pojo;

import lombok.Data;

@Data
public class WebStatus {
    private String error;

    public WebStatus(String error) {
        this.error = error;
    }
}
