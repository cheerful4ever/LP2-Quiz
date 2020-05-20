package com.myapplicationdev.android.lp2_quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ToDo> {
    Context context;
    ArrayList<ToDo> toDos;
    int resource;
    TextView textViewData, textViewDate, textViewID;

    public CustomAdapter(Context context, int resource, ArrayList<ToDo> toDos) {
        super(context, resource, toDos);
        this.context = context;
        this.toDos = toDos;
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        textViewData = (TextView)rowView.findViewById(R.id.tvDATA);
        textViewDate = (TextView)rowView.findViewById(R.id.tvDATE);
        textViewID = (TextView)rowView.findViewById(R.id.tvID);

        ToDo todo = toDos.get(position);

        textViewData.setText(todo.getData());
        textViewDate.setText(todo.getDate());
        textViewID.setText(Integer.toString(todo.getId()));

        return rowView;
    }
}
