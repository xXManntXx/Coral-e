package com.example.coral_e.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coral_e.R;
import com.example.coral_e.laws.Law;

import java.util.List;

public class LawAdapter extends BaseAdapter {

    private Context context;
    private List<Law> lawList;
    private LayoutInflater inflater;

    public LawAdapter(Context myContext, List<Law> myLawList) {
        this.context = myContext;
        this.lawList = myLawList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lawList.size();
    }

    @Override
    public Law getItem(int position) {
        return lawList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_law, null);

        //get info about the item
        Law currentLaw = getItem(position);
        String lawName = currentLaw.getLawName();
        String lawContent = currentLaw.getLawContent();

        //link the view with the info
        TextView lawNameView = convertView.findViewById(R.id.law_name);
        lawNameView.setText(lawName);

        TextView lawContentView = convertView.findViewById(R.id.law_content);
        lawContentView.setText(lawContent);

        return convertView;
    }
}
