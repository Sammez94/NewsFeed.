package com.samuellaxman.newsfeed;
/**
 * Created by USER on 1/3/2018.
 */

public class DataModel {
    private String mTitle, mDescription, mSource, mAuthor, mImageURL,mUrl;

    public DataModel(String author, String description, String source, String time, String title, String imageURL, String Url) {
        this.mAuthor=author;
        this.mUrl=Url;
        this.mImageURL=imageURL;
        this.mDescription=description;
        this.mSource=source;
        this.mTitle=title;
    }

    public String getImageURL() {
        return mImageURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getSource() {
        return mSource;
    }

    public String getAuthor() {
        return mAuthor;
    }



}

