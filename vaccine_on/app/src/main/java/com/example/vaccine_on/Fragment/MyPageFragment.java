package com.example.vaccine_on.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vaccine_on.Activity.ChangeNicknameActivity;
import com.example.vaccine_on.Activity.PasswordChangeActivity;
import com.example.vaccine_on.Adapter.MyBoardAdpater;
import com.example.vaccine_on.MyboardActivity;
import com.example.vaccine_on.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyPageFragment newInstance(String param1, String param2) {
        MyPageFragment fragment = new MyPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    //??????????????? ?????? ??????
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_my_page, container, false);

        // ?????? ?????????
        TextView text_nickname = (TextView)rootview.findViewById(R.id.change_nickname);
        TextView text_password = (TextView)rootview.findViewById(R.id.change_password);
        TextView text_myboard = (TextView)rootview.findViewById(R.id.my_board);

        // ????????? ?????? ???????????? ??????
        text_nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChangeNicknameActivity.class);
                startActivity(intent);
            }
        });

        // ???????????? ?????? ???????????? ??????
        text_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PasswordChangeActivity.class);
                startActivity(intent);
            }
        });

        // ?????? ??? ????????? ???????????? ??????
        // ????????? ????????? ?????????????????? ??????
        text_myboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyboardActivity.class);
                startActivity(intent);
            }
        });





        // ????????? ?????? ????????????
        /*private static FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference docRef = db.collection("users");
        docRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {

                    }

                }
            }
        })*/
        return rootview;
    }

}

