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


public class MuseumsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        List<Location> museumList = new ArrayList<>();

        museumList.add(new Location(
                getString(R.string.agricultural_museum_title),
                getString(R.string.agricultural_museum_description),
                getString(R.string.agricultural_museum_url),
                R.drawable.agricultural_museum));
        museumList.add(new Location(
                getString(R.string.geological_institute_title),
                getString(R.string.geological_institute_description),
                getString(R.string.geological_institute_url),
                R.drawable.geological_institute));
        museumList.add(new Location(
                getString(R.string.museum_of_fine_arts_title),
                getString(R.string.museum_of_fine_arts_description),
                getString(R.string.museum_of_fine_arts_url),
                R.drawable.museum_of_fine_arts));
        museumList.add(new Location(
                getString(R.string.transportation_museum_title),
                getString(R.string.transportation_museum_description),
                getString(R.string.transportation_museum_url),
                R.drawable.transportation_museum));
        museumList.add(new Location(
                getString(R.string.hall_of_arts_title),
                getString(R.string.hall_of_arts_description),
                getString(R.string.hall_of_arts_url),
                R.drawable.hall_of_arts));

        RecyclerView recyclerList = (RecyclerView) rootView.findViewById(R.id.card_list);
        recyclerList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(linearLayoutManager);

        LocationAdapter locationAdapter = new LocationAdapter(museumList);
        recyclerList.setAdapter(locationAdapter);

        return rootView;
    }
}
