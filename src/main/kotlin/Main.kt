import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

suspend fun main() = run {
    val client = HttpClient(CIO)
    val response = client.get<HttpResponse>("https://ktor.io/")
    println(response.status)
}
