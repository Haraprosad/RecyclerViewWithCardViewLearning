package org.lingj.recyclerviewwithcardviewlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization of recyclerview
        RecyclerView recyclerView = findViewById(R.id.recycler);

        /*To provide required objects to the custom adapter*/
        MyAdapter adapter = new MyAdapter(this,NatureModel.getObjectList());

        //Set Adapter to recyclerview
        recyclerView.setAdapter(adapter);

        /*LinearLayout system and orientation specifying by coding to be more accurate.
        GridLayoutManager and StaggeredGridLayoutManager are also existed*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Set recyclerview's Layout structure
        recyclerView.setLayoutManager(linearLayoutManager);

        /*Default animation playing at the time of deleting or adding
        components from recyclerView*/
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
