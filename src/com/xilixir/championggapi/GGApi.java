package com.xilixir.championggapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.xilixir.championggapi.api.APIException;
import com.xilixir.championggapi.api.Objects.ChampionData;
import com.xilixir.championggapi.api.Objects.ChampionDataDetailed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

// Written by Xilixir on 12/30/2015
public class GGApi {
    public GGApi(String apiKey) {
        this.apiKey = apiKey;
        this.gson = new GsonBuilder().disableHtmlEscaping().create();
    }

    private Gson gson;
    private String mainURL = "http://api.champion.gg/";
    private String apiKey = "aaa123";

    public List<ChampionData> getChampionData() throws APIException {
        String str = getUrlSource(mainURL + "champion" + "?api_key=" + apiKey);
        return gson.fromJson(str, new TypeToken<List<ChampionData>>(){}.getType());
    }

    public ChampionDataDetailed getChampionData(String championName) throws APIException {
        String str = getUrlSource(mainURL + "champion/" + championName + "?api_key=" + apiKey);
        List<ChampionDataDetailed> det = gson.fromJson(str, new TypeToken<List<ChampionDataDetailed>>(){}.getType());
        if (det != null && det.size() > 0) {
            return det.get(0);
        } else {
            return null;
        }
    }

    private String getUrlSource(String link) throws APIException {
        HttpURLConnection httpConnection = null;
        try {
            URL url = new URL(link);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.addRequestProperty("User-Agent", "Mozilla/4.0");
            URLConnection connection = url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setInstanceFollowRedirects(false);
            connection.connect();

            if (connection instanceof HttpURLConnection) {
                int code = httpConnection.getResponseCode();
                if (code != 200) {
                    throw new APIException(code);
                } else {
                    BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), "UTF-8"));
                    String inputLine;
                    StringBuilder a = new StringBuilder();
                    while ((inputLine = in.readLine()) != null)
                        a.append(inputLine);
                    in.close();
                    httpConnection.disconnect();
                    return a.toString();
                }
            } else {
                System.err.println("Error - Not an HTTP request");
            }
            httpConnection.disconnect();
        } catch (IOException ex){
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
            ex.printStackTrace();
        }
        return null;
    }
}
