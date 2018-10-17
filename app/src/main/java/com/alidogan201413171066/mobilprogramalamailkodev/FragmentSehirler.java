package com.alidogan201413171066.mobilprogramalamailkodev;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alido on ...
 */

public class FragmentSehirler extends Fragment {

    ListView lv;
    ArrayAdapter<String> adapter;
    EditText et;
    public String[] sehirler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frg_sehirler,container,false);
        sehirler = new String[]{
                "Adana","Adıyaman","Afyonkarahisar","Ağrı","Aksaray","Amasya","Ankara","Antalya","Ardahan","Artvin","Aydın",
                "Balıkesir","Bartın","Batman","Bayburt","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa",
                "Çanakkale","Çankırı","Çorum",
                "Denizli","Diyarbakır","Düzce",
                "Edirne","Elazığ","Erzincan","Erzurum","Eskişehir",
                "Gaziantep","Giresun","Gümüşhane",
                "Hakkâri","Hatay",
                "Iğdır","Isparta",
                "İstanbul","İzmir",
                "Kahramanmaraş","Karaman","Karabük","Kars","Kastamonu","Kayseri","Kırıkkale","Kırklareli","Kırşehir","Kilis","Kocaeli","Konya","Kütahya",
                "Malatya","Manisa","Mardin","Mersin","Muğla","Muş",
                "Nevşehir","Niğde",
                "Ordu","Osmaniye",
                "Rize",
                "Sakarya","Samsun","Siirt","Sinop","Sivas",
                "Tekirdağ","Tokat","Trabzon","Tunceli",
                "Şanlıurfa","Şırnak",
                "Uşak",
                "Van",
                "Yalova","Yozgat",
                "Zonguldak"};

        lv = (ListView) view.findViewById(R.id.lv_sehirler);

        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                sehirler
        );

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str  ;
                String value = (String)parent.getItemAtPosition(position);
                str ="https://tr.m.wikipedia.org/wiki/"+value;
                Intent intent1 = new Intent(getActivity(), Wikipedia.class);
                intent1.putExtra("send_string",str);
                startActivity(intent1);
                Toast.makeText(getActivity(),value+" Hakkında Bilgiler",Toast.LENGTH_LONG).show();
            }
        });

        et = (EditText) view.findViewById(R.id.sehirAra);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FragmentSehirler.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

}
