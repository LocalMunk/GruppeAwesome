package com.example.martindalby.gruppeawesome;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Customadapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public Customadapter(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.activity_opskrift_liste, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_opskrift_liste, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.overskriftTV);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.listeImg);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}