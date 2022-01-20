import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.cio.CIO;
import io.ktor.client.request.BuildersWithUrlKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilderJvmKt;
import io.ktor.http.Url;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

public class Main {

    public static void main(String[] args) {
        var engine = CIO.INSTANCE.create(cioEngineConfig -> Unit.INSTANCE);
        var config = new HttpClientConfig<>();
        var client = new HttpClient(engine, config);
        var url = URLBuilderJvmKt.invoke(Url.Companion, "https://ktor.io");
        var httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());

        var httpStatement = new HttpStatement(httpRequestBuilder, client);

        try {
            var httpResponse = BuildersKt.runBlocking(
                    GlobalScope.INSTANCE.getCoroutineContext(),
                    (Function2<CoroutineScope, Continuation<? super HttpResponse>, Object>) (coroutineScope, continuation) ->
                            httpStatement.execute(continuation)
            );

            System.out.println(httpResponse.getStatus());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
