package com.alidogan201413171066.mobilprogramalamailkodev;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    ViewPager viewPager;
    ImageAdapter adapter;
    Button btn_plaka;
    ImageView iv;
    EditText et;
    TextView tv;
    LinearLayout ly;


    String[] sehirler = new String[]{
            "Adana","Adıyaman","Afyonkarahisar","Ağrı","Amasya","Ankara","Antalya","Artvin","Aydın",
            "Balıkesir","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa",
            "Çanakkale","Çankırı","Çorum",
            "Denizli","Diyarbakır",
            "Edirne","Elazığ","Erzincan","Erzurum","Eskişehir",
            "Gaziantep","Giresun","Gümüşhane",
            "Hakkâri","Hatay",
            "Isparta","Mersin (İçel)",
            "İstanbul","İzmir",
            "Kars","Kastamonu","Kayseri","Kırklareli","Kırşehir","Kocaeli","Konya","Kütahya",
            "Malatya","Manisa","Kahramanmaraş","Mardin","Muğla","Muş",
            "Nevşehir","Niğde","Ordu","Rize",
            "Sakarya","Samsun","Siirt","Sinop","Sivas",
            "Tekirdağ","Tokat","Trabzon","Tunceli",
            "Şanlıurfa","Uşak","Van","Yozgat","Zonguldak",
            "Aksaray","Bayburt","Kırıkkale","Karaman",
            "Batman","Şırnak","Bartın","Ardahan","Iğdır",
            "Yalova","Karabük","Kilis","Osmaniye","Düzce"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imageView);
        manager = getFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        tv = (TextView) findViewById(R.id.plaka_sehir);
        btn_plaka = (Button) findViewById(R.id.btn_plaka);
        ly= (LinearLayout) findViewById(R.id.ly_plaka_ara);
        et= (EditText) findViewById(R.id.editText);

        btn_plaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ly.setVisibility(View.VISIBLE);
                int index = Integer.parseInt(et.getText().toString())-1;
                String stre = et.getText().toString().trim();

                if(index > 80||index < 0)
                {                   //if(TextUtils.isEmpty(stre)) {  //||  stre.isEmpty() || stre.length() == 0 || stre.equals("") || stre == null||TextUtils.isEmpty(stre)
                    tv.setText("Geçersiz");
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Uyarı");
                    alertDialog.setMessage("Geçersiz bir plaka girdiniz.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tamam",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    return;
                }else{tv.setText(sehirler[index]);}

            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ly.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Uri uri = Uri.parse("http://maps.google.com/?q=istanbul"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);*/
               Intent intent1 = new Intent(MainActivity.this, Harita.class);
                startActivity(intent1);
            }
        });

    }

    public void ekle_frg_bolgeler(View v){
        FragmentBolgeler bolgeler = new FragmentBolgeler();
        FragmentTransaction ft =  manager.beginTransaction();
        ft.add(R.id.linear_fragment,bolgeler,"bölgeler");
        ft.commit();
    }
    public void ekle_frg_sehirler(View v){
        FragmentSehirler sehirler = new FragmentSehirler();
        FragmentTransaction ft1=manager.beginTransaction();
        ft1.add(R.id.linear_fragment,sehirler,"şehirler");
        ft1.commit();
    }
    @Override
    public void onBackPressed() {
        ly.setVisibility(View.INVISIBLE);
        FragmentBolgeler bolgeler = (FragmentBolgeler) manager.findFragmentByTag("bölgeler");
        FragmentSehirler sehirler = (FragmentSehirler) manager.findFragmentByTag("şehirler");
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if(bolgeler != null ){
            fragmentTransaction.remove(bolgeler);
            fragmentTransaction.commit();
        }
        else if(sehirler != null){
            fragmentTransaction.remove(sehirler);
            fragmentTransaction.commit();
        }
        else{
            super.onBackPressed();
        }
    }



}
