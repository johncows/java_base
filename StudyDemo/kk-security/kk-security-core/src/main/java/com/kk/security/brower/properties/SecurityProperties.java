package com.kk.security.brower.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kk.security")
@Data
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
}
