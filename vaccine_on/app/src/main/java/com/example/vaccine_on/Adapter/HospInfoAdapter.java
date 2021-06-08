package com.example.vaccine_on.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine_on.HospInfo;
import com.example.vaccine_on.Activity.MoreInfoActivity;
import com.example.vaccine_on.R;

import java.util.ArrayList;

public class HospInfoAdapter extends RecyclerView.Adapter<HospInfoAdapter.ViewHolder> {
    Context mContext;
    ArrayList<HospInfo> itemViewArrayList = new ArrayList<HospInfo>(); //객체배열

    public HospInfoAdapter(Context context, ArrayList<HospInfo> itemViewArrayList) {
        this.itemViewArrayList = itemViewArrayList;
        this.mContext = context;
    }

    //아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hospName, hospAddr;

        ViewHolder(View itemView) {
            super(itemView);

            //뷰 객체에 대한 참조
            hospName = itemView.findViewById(R.id.hospName);
            hospAddr = itemView.findViewById(R.id.hospAddr);
        }

        public void setItem(HospInfo hospInfo) {
            hospName.setText(hospInfo.getHospitalName());
            hospAddr.setText(hospInfo.getHospitalAddr());
        }
    }



    //생성자에서 데이터 리스트 객체를 전달받음.
    public HospInfoAdapter(ArrayList<HospInfo> list) {
        itemViewArrayList = list;
    }

    //onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @Override
    public HospInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.hospinfo_recyclerview_item, parent, false);
        HospInfoAdapter.ViewHolder vh = new HospInfoAdapter.ViewHolder(view);

        return vh;
    }

    //onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템 뷰에 표시
    @Override
    public void onBindViewHolder(HospInfoAdapter.ViewHolder holder, int position) {
        HospInfo hospInfo = itemViewArrayList.get(position);

        holder.setItem(hospInfo);

        //아이템 클릭 이벤트
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //아이템 클릭 시 상세보기화면으로 넘어감
                if (position != RecyclerView.NO_POSITION) {
                    //리스너 객체의 메서드 호출
                    Intent intent = new Intent(mContext, MoreInfoActivity.class);
                    Log.d("액티비티", "화면 전환 성공");
                    intent.putExtra("name", hospInfo.getHospitalName());
                    intent.putExtra("addr", hospInfo.getHospitalAddr());
                    intent.putExtra("tel", hospInfo.getHospitalTelNo());
                    intent.putExtra("url", hospInfo.getHospitalUrl());
                    Log.d("액티비티", "데이터 보내기");
                    mContext.startActivity(intent);
                }

            }
        });
    }

    //getItemCount() 전체 데이터 갯수 리턴
    @Override
    public int getItemCount() {
        return itemViewArrayList.size();
    }
}