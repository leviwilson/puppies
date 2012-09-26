package com.leandog.puppies.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PuppiesLoader {

    public List<Puppy> load() {
        try {
            final HttpResponse response = new DefaultHttpClient().execute(new HttpGet("http://puppies.herokuapp.com/puppies.json"));
            Type collectionType = new TypeToken<List<Puppy>>(){}.getType();
            return new Gson().fromJson(getMessage(response), collectionType);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMessage(final HttpResponse response) throws IllegalStateException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder message = new StringBuilder();
        String line;

        while (null != (line = reader.readLine())) {
            message.append(line);
        }

        return message.toString();
    }
}
