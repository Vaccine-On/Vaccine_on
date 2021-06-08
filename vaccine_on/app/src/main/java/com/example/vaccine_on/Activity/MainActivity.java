package com.example.vaccine_on.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vaccine_on.Fragment.BoardFragment;
import com.example.vaccine_on.Fragment.MainFragment;
import com.example.vaccine_on.Fragment.MyPageFragment;
import com.example.vaccine_on.R;

public class MainActivity extends AppCompatActivity {
    private final int mainFragment = 1;
    private final int boardFragment = 2;
    private final int myPageFragment = 3;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);

        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentView(mainFragment);
                title.setText("병원 검색");
            }
        });

        findViewById(R.id.board).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentView(boardFragment);
                title.setText("게시판");
            }
        });

        findViewById(R.id.my_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentView(myPageFragment);
                title.setText("마이페이지");
            }
        });
        FragmentView(mainFragment);
    }

    private void FragmentView(int fragment){

        //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment){
            case 1:
                // 첫번 째 프래그먼트 호출
                MainFragment mainFragment = new MainFragment();
                transaction.replace(R.id.fragment_container, mainFragment);
                transaction.commit();
                break;

            case 2:
                // 두번 째 프래그먼트 호출
                BoardFragment boardFragment = new BoardFragment();
                transaction.replace(R.id.fragment_container, boardFragment);
                transaction.commit();
                break;

            case 3:
                // 세번 째 프래그먼트 호출
                MyPageFragment myPageFragment = new MyPageFragment();
                transaction.replace(R.id.fragment_container, myPageFragment);
                transaction.commit();
                break;
        }

    }

}
