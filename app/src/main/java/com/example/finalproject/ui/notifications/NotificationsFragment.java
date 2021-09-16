package com.example.finalproject.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalproject.DetailActivity;
import com.example.finalproject.R;
import com.example.finalproject.product;
import com.example.finalproject.productlistAdapter;
import com.example.finalproject.ui.home.HomeFragment;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private ListView rlistView;
    private product selectProduct;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //notificationsViewModel =
          //      new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        /*final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ArrayList<product> productFavor = new ArrayList<product>();
        for(int i = 0; i < DetailActivity.favorList.size(); i++){
            String num;
            product item;
            num = DetailActivity.favorList.get(i);
            selectProduct = HomeFragment.productlist.get(Integer.valueOf(num));
            item = new product(selectProduct.getId(), selectProduct.getName(), selectProduct.getPlatform(), selectProduct.getImg(), selectProduct.getActor(), selectProduct.getPreview());
            productFavor.add(item);
        }

        rlistView = (ListView)getView().findViewById(R.id.favorlist);
        productlistAdapter Radapter = new productlistAdapter(getActivity(),R.layout.adapter_view_layout, productFavor);
        rlistView.setAdapter(Radapter);

        rlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                product reProduct = (product)(rlistView.getItemAtPosition(position));
                Intent showDetail = new Intent(getActivity(), DetailActivity.class);
                showDetail.putExtra("id", reProduct.getId());
                startActivity(showDetail);
            }
        });
    }
}