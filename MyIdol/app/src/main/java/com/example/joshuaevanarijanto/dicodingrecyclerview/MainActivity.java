package com.example.joshuaevanarijanto.dicodingrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView  rvCategory;
    private ArrayList<Dream> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(DreamData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListDreamAdapter listDreamAdapter = new ListDreamAdapter(this);
        listDreamAdapter.setListDream(list);
        rvCategory.setAdapter(listDreamAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelected(list.get(position),position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridDreamAdapter gridDreamAdapter = new GridDreamAdapter(this);
        gridDreamAdapter.setListDream(list);
        rvCategory.setAdapter(gridDreamAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelected(list.get(position),position);
            }
        });
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewDreamAdapter cardViewDreamAdapter = new CardViewDreamAdapter(this);
        cardViewDreamAdapter.setListDream(list);
        rvCategory.setAdapter(cardViewDreamAdapter);
    }

    private void showSelected(Dream dream, int pos){
        Toast.makeText(this, dream.getName() + " has been choosed",
                Toast.LENGTH_SHORT).show();
        Intent toDetail = new Intent(MainActivity.this, DetailActivity.class);
        toDetail.putExtra("indexData",pos);
        startActivity(toDetail);

    }
    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String title = null;
        switch(item.getItemId()){
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }

        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }
}





