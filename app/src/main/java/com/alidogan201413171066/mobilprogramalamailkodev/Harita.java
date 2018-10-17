package com.alidogan201413171066.mobilprogramalamailkodev;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.y;



public class Harita extends AppCompatActivity implements LocationListener, OnItemClickListener {
    int y = 1, z = 0;
    LocationManager locationManager;
    ArrayList<String> Bulunan = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView lv;
    TextView baslik, mesaj;
    double koordinat_enlem[] = {39.418686, 39.420239, 39.421425, 39.419078, 39.421084, 39.419081, 39.423620, 39.480873, 39.476065, 39.487339};
    double koordinat_boylam[] = {29.982876, 29.985810, 29.982741, 29.984020, 29.986339, 29.986199, 29.988590, 29.897560, 29.900762, 29.885861};
    String koordinat_isim[] = {"", "Mülayimoğulları İskender", "Aşk-ı Tantuni",
                               "Taksim Buffet", "Burger King", "İskender Lokantası",
                               "Donas", "Dpü Mühendislik", "Dpü Bedesten", "Dpü Tıp"};

    private static final int IZIN_KONUM = 102;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita);
        baslik = (TextView) findViewById(R.id.textView2);
        mesaj = (TextView) findViewById(R.id.textView);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, IZIN_KONUM);
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Bulunan);
        ListView lv = (ListView) findViewById(R.id.listView_harita);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { public void
        onItemClick(AdapterView<?> parent, View v,int position, long id) {
            String tiklanan= (String)parent.getItemAtPosition(position);
           /* if(tiklanan == "Dpü Mühendislik") {
                Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + koordinat_enlem[7]+", "+koordinat_boylam[7]+ "&travelmode=walking");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            if(tiklanan == "Dpü Bedesten") {
                Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + koordinat_enlem[8]+", "+koordinat_boylam[8]+ "&travelmode=walking");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            if(tiklanan == "Dpü Tıp") {
                Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + koordinat_enlem[9]+", "+koordinat_boylam[9]+ "&travelmode=walking");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            else{*/
                Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination="+tiklanan+"&travelmode=walking");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            //}


        }
        });
    }

    @Override
    public void onLocationChanged(final Location location) {

        mesaj.setText("Enlem:" + location.getLatitude() + "\nBoylam:"
                + location.getLongitude());

        Bulunan.clear();

        Thread thread = new Thread() {
            public void run() {
                for (int x = 0; x < 10; x++) {
                    if (koordinat_enlem[x] + 0.025 >= location.getLatitude() && koordinat_enlem[x] - 0.025 <= location.getLatitude()) {
                        if (koordinat_boylam[x] + 0.025 >= location.getLongitude() && koordinat_boylam[x] - 0.025 <= location.getLongitude()) {
                            if(x==0)
                            {Bulunan.add(koordinat_isim[x]);
                                y=0;
                                z++;}
                            else
                            {   if(y==1)
                            {Bulunan.add(koordinat_isim[0]);
                                y=0;
                                z++;}
                                Bulunan.add(koordinat_isim[x]);
                                z++;}}		}	}
                if(z==0)
                {
                    mesaj.setText("Enlem:" + location.getLatitude() + "\nBoylam:"
                            + location.getLongitude()+"\nEşleşme bulunamadı -_-'");}
                z=0;}};
        thread.start();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

        mesaj.setText("Konum Bilgisi Alınıyor...");
    }

    @Override
    public void onProviderDisabled(String provider) {
        mesaj.setText("GPS ve internetinizi açınız.");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    /* enlem.setText("Enlem: " + String.valueOf(location.getLatitude()));
            boylam.setText("Boylam: " + String.valueOf(location.getLongitude()));*/

}
