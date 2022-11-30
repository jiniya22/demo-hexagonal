package me.jiniworld.demohx.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(basePackages = [
    "me.jiniworld.demohx.config",
    "me.jiniworld.demohx.web",
    "me.jiniworld.demohx.application",
    "me.jiniworld.demohx.persistence",
])
@Configuration
internal class BeanConfig