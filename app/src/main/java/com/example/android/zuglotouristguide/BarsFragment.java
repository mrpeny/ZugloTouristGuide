package com.example.android.zuglotouristguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class BarsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        List<Location> barList = new ArrayList<>();

        barList.add(new Location(
                getString(R.string.kertem_title),
                getString(R.string.kertem_description),
                getString(R.string.kertem_address)));
        barList.add(new Location(
                getString(R.string.pantlika_title),
                getString(R.string.pantlika_description),
                getString(R.string.pantlika_address)));
        barList.add(new Location(
                getString(R.string.durer_kert_title),
                getString(R.string.durer_kert_description),
                getString(R.string.durer_kert_address)));
        barList.add(new Location(
                getString(R.string.varosliget_cafe_title),
                getString(R.string.varosliget_cafe_description),
                getString(R.string.varosliget_cafe_address)));
        barList.add(new Location(
                getString(R.string.pedal_bar_title),
                getString(R.string.pedal_bar_description),
                getString(R.string.pedal_bar_address)));

        RecyclerView recyclerList = (RecyclerView) rootView.findViewById(R.id.card_list);
        recyclerList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(linearLayoutManager);

        LocationAdapter locationAdapter = new LocationAdapter(barList);
        recyclerList.setAdapter(locationAdapter);

        return rootView;
    }
}
