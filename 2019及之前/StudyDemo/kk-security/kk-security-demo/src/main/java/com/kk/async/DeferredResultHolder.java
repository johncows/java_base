package com.kk.async;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;


@Data
@Component
public class DeferredResultHolder {
    private Map<String, DeferredResult<String>> map = new HashMap<>();

}
