package com.alidogan201413171066.mobilprogramalamailkodev;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alido on 28.03.2017.
 */

public class FragmentTurkiye extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bu fragment'in layout'unu hazır hale getirelim
        View myView = (View) inflater.inflate(R.layout.frg_turkey, container, false);
        return myView;
    }
}
