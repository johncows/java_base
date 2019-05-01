package com.kk.security.brower.properties;

import com.kk.security.brower.LoginType;
import lombok.Data;

@Data
public class BrowserProperties {
    private String loginPage = "/kk-signIn.html";
    private LoginType loginType = LoginType.JSON;
}
