package com.shawnking07.webeditor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shawn
 */
@Configuration
@EnableJpaAuditing
@EnableAspectJAutoProxy
public class WebConfig {

}
