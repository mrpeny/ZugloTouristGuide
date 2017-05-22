package com.example.android.zuglotouristguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private static final String geoBegin = "geo:0,0?q=";
    private List<Location> locationList;

    LocationAdapter(List<Location> locationList) {
        this.locationList = locationList;
    }

    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final LocationAdapter.LocationViewHolder viewHolder, int position) {
        final Location location = locationList.get(position);

        viewHolder.titleTextView.setText(location.getTitle());
        viewHolder.descriptionTextView.setText(location.getDescription());

        /*
        * If Location has no image then it is a bar that has address which can be viewed
        * by sending an explicit intent to a component registered showing addresses
        */
        if (!location.hasImage()) {
            viewHolder.imageView.setVisibility(View.GONE);
            viewHolder.button.setText(R.string.show_location);
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    String address = location.getAddress();
                    address = Uri.encode(address);
                    address = geoBegin + address;
                    intent.setData(Uri.parse(address));
                    if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                        v.getContext().startActivity(intent);
                    }
                }
            });
        } else {
            viewHolder.imageView.setImageResource(location.getImageResourceId());
        }

        /*
        * If Location has no address then it is either a sight or a museum or freetime activity
        */
        if (!location.hasAddress()) {
            /*
            * If Location has no URL either then it is a sight otherwise it is a museum or
            * freetime activity
            */
            if (!location.hasUrl()) {
                viewHolder.button.setVisibility(View.GONE);
            } else {
                viewHolder.button.setText(R.string.learn_more);
                viewHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri webpage = Uri.parse(location.getUrl());
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                            v.getContext().startActivity(intent);
                        }
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    static class LocationViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;
        Button button;

        LocationViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.cardview_image);
            this.titleTextView = (TextView) itemView.findViewById(R.id.cardview_title);
            this.descriptionTextView = (TextView) itemView.findViewById(R.id.cardview_description);
            this.button = (Button) itemView.findViewById(R.id.cardview_button);
        }
    }
}
