package org.leo.test.springthread;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("org.leo.test.springthread")
@EnableAsync
public class Config {

}
