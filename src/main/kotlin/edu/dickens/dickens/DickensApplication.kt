package edu.dickens.dickens

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DickensApplication

fun main(args: Array<String>) {
    runApplication<DickensApplication>(*args)
}
