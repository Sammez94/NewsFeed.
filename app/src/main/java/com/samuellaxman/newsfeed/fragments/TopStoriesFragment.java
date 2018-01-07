package com.samuellaxman.newsfeed.fragments;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.samuellaxman.newsfeed.DataModel;
import com.samuellaxman.newsfeed.ListViewAdapter;
;

import java.util.ArrayList;

/**
 * Created by USER on 12/27/2017.
 */

public class TopStoriesFragment extends Fragment {

    private static final String URL_DATA = "https://api.github.com/search/users?q=language:java+location:lagos";
    private ListViewAdapter adapter;
    private ArrayList<DataModel> mDataModels;
    private ListView listView;

    public TopStoriesFragment() {
    }

/**
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.custom_listview, container, false);

        // Create a list of news
        final ArrayList<DataModel> news = new ArrayList<DataModel>();
        //this will be added in the try block of the onResponse method below
//        news.add(new DataModel("one", "lutti", 2));
  //      news.add(new DataModel("two", "otiiko", 2));
    //    news.add(new DataModel("three", "tolookosu", 2));

        // Create an {@link newsadapter}, whose data source is a list of {@link new}s. The
        // adapter knows how to create list items for each item in the list.
        ListViewAdapter adapter = new ListViewAdapter(getActivity(), news);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                            }

                                        }

        );
        loadUrlData();
        return rootView;

    }

    private void loadUrlData() {

        /** final ProgressDialog progressDialog = new ProgressDialog(this);
         progressDialog.setMessage("Loading...\nPlease wait...");
         progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //   progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray array = jsonObject.getJSONArray("items");

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject jo = array.getJSONObject(i);

                        //  UsersList users = new UsersList(jo.getString("login"), jo.getString("html_url"),
                        //        jo.getString("avatar_url"));
                        // usersLists.add(users);

                    }

                    adapter = new ListViewAdapter(getContext(), mDataModels);
                    listView.setAdapter(adapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }*/

}


