package com.example.vaccine_on;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Context context;
    private ImageView board, home, my_page;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getBaseContext();

        board = findViewById(R.id.board);
        home = findViewById(R.id.home);
        my_page = findViewById(R.id.my_page);

        board.setOnClickListener(this);
        home.setOnClickListener((View.OnClickListener) this);
        my_page.setOnClickListener((View.OnClickListener) this);

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null) return;
            MainFragment mainFragment = new MainFragment();
            mainFragment.setArguments(getIntent().getExtras());

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, mainFragment);
            fragmentTransaction.commit();
        }
    }

}
