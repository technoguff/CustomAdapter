package com.technoguff.customadapterexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darshanz on 7/13/15.
 */
public class CustomAdapter extends ArrayAdapter<AndroidVersion> {


    private ArrayList<AndroidVersion> mVersionList;
    private LayoutInflater inflater;

    public CustomAdapter(Activity activity, int resource, ArrayList<AndroidVersion> objects) {
        super(activity, resource, objects);

        mVersionList = objects;
        inflater = activity.getLayoutInflater();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder  holder;


        if(convertView == null){
            convertView = inflater.inflate(R.layout.layout_item, null);
            holder = new ViewHolder();
            holder.tvCodeName = (TextView)convertView.findViewById(R.id.codeName);
            holder.tvVersion = (TextView)convertView.findViewById(R.id.version);
            holder.ivIcon = (ImageView)convertView.findViewById(R.id.ivIcon);

            convertView.setTag(holder);

        }else{

            holder = (ViewHolder)convertView.getTag();
        }


        AndroidVersion version = mVersionList.get(position);

        holder.tvCodeName.setText(version.getCodeName());
        holder.tvVersion.setText(version.getVersion());
        holder.ivIcon.setImageResource(version.getIcon());



        return convertView;
    }

    class ViewHolder{
        ImageView ivIcon;
        TextView tvCodeName;
        TextView tvVersion;
    }

}
