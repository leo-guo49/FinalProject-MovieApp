package com.example.finalproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject.DetailActivity;
import com.example.finalproject.R;
import com.example.finalproject.product;
import com.example.finalproject.productlistAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public static ArrayList<product> productlist = new ArrayList<product>();
    private productlistAdapter adapter;
    private ListView mlistView;
    public static int check = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel =
          //      new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
//        setupData();
//        setupList();
//        setupClick();
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        setupData();
        setupList();
        setupClick();
        /*ListView mListView = (ListView)getView().findViewById(R.id.listView);
        EditText sear = (EditText)getView().findViewById(R.id.search1);

        product item1 = new product("black list", "Netflix", R.mipmap.blacl_list);
        product item2 = new product("毒梟", "Netflix", R.mipmap.narcos);
        product item3 = new product("南方四賤客", "Netflix", R.mipmap.southpark);
        product item4 = new product("black list", "Netflix", R.mipmap.blacl_list);
        product item5 = new product("毒梟", "Netflix", R.mipmap.narcos);
        product item6 = new product("南方四賤客", "Netflix", R.mipmap.southpark);
        product item7 = new product("black list", "Netflix", R.mipmap.blacl_list);
        product item8 = new product("毒梟", "Netflix", R.mipmap.narcos);
        product item9 = new product("南方四賤客", "Netflix", R.mipmap.southpark);

        ArrayList<product> productlist = new ArrayList<>();
        productlist.add(item1);
        productlist.add(item2);
        productlist.add(item3);
        productlist.add(item4);
        productlist.add(item5);
        productlist.add(item6);
        productlist.add(item7);
        productlist.add(item8);
        productlist.add(item9);
        relist = productlist;

        adapter = new productlistAdapter(getActivity(), R.layout.adapter_view_layout, productlist);
        mListView.setAdapter(adapter);*/

    }

    private void setupData(){
        product item1 = new product("0","Sweet Tooth:鹿角男孩", "Netflix", R.mipmap.a, "克里斯蒂安·康維爾、諾索·安諾茲、阿黛爾·阿赫塔爾", "https://www.youtube.com/watch?v=1_YEnB-XGRk&ab_channel=NetflixAsia");
        product item2 = new product("1","朱比特傳奇", "Netflix", R.mipmap.b, "喬許·杜哈莫、班·丹尼爾斯、蕾絲莉·畢柏", "https://www.youtube.com/watch?v=e2cHkR7J7a0&ab_channel=NetflixAsia");
        product item3 = new product("2","太陽召喚", "Netflix", R.mipmap.c, "潔西·梅·李、班·巴恩斯、阿奇·雷諾斯", "https://www.youtube.com/watch?v=ooh4ppZKdLA&ab_channel=NetflixAsia");
        product item4 = new product("3","Sisyphus: the myth", "Netflix", R.mipmap.d, "曹承佑、朴信惠","https://www.youtube.com/watch?v=h61SogV3Wes&ab_channel=NetflixAsia");
        product item5 = new product("4","Law School", "Netflix", R.mipmap.e, "金明名、金汎、柳惠英","https://www.youtube.com/watch?v=dbG8KguQg3w&ab_channel=NetflixAsia");
        product item6 = new product("5","三人要守密，兩人得死去", "Netflix", R.mipmap.f, "席夢娜·布朗、依芙·霍森、湯姆·巴特曼", "https://www.netflix.com/tw/title/80244630");
        product item7 = new product("6","末日列車", "Netflix", R.mipmap.g, "克里斯·伊凡、宋康昊、蒂妲·絲雲頓", "https://www.youtube.com/watch?v=D7lgcr2cMvU&ab_channel=NetflixAsia");
        product item8 = new product("7","將夜", "愛奇藝", R.mipmap.h, "陳飛宇、宋伊人","無");
        product item9 = new product("8","幸福、觸手可及", "愛奇藝", R.mipmap.i, "迪麗熱巴、黃景瑜", "https://www.iq.com/play/%E5%B9%B8%E7%A6%8F%EF%BC%8C%E8%A7%B8%E6%89%8B%E5%8F%AF%E5%8F%8A%EF%BC%81-19rrhkxpst?frmrp=search&frmb=list&frmrs=title");
        product item10 = new product("9","沉默的真相", "愛奇藝", R.mipmap.j, "廖凡、白宇", "https://www.iq.com/play/%E6%B2%89%E9%BB%98%E7%9A%84%E7%9C%9F%E7%9B%B8-2424m7d7tdh?frmrp=search&frmb=list&frmrs=title");
        product item11 = new product("10","三隻小豬的逆襲", "愛奇藝", R.mipmap.k, "王傳一、賴雅妍、謝佳見", "https://www.iq.com/play/ocvq8j9r3s?from=iqiyi_tw");
        product item12 = new product("11","壯志高飛", "愛奇藝", R.mipmap.l, "鄭喬恩、鄭愷", "https://www.iq.com/play/%E5%A3%AF%E5%BF%97%E9%AB%98%E9%A3%9B-1x26jwwt6f5?frmrp=search&frmb=list&frmrs=title");
        product item13 = new product("12","長歌行", "愛奇藝", R.mipmap.m, "迪麗熱巴、吳磊、劉宇寧", "https://www.iq.com/play/%E9%95%B7%E6%AD%8C%E8%A1%8C-1p0shr4crb9?frmrp=search&frmb=list&frmrs=title");
        product item14 = new product("13","Voice", "愛奇藝", R.mipmap.n, "張赫、李荷娜", "https://www.iq.com/play/voice2-19rrh660d1?frmrp=search&frmb=list&frmrs=title");
        product item15 = new product("14","冰與火之歌", "HBO", R.mipmap.o, "彼特·丁拉基、尼可拉·科斯特-瓦爾道、琳娜·海蒂", "https://www.youtube.com/watch?v=0eODqYjblkc&ab_channel=%E5%87%B1%E6%93%98%E5%A4%A7%E5%BD%B0%E5%8C%96%E6%96%B0%E8%81%9E");
        product item16 = new product("15","謎飛空姐", "HBO", R.mipmap.p, "凱莉·庫柯、麥可·俞斯曼、柔夏·瑪美德","https://www.facebook.com/HBOAsiaTW/videos/%E8%AC%8E%E9%A3%9B%E7%A9%BA%E5%A7%90%E6%AD%A3%E5%BC%8F%E9%A0%90%E5%91%8A/734475014084752/");
        product item17 = new product("16","極地闇殺", "HBO", R.mipmap.q, "山下智久、約翰林區、凱薩琳歐唐納例", "https://www.facebook.com/HBOAsiaTW/videos/%E6%A5%B5%E5%9C%B0%E9%97%87%E6%AE%BA-%E6%AD%A3%E5%BC%8F%E9%A0%90%E5%91%8A/2549943218656497/");
        product item18 = new product("17","核爆家園", "HBO", R.mipmap.r, "傑瑞德·哈里斯、史戴倫·史柯斯嘉、艾蜜莉·華森","https://www.youtube.com/watch?v=Xp48VMEyRMM&ab_channel=TheFlowerofSpades");
        product item19 = new product("18","繼承", "HBO", R.mipmap.s, "布萊恩·考克斯、希安·阿巴斯、尼古拉斯·布朗","https://www.youtube.com/watch?v=v3KLF8oSCv0&ab_channel=TheFlowerofSpades");
        product item20 = new product("19","黑道家族", "HBO", R.mipmap.t, "詹姆斯·甘多費尼、洛琳·布萊克、艾迪·法柯","無");
        product item21 = new product("20","新聞急先鋒", "HBO", R.mipmap.u, "傑夫·丹尼爾、艾蜜莉·摩提默、小約翰·蓋勒格","https://www.youtube.com/watch?v=E-TA49FCMMs&ab_channel=%E5%BE%97%E5%88%A9%E5%BD%B1%E8%A6%96");
        product item22 = new product("21","到底囉~", "", R.mipmap.u, "","");

        //ArrayList<product> productlist = new ArrayList<>();
        productlist.add(item1);
        productlist.add(item2);
        productlist.add(item3);
        productlist.add(item4);
        productlist.add(item5);
        productlist.add(item6);
        productlist.add(item7);
        productlist.add(item8);
        productlist.add(item9);
        productlist.add(item10);
        productlist.add(item11);
        productlist.add(item12);
        productlist.add(item13);
        productlist.add(item14);
        productlist.add(item15);
        productlist.add(item16);
        productlist.add(item17);
        productlist.add(item18);
        productlist.add(item19);
        productlist.add(item20);
        productlist.add(item21);
        productlist.add(item22);
    }

    private void setupList() {
        mlistView = (ListView)getView().findViewById(R.id.listView);
        adapter = new productlistAdapter(getActivity(), R.layout.adapter_view_layout, productlist);
        mlistView.setAdapter(adapter);
    }

    private void setupClick() {
        mlistView = (ListView)getView().findViewById(R.id.listView);
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                product selectProduct = (product)(mlistView.getItemAtPosition(position));
                Intent showDetail = new Intent(getActivity(), DetailActivity.class);
                showDetail.putExtra("id", selectProduct.getId());
                startActivity(showDetail);
            }
        });
    }

}