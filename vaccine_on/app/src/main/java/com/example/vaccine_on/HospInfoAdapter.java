package com.example.vaccine_on;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HospInfoAdapter extends RecyclerView.Adapter<HospInfoAdapter.ViewHolder> {
    ArrayList<HospInfo> itemViewArrayList = new ArrayList<HospInfo>(); //객체배열

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
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.hospinfo_recyclerview_item, parent, false);
        HospInfoAdapter.ViewHolder vh = new HospInfoAdapter.ViewHolder(view);

        return vh;
    }

    //onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템 뷰에 표시
    @Override
    public void onBindViewHolder(HospInfoAdapter.ViewHolder holder, int position) {
        HospInfo hospInfo = itemViewArrayList.get(position);

        holder.setItem(hospInfo);
    }

    //getItemCount() 전체 데이터 갯수 리턴
    @Override
    public int getItemCount() {
        return itemViewArrayList.size();
    }
}