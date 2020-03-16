package edu.temple.paletteandcanvas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.temple.paletteandcanvas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String COLORSLOCAL = "colorLabels";
    private static final String COLORSENGLISH = "colorsToParse";

    // TODO: Rename and change types of parameters
    private String[] colorLabels;
    private String[] colorsToParse;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(String[] colorLabels,String[]colorsEnglish) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(COLORSLOCAL, colorLabels);
        args.putStringArray(COLORSENGLISH, colorLabels);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colorLabels = getArguments().getStringArray(COLORSLOCAL);
            colorsToParse = getArguments().getStringArray(COLORSENGLISH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_palette, container, false);

    }

}
