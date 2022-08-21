package com.example.trippar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdopterClass extends RecyclerView.Adapter<AdopterClass.ViewHolder> {


    private List<ModelClass> model_Users;
    Context context;

    // RecyclerView recyclerView;
    public AdopterClass(List<ModelClass> model_Users, Context context) {
        this.model_Users = model_Users;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.events_lilst, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ModelClass current_Users = model_Users.get(position);
//        holder.img.setText(model_Users.get(position).getImg());
        holder.header.setText(model_Users.get(position).getHeader());
        holder.desc.setText(model_Users.get(position).getDesc());
        holder.phone.setText(model_Users.get(position).getPhone());


//        holder.txt_head.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,Student_Info.class);
//                intent.putExtra("imagename",current_Users.getImgname());
//                intent.putExtra("header",current_Users.getHeader());
//                intent.putExtra("desc",current_Users.getDesc());
//                intent.putExtra("phone",current_Users.getPhone());
//
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return model_Users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView header, desc, phone;
        public ImageView img;
        public LinearLayout layout_Users;


        public ViewHolder(@NonNull View itemView) { super(itemView);
//            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.header = (TextView) itemView.findViewById(R.id.user);
            this.desc = (TextView) itemView.findViewById(R.id.profession);
            this.phone= (TextView) itemView.findViewById(R.id.phone);
        }
    }
}
