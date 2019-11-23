package com.glqdlt.pm6.agent.event;

import com.glqdlt.pm6.agent.IamAlive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */

@Component
public class AppEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private IamAlive iamAlive;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        iamAlive.sendEvent();
    }
}
