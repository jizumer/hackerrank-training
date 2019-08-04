package com.jizumer.movietitles;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jizumer.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovietitlesRunner implements Runner {
    @Override
    public void run(String[] args) throws IOException {
        String substr = "spiderman";

        String[] result = null;
        try {
            List<String> titles = new ArrayList<>();

            Integer page = 1;
            Integer pages = Integer.MAX_VALUE;
            while (page <= pages) {
                //System.out.println(String.format("%s,%s", page, pages));
                String pageContent = requestNewPage(titles, substr, page.toString());

                pages = addPage(titles, pageContent.toString());
                page++;
            }

            Collections.sort(titles);
            titles.forEach(System.out::println);
            result = new String[titles.size()];
            result = titles.toArray(result);


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static String requestNewPage(List<String> titles, String query, String page) throws IOException {
        URL url;
        if (page == null) {
            url = new URL(String.format("https://jsonmock.hackerrank.com/api/movies/search/?Title=%s", query));
        } else {
            url = new URL(String.format("https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%s", query, page));
        }
        //System.out.println(url.toString());
        HttpURLConnection con = null;

        con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();

    }

    public static <JsonElement> Integer addPage(List<String> titles, String jsonLine) {
        boolean morePagesExists = false;
        com.google.gson.JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();

        Integer pages = jobject.get("total_pages").getAsInt();
        System.out.println(String.format("Total pages: %s", pages));

        JsonArray jarray = jobject.getAsJsonArray("data");

        List<String> result = new ArrayList<>();

        for (int i = 0; i < jarray.size(); i++) {
            jobject = jarray.get(i).getAsJsonObject();
            String title = jobject.get("Title").getAsString();
            result.add(title);
        }

        titles.addAll(result);
        return pages;
    }
}
