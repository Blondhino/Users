package com.blondi.lv2;

import android.app.ActivityManager;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CellClickListener{

    private RecyclerView recycler;
    private RecyclerVewAdapter adapter;
    private ImageButton BtnAddUser;
    private EditText newName;
    private String CurrentTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnAddUser = findViewById(R.id.BtnAdd);
        newName=findViewById(R.id.Et1);
        setupRecycler();
        BtnAddUser.setOnClickListener(this);




    }


    public void setupRecycler() {
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerVewAdapter(this);
        recycler.setAdapter(adapter);




    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.BtnAdd:
                if(newName.getText().toString().length()>0){

                CurrentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
                adapter.addNewCell(newName.getText().toString(), CurrentTime);}
                else{Toast.makeText(this,"Enter New Name First",Toast.LENGTH_SHORT).show();}
                newName.setText("");

            break;
        }

    }



    @Override
    public void onDeleteClick(int position) {
        //Toast.makeText(this,"position: "+position,Toast.LENGTH_SHORT).show();
        adapter.removeCell(position);
    }
}