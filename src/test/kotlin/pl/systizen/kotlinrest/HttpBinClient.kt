package pl.systizen.kotlinrest

import feign.Headers
import feign.Param
import feign.RequestLine


interface HttpBinClient {
    @RequestLine("POST /post")
    @Headers("Content-Type: application/json")
    fun create(item: Item): Response

    @RequestLine("POST /status/{code}")
    fun status(@Param("code") code: Int)
}