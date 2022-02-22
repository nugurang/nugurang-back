package com.nugurang.nugurang

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.nugurang", "com.nugurang.*"])
class NugurangApplication : CommandLineRunner {
    @Throws(Exception::class)
    override fun run(vararg args: String) {
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(NugurangApplication::class.java, *args)
        }
    }
}