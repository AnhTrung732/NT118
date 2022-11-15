package com.example.phonebook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebook.R;
import com.example.phonebook.moodle.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {
    private List<Contact> myContactList;

    public ContactAdapter(List<Contact> myContactList) {
        this.myContactList = myContactList;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone, parent,false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {

        Contact contact = myContactList.get(position);
        if (contact == null ) {
            return;
        }
        System.out.println(position+ " " + contact.getName()+ " " + contact.getPhone());
        holder.txtName.setText(contact.getName());
        holder.txtPhone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        if (myContactList != null) {
            return myContactList.size();
            }
        return 0;
    }

    class ContactHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPhone;
        ImageView imgAvatar;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
        }
    }
}



