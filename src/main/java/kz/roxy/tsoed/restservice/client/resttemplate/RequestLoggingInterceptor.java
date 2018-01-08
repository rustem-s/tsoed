package kz.roxy.tsoed.restservice.client.resttemplate;

import com.google.common.io.ByteStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.Charset;

public class RequestLoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);

        LOGGER.info("request method: {},\n" +
                "request URI: {},\n" +
                "request headers: {},\n" +
                "request body: {},\n" +
                "response status code: {},\n" +
                "response headers: {},\n" +
                "response body: {}",
                request.getMethod(),
                request.getURI(),
                request.getHeaders(),
                new String(body, Charset.forName("UTF-8")),
                response.getStatusCode(),
                response.getHeaders(),
                new String(ByteStreams.toByteArray(response.getBody()), Charset.forName("UTF-8"))
        );

        return response;
    }
}