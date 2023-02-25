package pl.systizen.kotlinrest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

// see:  https://www.baeldung.com/kotlin/junit-5-kotlin

class APITest {
    @Test
    fun `HTTPBin responds with item in json field`() {
        val item = Item(1, "value")
        val response = HttpClients.httpBinClient().create(item)
        Assertions.assertEquals(item, response.json)
    }

    @Test
    fun `Feign client throws exception when 500 is returned`() {
        // assert exception is thrown
        val e = Assertions.assertThrows(Exception::class.java) {
            HttpClients.httpBinClient().status(500)
        }
        Assertions.assertTrue(e.message!!.contains("[500 INTERNAL SERVER ERROR] during [POST] to [https://httpbin.org/status/500]"), "Exception message should contain HTTP status code")
    }

    @Test
    fun `Feign client should not throw exception when 201 is returned`() {
        // assert exception is thrown
        HttpClients.httpBinClient().status(201)
    }
}