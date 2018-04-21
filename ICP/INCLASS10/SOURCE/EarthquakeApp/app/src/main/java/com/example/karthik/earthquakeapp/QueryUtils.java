package com.example.karthik.earthquakeapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik on 11/3/17.
 */

public class QueryUtils {

    /** Tag for the log messages */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Query the USGS dataset and return a list of {@link Earthquake} objects.
     */
    public static List<Earthquake> fetchEarthquakeData2(String requestUrl) {
        // An empty ArrayList that we can start adding earthquakes to
        List<Earthquake> earthquakes = new ArrayList<>();
        //  URL object to store the url for a given string
        URL url = null;
        // A string to store the response obtained from rest call in the form of string
        String jsonResponse = "";
        try {
            public static List<Earthquake> fetchEarthquakeData2(String requestUrl){
                // An empty ArrayList that we can start adding earthquakes to
                List<Earthquake> earthquakes = new ArrayList<>();
                URL url = createUrl(requestUrl);
                String jsonResponse = null;
                try
                {
                    jsonResponse = makehttpRequest(url);
                }catch (IOException e){
                    Log.e(LOG_TAG,"Error in making http request",e);
                }
                List<Earthquake> result = extractEarthquakes(jsonResponse);
                return result;
            }
        private static URL createUrl(String stringUrl){
            URL url = null;
            try
            {
                url = new URL(stringUrl);
            }catch (MalformedURLException e){
                Log.e(LOG_TAG,"Error in Creating URL",e);
            }
            return url;
        }

        private static String makehttpRequest(URL url) throws IOException{
            String jsonResponse = "";
            if(url == null){
                return jsonResponse;
            }

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG, "Error in connection!! Bad Response ");
                }

            }catch (IOException e){
                Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
            } finally {
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
                if(inputStream != null){
                    inputStream.close();
                }
            }

            return jsonResponse;

        }
        private static String readFromStream(InputStream inputStream) throws IOException{
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }
        private static List<Earthquake> extractEarthquakes(String earthquakeJSON){
            if (TextUtils.isEmpty(earthquakeJSON)) {
                return null;
            }
            ArrayList<Earthquake>  earthquakes = new ArrayList<>();
            try {
                JSONObject baseJsonResponse = new JSONObject(earthquakeJSON);
                JSONArray featureArray = baseJsonResponse.getJSONArray("features");

                for (int i = 0; i < featureArray.length(); i++) {
                    JSONObject currentEarthquake = featureArray.getJSONObject(i);
                    JSONObject properties = currentEarthquake.getJSONObject("properties");

                    double magnitude = properties.getDouble("mag");
                    String location = properties.getString("place");
                    long time = properties.getLong("time");
                    String Url = properties.getString("url");
                    Earthquake earthquake = new Earthquake(magnitude, location, time,Url);
                    earthquakes.add(earthquake);
                }

            }catch (JSONException e){
                Log.e(LOG_TAG,"Error in fetching data",e);
            }
            return earthquakes;
        }

        }






            // Return the list of earthquakes

        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception:  ", e);
        }
        // Return the list of earthquakes
        return earthquakes;
    }



}
