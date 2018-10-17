package com.alidogan201413171066.mobilprogramalamailkodev;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageAdapter extends PagerAdapter{

    private int [] resimler = {R.drawable.res_kapadokya,R.drawable.res_sultanahmet,R.drawable.res_uludag,R.drawable.res_sumela,R.drawable.res_nemrut};
    private String [] resimAdlari = {"Kapadokya/Nevşehir","Sultanahmet Camii","Uludağ/Bursa","Sumela Manastırı/Trabzon","Nemrut Dağı/Adıyaman"};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public ImageAdapter(Context ctx){

        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return resimler.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.frg_turkey,container,false);
        ImageView iv = (ImageView) item_view.findViewById(R.id.image_view);
        TextView tv = (TextView) item_view.findViewById(R.id.tv_galeri);
        iv.setImageResource(resimler[position]);
        tv.setText(resimAdlari[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((LinearLayout) object);
    }
}