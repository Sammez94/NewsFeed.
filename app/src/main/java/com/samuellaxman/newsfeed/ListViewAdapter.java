package com.samuellaxman.newsfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.samuellaxman.newsfeed.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by USER on 1/3/2018.
 */

public class ListViewAdapter extends ArrayAdapter<DataModel> {

    public ListViewAdapter(Context context, List<DataModel> models) {
        super(context, 0, models);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview = convertView;
        if (listitemview == null)
            listitemview = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_layout, parent, false);

        DataModel currentmodel = getItem(position);
        TextView titleTV = (TextView) listitemview.findViewById(R.id.topicTV);
        TextView descriptionTV = (TextView) listitemview.findViewById(R.id.descriptionTV);
        TextView authorTV = (TextView) listitemview.findViewById(R.id.authorTV);
        TextView sourceTV = (TextView) listitemview.findViewById(R.id.sourceTV);
        ImageView imageView = (ImageView) listitemview.findViewById(R.id.imageUrlview);

        Picasso.with(getContext())
                .load(currentmodel.getImageURL())
                .resize(192,192 )
                .into(imageView);

        descriptionTV.setText(currentmodel.getDescription());
        authorTV.setText("Author "+currentmodel.getAuthor());
        sourceTV.setText(currentmodel.getSource());
        titleTV.setText(currentmodel.getTitle());

        return listitemview;
    }
}

