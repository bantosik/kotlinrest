package pl.systizen.kotlinrest

import com.fasterxml.jackson.module.kotlin.KotlinModule
import feign.Feign
import feign.Logger
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.slf4j.Slf4jLogger

// baeldung.com/intro-to-feign
object HttpClients {
    fun httpBinClient(): HttpBinClient = Feign.builder()
        .encoder(JacksonEncoder(listOf(KotlinModule.Builder().build())))
        .decoder(JacksonDecoder(listOf(KotlinModule.Builder().build())))
        .logger(Slf4jLogger(HttpBinClient::class.java))
        .logLevel(Logger.Level.FULL)
        .target(HttpBinClient::class.java, "https://httpbin.org")
}