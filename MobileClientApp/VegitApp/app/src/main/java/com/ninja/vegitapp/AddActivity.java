package com.ninja.vegitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    Button add;
    TextInputEditText vegName,qty,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.btn_add);
        vegName = findViewById(R.id.vegName);
        price = findViewById(R.id.price);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addVeg(vegData());
            }
        });
    }
    public VegRequest vegData(){
        VegRequest veg = new VegRequest();
        veg.setVegName(vegName.getText().toString());
        veg.setPrice(price.getText().toString());
        return veg;
    }

    public void addVeg(VegRequest vegRequest){
         Call<VegResponse> responseCall = ApiClient.getVegService().addVeg(vegRequest);
         responseCall.enqueue(new Callback<VegResponse>() {
             @Override
             public void onResponse(Call<VegResponse> call, Response<VegResponse> response) {
                 if(response.isSuccessful()){
                     vegName.setText("");
                     price.setText("");
                     Intent i = new Intent(getApplicationContext(),ViewVegs.class);
                     i.putExtra("msg","Added");
                     startActivity(i);
                     Toast.makeText(AddActivity.this,"Added",Toast.LENGTH_SHORT).show();
                 }else{
                     Toast.makeText(AddActivity.this,"failed",Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<VegResponse> call, Throwable t) {

             }
         });
    }
}