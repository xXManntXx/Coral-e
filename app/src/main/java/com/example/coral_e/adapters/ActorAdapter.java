package com.example.coral_e.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coral_e.R;
import com.example.coral_e.actors.Actor;
import com.example.coral_e.laws.Law;

import java.util.List;

public class ActorAdapter extends BaseAdapter {

    private Context context;
    private List<Actor> actorList;
    private LayoutInflater inflater;

    public ActorAdapter(Context myContext, List<Actor> myActorList) {
        this.context = myContext;
        this.actorList = myActorList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return actorList.size();
    }

    @Override
    public Actor getItem(int position) {
        return actorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_actor, null);

        //get info about the item
        Actor currentActor = getItem(position);
        String actorName = currentActor.getActorName();
        String actorDescription = currentActor.getActorDescription();
        int actorBudget = currentActor.getActorBudget();

        //link the view with the info
        TextView actorNameView = convertView.findViewById(R.id.actor_name);
        actorNameView.setText(actorName);

        TextView actorDescriptionView = convertView.findViewById(R.id.actor_description);
        actorDescriptionView.setText(actorDescription);

        TextView actorBudgetView = convertView.findViewById(R.id.actor_budget);
        actorBudgetView.setText(actorBudget + "M€");

        return convertView;
    }
}
