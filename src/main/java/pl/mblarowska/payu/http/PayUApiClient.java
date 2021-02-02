package pl.mblarowska.payu.http;

import pl.mblarowska.payu.exceptions.PayUException;

import java.net.http.HttpResponse;
import java.util.Map;

public interface PayUApiClient {
    HttpResponse<String> post(String url, String body, Map<String, String> headers) throws PayUException;
}
