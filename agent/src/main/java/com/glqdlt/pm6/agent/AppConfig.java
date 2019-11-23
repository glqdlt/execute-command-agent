package com.glqdlt.pm6.agent;

import com.glqdlt.pm6.security.matcher.PlainSecurityTokenMatcher;
import com.glqdlt.pm6.security.matcher.SecurityTokenMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityTokenMatcher securityTokenMatcher;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenMatchInterceptor(securityTokenMatcher))
                .addPathPatterns("/api/v1/system/**").order(0);
    }


    @Bean
    public SecurityTokenMatcher securityTokenMatcher(@Value("${secret.key}") String key) {
        return new PlainSecurityTokenMatcher(key);
    }
}
