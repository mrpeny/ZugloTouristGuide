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


public class FreetimeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        List<Location> freetimeList = new ArrayList<>();

        freetimeList.add(new Location(
                getString(R.string.ice_rink_title),
                getString(R.string.ice_rink_description),
                getString(R.string.ice_rink_url),
                R.drawable.ice_rink));
        freetimeList.add(new Location(
                getString(R.string.paskal_thermal_baths_title),
                getString(R.string.paskal_thermal_baths_description),
                getString(R.string.paskal_thermal_baths_url),
                R.drawable.paskal_bath));
        freetimeList.add(new Location(
                getString(R.string.circus_title),
                getString(R.string.circus_description),
                getString(R.string.circus_url),
                R.drawable.circus));
        freetimeList.add(new Location(
                getString(R.string.zoo_title),
                getString(R.string.zoo_description),
                getString(R.string.zoo_url),
                R.drawable.zoo));
        freetimeList.add(new Location(
                getString(R.string.szechenyi_thermal_baths_title),
                getString(R.string.szechenyi_thermal_baths_description),
                getString(R.string.szechenyi_thermal_baths_url),
                R.drawable.szechenyi_thermal_bath));

        RecyclerView recyclerList = (RecyclerView) rootView.findViewById(R.id.card_list);
        recyclerList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(linearLayoutManager);

        LocationAdapter locationAdapter = new LocationAdapter(freetimeList);
        recyclerList.setAdapter(locationAdapter);

        return rootView;
    }
}
