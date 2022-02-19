package com.example.browsesolar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ftab1 extends Fragment {

    String api ="71e8ac629b034ca4a66e0ab94c2bca59";
    ArrayList<ModelClass> modelClasses;
    Adapter adapter;
    String country ="in";
    private RecyclerView recyclerViewofhome;
    private String category="general";

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {


        View  v = inflater.inflate(R.layout.fragment_ftab1,null);


        recyclerViewofhome=v.findViewById(R.id.recyclerviewhome);
        modelClasses=new ArrayList<>();
        recyclerViewofhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClasses);
        recyclerViewofhome.setAdapter(adapter);


        findNews();

        return  v;

    }

    private void findNews() {
        ApiUtilities.getApiInerface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClasses.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });

    }
}

