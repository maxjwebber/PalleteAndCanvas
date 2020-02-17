package edu.temple.paletteandcanvas;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter
{
    boolean isDropped;
    private Context context;
    private String[] colors;

    public ColorAdapter(Context context, String[] colors)
    {
        this.context=context;
        this.colors=colors;
        this.isDropped = false;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public String getItem(int position)
    {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public TextView getView(int position, View convertView, ViewGroup parent)
    {
        TextView textView = new TextView(context);
        textView.setText(colors[position]);
        return textView;
    }

    @Override
    public TextView getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = getView(position,convertView,parent);
        if (position>0)
            textView.setBackgroundColor(Color.parseColor(colors[position]));
        return textView;
    }
}
