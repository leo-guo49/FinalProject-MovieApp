package com.example.finalproject.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject.DetailActivity;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.product;
import com.example.finalproject.productlistAdapter;
import com.example.finalproject.ui.home.HomeFragment;

import java.util.ArrayList;

import static com.example.finalproject.ui.home.HomeFragment.productlist;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private ListView slistView;

    private String selectFilter = "all";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //dashboardViewModel =
        //        new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        /*final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        SearchWidget();
        detail();
        Button hbo = (Button)getView().findViewById(R.id.hboFilter);
        Button net = (Button)getView().findViewById(R.id.netflixFilter);
        Button love = (Button)getView().findViewById(R.id.loveFilter);

        hbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterList("hbo");
            }
        });

        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterList("netflix");
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterList("愛奇藝");
            }
        });
    }

    private void SearchWidget() {
        SearchView searchView = (SearchView)getView().findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<product> productSearch = new ArrayList<product>();

                for(product pro: productlist){
                    if(pro.getName().toLowerCase().contains(newText.toLowerCase())){
                        productSearch.add(pro);
                    }
                }
                slistView = (ListView)getView().findViewById(R.id.list);
                //slistView = mlistView;
                productlistAdapter Sadapter = new productlistAdapter(getActivity(),R.layout.adapter_view_layout, productSearch);
                slistView.setAdapter(Sadapter);
                return false;
            }
        });
    }

    private void detail(){
        slistView = (ListView)getView().findViewById(R.id.list);
        slistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                product selectProduct = (product)(slistView.getItemAtPosition(position));
                Intent showDetail = new Intent(getActivity(), DetailActivity.class);
                showDetail.putExtra("id", selectProduct.getId());
                startActivity(showDetail);
            }
        });
    }


    private void filterList(String status){
        //selectFilter = status;
        ArrayList<product> filter = new ArrayList<product>();

        for(product pro: productlist){
            if(pro.getPlatform().toLowerCase().contains(status)){
                filter.add(pro);
            }
        }

        slistView = (ListView)getView().findViewById(R.id.list);
        productlistAdapter Fadapter = new productlistAdapter(getActivity(),R.layout.adapter_view_layout, filter);
        slistView.setAdapter(Fadapter);
    }

}