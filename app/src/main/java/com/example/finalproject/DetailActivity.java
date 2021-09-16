package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ui.dashboard.DashboardFragment;
import com.example.finalproject.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.finalproject.ui.home.HomeFragment.check;

public class DetailActivity extends AppCompatActivity {

    product selectProduct;
    private String ID;
    //private int check = 0;
    public static ArrayList<String> favorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSelectData();
        setValues();
        Button re = (Button)findViewById(R.id.btn);
        Button fav = (Button)findViewById(R.id.favor);

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==0){
                    check = 1;
                    favorList.add(ID);
                    Toast.makeText(DetailActivity.this, "已加入最愛", Toast.LENGTH_SHORT).show();
                    /*
                    Intent favor = new Intent(DetailActivity.this, DashboardFragment.class);
                    favor.putStringArrayListExtra("id", favorList);
                    startActivity(favor);*/
                }else if(check == 1){
                    check = 0;
                    favorList.remove(new String(ID));
                    Toast.makeText(DetailActivity.this, "已從最愛刪除", Toast.LENGTH_SHORT).show();
                    /*
                    Intent favor = new Intent(DetailActivity.this, DashboardFragment.class);
                    favor.putStringArrayListExtra("fav", favorList);
                    startActivity(favor);*/
                }
            }
        });
    }

    private void getSelectData() {
        Intent previousIntent = getIntent();
        ID = previousIntent.getStringExtra("id");
        selectProduct = HomeFragment.productlist.get(Integer.valueOf(ID));
    }

    private void setValues() {
        TextView tvName = (TextView)findViewById(R.id.de_name);
        TextView tvPlatform = (TextView)findViewById(R.id.de_platform);
        ImageView tvImg = (ImageView)findViewById(R.id.de_image);
        TextView tvActor = (TextView)findViewById(R.id.de_actor);
        TextView tvPre = (TextView)findViewById(R.id.de_scr);

        tvName.setText(selectProduct.getName());
        tvPlatform.setText(selectProduct.getPlatform());
        tvImg.setImageResource(selectProduct.getImg());
        tvActor.setText(selectProduct.getActor());
        tvPre.setText(selectProduct.getPreview());

    }
}