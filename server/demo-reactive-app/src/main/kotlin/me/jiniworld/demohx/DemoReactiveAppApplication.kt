package me.jiniworld.demohx

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class DemoReactiveAppApplication

fun main(args: Array<String>) {
    Locale.setDefault(Locale.KOREA)
    runApplication<DemoReactiveAppApplication>(*args)
}