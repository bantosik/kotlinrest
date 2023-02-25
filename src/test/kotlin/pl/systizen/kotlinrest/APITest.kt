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
}