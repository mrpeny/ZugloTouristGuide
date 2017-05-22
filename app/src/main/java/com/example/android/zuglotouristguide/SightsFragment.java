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


public class SightsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        List<Location> sightList = new ArrayList<>();

        sightList.add(new Location(
                getString(R.string.heroes_square_title),
                getString(R.string.heroes_square_description),
                R.drawable.heroes_quare));
        sightList.add(new Location(
                getString(R.string.vajdahunyad_castle_title),
                getString(R.string.vajdahunyad_castle_description),
                R.drawable.vajdahunyad_castle));
        sightList.add(new Location(
                getString(R.string.timewheel_title),
                getString(R.string.timewheel_description),
                R.drawable.timewheel));
        sightList.add(new Location(
                getString(R.string.anonymus_title),
                getString(R.string.anonymus_description),
                R.drawable.anonymus_sculpture));
        sightList.add(new Location(
                getString(R.string.millenaris_velodrom_title),
                getString(R.string.millenaris_velodrom_description),
                R.drawable.millenaris));

        RecyclerView recyclerList = (RecyclerView) rootView.findViewById(R.id.card_list);
        recyclerList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(linearLayoutManager);

        LocationAdapter locationAdapter = new LocationAdapter(sightList);
        recyclerList.setAdapter(locationAdapter);

        return rootView;
    }
}
