package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private final String url = "https://http.cat";

    public String getStatusImage(int code) throws IOException {
        String imageUrl = url + "/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
        connection.setRequestMethod("HEAD");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return imageUrl;
        } else {
            return "There is not image for HTTP status " + code;
        }
    }
}
