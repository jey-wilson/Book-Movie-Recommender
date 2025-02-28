package com.yourproject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
    	// code from testing if the movie API worked
    	/*
    	 * try {
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
        */
    	
    	// get user input for title and author of a book they like
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Enter a book title: ");
    	String bookTitle = scan.nextLine();
    	System.out.print("Enter the author: ");
    	String authorName = scan.nextLine();
    	
    	//fetch the book data from open library API
    	try {
    	URL url = new URL("https://openlibrary.org/search.json?title=" + bookTitle + "&author=" + authorName);
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	conn.setRequestMethod("GET");
    	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	StringBuilder response = new StringBuilder();
    	String line;
    	while ((line = reader.readLine()) != null) {
    	    response.append(line);
    	}
    	reader.close();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	scan.close();

    }
    
}