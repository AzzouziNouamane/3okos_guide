package com.e3okoss.tesGuide;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.e3okoss.tesGuide.tools.Constants;
import com.e3okoss.tesGuide.tools.Page4Model;
import com.e3okoss.tesGuide.tools.TinyDB;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SliderItemFragment extends Fragment {

    TinyDB tinyDB;
    private static final String ARG_POSITION = "slider-position";


    private int position;

    public SliderItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     *
     * @return A new instance of fragment SliderItemFragment.
     */

    public static SliderItemFragment newInstance(int position) {
        SliderItemFragment fragment = new SliderItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tinyDB = new TinyDB(getContext());
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_item, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set page background

        ArrayList<Page4Model> page4Models = tinyDB.getListObject(Constants.JSON_LIST);

        if(!page4Models.get(position).getBackgroundColor().isEmpty()) {
            view.setBackgroundColor(Color.parseColor(page4Models.get(position).getBackgroundColor()));
        }

        TextView title = view.findViewById(R.id.textView);
        TextView contentText = view.findViewById(R.id.textView2);
        ImageView imageView = view.findViewById(R.id.imageView);

        // set page title
        title.setText(page4Models.get(position).getTitle());
        title.setTextColor(!page4Models.get(position).getTitleColor().isEmpty() ? Color.parseColor(page4Models.get(position).getTitleColor()) :
                ContextCompat.getColor(getContext(), R.color.black));
        // set page sub title text
        contentText.setText(page4Models.get(position).getStartText());
        contentText.setTextColor(!page4Models.get(position).getStartColor().isEmpty() ? Color.parseColor(page4Models.get(position).getStartColor()) :
                ContextCompat.getColor(getContext(), R.color.black));

        // set page image
        if(!page4Models.get(position).getImage().isEmpty()) {
            Picasso.get().load(page4Models.get(position).getImage())
                    .resize(Constants.getScreenSize(getActivity(), true)/2, Constants.getScreenSize(getActivity(), true)/2).into(imageView);
        }
    }
}