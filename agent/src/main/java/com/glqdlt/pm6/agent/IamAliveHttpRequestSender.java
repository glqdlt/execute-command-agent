package com.glqdlt.pm6.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@Slf4j
@Component
public class IamAliveHttpRequestSender implements IamAlive {

    @Autowired
    private RestTemplateBuilder builder;

    @Value("${manager.server.host}")
    private String host;

    @Value("${manager.server.event.uri}")
    private String uri;

    public IamAliveHttpRequestSender() {
    }

    public String getUrl() {
        return host + uri;
    }

    @Override
    public void sendEvent() {

        RestTemplate restTemplate = builder.setConnectTimeout(Duration.ofSeconds(10))
                .build();

        try {
            ResponseEntity<String> res = restTemplate.getForEntity(getUrl(), String.class);
            if (!res.getStatusCode().equals(HttpStatus.OK)) {
                throw new RuntimeException("Fail Send Alive Event");
            }
        } catch (Throwable e) {
//            TODO 재시도 관련 비동기 처리 필요
            log.error(e.getMessage(), e);
        }

    }
}
