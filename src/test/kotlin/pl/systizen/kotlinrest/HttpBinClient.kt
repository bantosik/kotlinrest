package pl.systizen.kotlinrest

import feign.Headers
import feign.RequestLine


interface HttpBinClient {
    @RequestLine("POST /post")
    @Headers("Content-Type: application/json")
    fun create(item: Item): Response

}