package com.orunmila.net;

import com.orunmila.config.Config;
import com.orunmila.net.resources.Resource;
import okhttp3.*;

import java.io.IOException;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public class API {
    private static String BASE_URL = Config.get("apiBaseUrl");

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient httpClient;

    public static String makeRequest(Resource resource) throws IOException {
        OkHttpClient client = getHttpClient();
        Request.Builder requestBuilder = new Request.Builder()
                .url(url(resource.getPath()));

        if(resource.getMethod().equals(RequestMethod.POST)) {
            RequestBody body = RequestBody.create(JSON, (String)resource.getPayload());
            requestBuilder.post(body);
        }

        Response response = client.newCall(requestBuilder.build()).execute();
        return response.body().string();
    }

    private static String url(String path) {
        return BASE_URL + path;
    }

    private static OkHttpClient getHttpClient() {
        if(httpClient == null) {
            httpClient = new OkHttpClient();
        }
        return httpClient;
    }
}
