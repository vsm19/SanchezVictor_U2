package com.example.sanchezvictor_u2.Controllers;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanchezvictor_u2.Adapters.RecyclerAdapter;
import com.example.sanchezvictor_u2.Model.Explorador;
import com.example.sanchezvictor_u2.R;

import java.util.ArrayList;
import java.util.List;

import Utilidades.Utilidades;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);
        recyclerView = (RecyclerView) findViewById(R.id.recView);
        recAdapter = new RecyclerAdapter(getListExplorador(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(recAdapter);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

    }


    public List<Explorador> getListExplorador(){
        return Utilidades.getExploradores();

    }


}