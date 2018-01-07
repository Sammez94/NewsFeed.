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

public class BusinessFragment extends Fragment {
    private static final String URL_DATA =
            "https://newsapi.org/v2/top-headlines?sources=business-insider&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAcnbc =
            "https://newsapi.org/v2/top-headlines?sources=cnbc&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAbloom =
            "https://newsapi.org/v2/top-headlines?sources=bloomberg&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";
    private static final String URL_DATAwsj =
            "https://newsapi.org/v2/top-headlines?sources=the-wall-street-journal&apiKey=2c62bf6a65e74f0b8c06ba6dc09b0c40";


    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_URL = "url";


    private List<DataModel> newsLists;
    ListViewAdapter listViewAdapter;
    ListView listView;

    public BusinessFragment() {
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

        final StringRequest businessInsiderStringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
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

        StringRequest CnbcStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAcnbc, new Response.Listener<String>() {
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

        StringRequest BloomStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAbloom, new Response.Listener<String>() {
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

        StringRequest WSJStringRequest = new StringRequest(Request.Method.GET,
                URL_DATAwsj, new Response.Listener<String>() {
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
        requestQueue.add(businessInsiderStringRequest);
        requestQueue.add(CnbcStringRequest);
        requestQueue.add(WSJStringRequest);
        requestQueue.add(BloomStringRequest);
    }


}

