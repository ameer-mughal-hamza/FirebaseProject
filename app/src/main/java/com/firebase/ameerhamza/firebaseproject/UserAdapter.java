package com.firebase.ameerhamza.firebaseproject;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ameerhamza.firebaseproject.modals.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ameer Hamza on 12/19/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.name.setText(user.getFirst_name() + " " + user.getLast_name());
        holder.blood_group.setText("Bloodgroup" + user.getBlood_group());
        Picasso.with(context).load(user.getProfile_image()).into(holder.mProfilImage);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, blood_group;
        ImageView mProfilImage;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            blood_group = itemView.findViewById(R.id.blood_group);
            mProfilImage = itemView.findViewById(R.id.mProfileImage);
        }
    }
}
