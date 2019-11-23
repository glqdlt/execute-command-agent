package com.glqdlt.pm6.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
