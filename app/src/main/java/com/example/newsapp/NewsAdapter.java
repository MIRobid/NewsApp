package com.example.newsapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOG_TAG=NewsAdapter.class.getSimpleName();

    public NewsAdapter(Context context, List<News> news){
        super(context,0,news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item,parent,false);
        }

        News currentNews = getItem(position);

        TextView sectionTextView = listItemView.findViewById(R.id.section_text_view);
        String originalSection = currentNews.getSection();
        sectionTextView.setText(originalSection);

        // Get the title string from the News object
        String originalTitle = currentNews.getTitle();
        TextView titleView = listItemView.findViewById(R.id.title_text_view);
        titleView.setText(originalTitle);

        // Setting the date
        String formattedDate = currentNews.getDate().substring(0,10);
        TextView dateView = listItemView.findViewById(R.id.date_text_view);
        dateView.setText(formattedDate);

        // Setting the time
        TextView timeView = listItemView.findViewById(R.id.time);
        String formattedTime = currentNews.getDate().substring(11,19);
        timeView.setText(formattedTime);

        TextView authorTextView = listItemView.findViewById(R.id.author_text_view);
        String originalAuthor = "by "+currentNews.getAuthor();
        authorTextView.setText(originalAuthor);

        // Set the proper background color
        Drawable newsBackground = listItemView.getBackground();
        // Get the appropriate background color based on the current news section
        int newsColor = getNewsColor(currentNews.getSection());
        newsBackground.setTint(newsColor);

        // Return the list item view
        return listItemView;
    }

    private int getNewsColor(String section) {
        int base_color;
        switch (section.toLowerCase()) {
            case "football":
            case "sport":
                base_color = R.color.s1;
                break;
            case "environment":
                base_color = R.color.s2;
                break;
            case "film":
                base_color = R.color.s3;
                break;
            case "books":
                base_color = R.color.s4;
                break;
            case "world":
                base_color = R.color.s5;
                break;
            case "politics":
                base_color = R.color.s6;
                break;
            case "us-news":
                base_color = R.color.s7;
                break;
            case "television & radio":
                base_color = R.color.s8;
                break;
            case "business":
                base_color = R.color.s9;
                break;
            default:
                base_color = R.color.s10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),base_color);
    }
}
