package com.ninja.vegitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ViewVegs extends AppCompatActivity implements RecyclerAdapter.OnVegListener {

    private RecyclerView recyclerView;
    private ArrayList<VegD> vegDArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vegs);
        recyclerView = findViewById(R.id.view_vegs);
        vegDArrayList = new ArrayList<>();
        getReceipt();
    }

    public void setAd() {
        RecyclerAdapter adapter = new RecyclerAdapter(vegDArrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void getReceipt() {
        Call<ReceiptResponse> responseCall = ApiClient.getVegService().fetch();
        responseCall.enqueue(new Callback<ReceiptResponse>() {
            @Override
            public void onResponse(Call<ReceiptResponse> call, Response<ReceiptResponse> response) {
                if (response.isSuccessful()) {
                    if(response != null) {
                        String receiptData = response.body().getReceipt().substring(0, response.body().getReceipt().length() - 2);
                        if (!"".equalsIgnoreCase(receiptData)) {
                            String data[] = receiptData.split("EN");
                            for (String d : data) {
                                String smd[] = d.split("BR");
                                if (smd != null && smd.length > 0) {
                                    vegDArrayList.add(new VegD(smd[0].trim(), smd[1].trim(), smd[2].trim()));
                                }
                            }
                            setAd();
                        }
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<ReceiptResponse> call, Throwable t) {
                Toast.makeText(ViewVegs.this, "failure" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onVegClick(int position) {
        vegDArrayList.get(position).getName();
        Intent i = new Intent(getApplicationContext(), UpdateActivity.class);
        i.putExtra("name",vegDArrayList.get(position).getName());
        i.putExtra("price",vegDArrayList.get(position).getPrice());
        i.putExtra("id",vegDArrayList.get(position).getId());
        startActivity(i);
    }
}