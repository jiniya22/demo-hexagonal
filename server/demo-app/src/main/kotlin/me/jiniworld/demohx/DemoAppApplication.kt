package me.jiniworld.demohx

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication(scanBasePackages = [
    "me.jiniworld.demohx.config",
    "me.jiniworld.demohx.web",
    "me.jiniworld.demohx.application",
    "me.jiniworld.demohx.persistence",
])
class DemoAppApplication

fun main(args: Array<String>) {
    Locale.setDefault(Locale.KOREA)
    runApplication<DemoAppApplication>(*args)
}