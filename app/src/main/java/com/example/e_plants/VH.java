package com.example.e_plants;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VH extends  RecyclerView.ViewHolder {
    TextView plant,date,annotherName,textOption;
    public VH(@NonNull View itemView) {
        super(itemView);
        plant=itemView.findViewById(R.id.textName);
        date=itemView.findViewById(R.id.textDate);
        annotherName=itemView.findViewById(R.id.extraName);
        textOption=itemView.findViewById(R.id.text_option);
       /* itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recycleviewInterface!=null){
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        recycleviewInterface.onItemClick(pos);

                    }
                }
            }
        });*/
    }
}
