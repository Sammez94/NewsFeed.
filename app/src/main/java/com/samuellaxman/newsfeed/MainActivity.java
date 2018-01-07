package com.samuellaxman.newsfeed;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.samuellaxman.newsfeed.fragments.FragmentManagerAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentManagerAdapter pager = new FragmentManagerAdapter(getSupportFragmentManager(), MainActivity.this);

        viewPager.setAdapter(pager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}

