package edu.temple.paletteandcanvas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

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

    OnColorSelectedListener parentActivity;

    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    public interface OnColorSelectedListener {
        public void onColorSelected(String colorString);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnColorSelectedListener) {
            parentActivity = (OnColorSelectedListener) context;
        } else {
            throw new RuntimeException("Please Implement the OnColorSelectedListener Interface");
        }

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
        View v = inflater.inflate(R.layout.fragment_palette, container, false);
        ColorAdapter colorAdapter = new ColorAdapter(container.getContext(),colorsToParse,colorLabels);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0)
                    parentActivity.onColorSelected(colorsToParse[position]);
                else
                    parentActivity.onColorSelected("WHITE");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        // Inflate the layout for this fragment
        return v;

    }

}
