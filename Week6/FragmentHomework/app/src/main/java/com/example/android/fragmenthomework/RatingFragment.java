package com.example.android.fragmenthomework;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;


public class RatingFragment extends Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public RatingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_rating, container, false);
        final RatingBar ratingBar = rootView.findViewById(R.id.ratingBar);



        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int value = (int) rating;
                showToastMethod(value  + "");
            }
        });

        return rootView;
    }

    public void showToastMethod(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

}
