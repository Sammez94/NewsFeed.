package com.samuellaxman.newsfeed.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.samuellaxman.newsfeed.DataModel;
import com.samuellaxman.newsfeed.ListViewAdapter;
import com.samuellaxman.newsfeed.MainActivity;
import com.samuellaxman.newsfeed.R;
import com.samuellaxman.newsfeed.StoryActivity;;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by USER on 12/27/2017.
 */

public class TopStoriesFragment extends Fragment {
    private static final String URL_DATAaljazeera =
            "https://newsapi.org/v2/top-headlines?sources=al-jazeera-english&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAabcnews =
            "https://newsapi.org/v2/top-headlines?sources=abc-news&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAAP =
            "https://newsapi.org/v2/top-headlines?sources=associated-press&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAcnn =
            "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAfox =
            "https://newsapi.org/v2/top-headlines?sources=fox-news&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAgoogle =
            "https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAnews24 =
            "https://newsapi.org/v2/top-headlines?sources=news24&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAtime =
            "https://newsapi.org/v2/top-headlines?sources=engadget&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";


    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_URL = "url";


    private List<DataModel> newsLists;
    ListViewAdapter listViewAdapter;
    ListView listView;

    public TopStoriesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.custom_listview, container, false);


        newsLists = new ArrayList<>();
        Collections.shuffle(newsLists);

        listView = (ListView) rootView.findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                DataModel model = newsLists.get(position);

                Intent intent = new Intent(getContext(), StoryActivity.class);
                intent.putExtra(KEY_AUTHOR, model.getAuthor());
                intent.putExtra(KEY_TITLE, model.getTitle());
                intent.putExtra(KEY_SOURCE, model.getSource());
                intent.putExtra(KEY_DESCRIPTION, model.getDescription());
                intent.putExtra(KEY_IMAGE, model.getImageURL());
                intent.putExtra(KEY_URL, model.getUrl());
                startActivity(intent);
            }

        });

        httpRequest();
        return rootView;
    }


    public void httpRequest() {

        final StringRequest abcInsiderStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAabcnews, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        StringRequest aljazeraStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAaljazeera, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        StringRequest APStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAAP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        StringRequest cnnStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAcnn, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        final StringRequest foxStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAfox, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        StringRequest GoogleStringRequest = new StringRequest(Request.Method.GET,
                 URL_DATAgoogle, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        StringRequest News24StringRequest = new StringRequest(Request.Method.GET,
                URL_DATAnews24, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        StringRequest timeStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAtime, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jo = jsonArray.getJSONObject(i);

                        DataModel model = new DataModel(jo.getString("author"), jo.getString("description"),
                                jo.getJSONObject("source").getString("name"), jo.getString("publishedAt")
                                , jo.getString("title"), jo.getString("urlToImage"), jo.getString("url"));
                        newsLists.add(model);

                    }

                    listViewAdapter = new ListViewAdapter(getContext(), newsLists);
                    listView.setAdapter(listViewAdapter);
                    Collections.shuffle(newsLists);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(abcInsiderStringRequest);
        requestQueue.add(aljazeraStringRequest);
        requestQueue.add(APStringRequest);
        requestQueue.add(cnnStringRequest);
        requestQueue.add(foxStringRequest);
        requestQueue.add(News24StringRequest);
        requestQueue.add(timeStringRequest);
        requestQueue.add(GoogleStringRequest);

    }


}

