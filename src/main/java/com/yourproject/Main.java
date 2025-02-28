package com.yourproject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/3/movie/popular?api_key=302dc57bca82ca1e3014c074c55dfbb9")
                    .build();

            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();

            // Parse JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            System.out.println("First Popular Movie: " + rootNode.get("results").get(0).get("title").asText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}