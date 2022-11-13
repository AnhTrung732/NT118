package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.phonebook.adapter.ContactAdapter;
import com.example.phonebook.moodle.Contact;
import com.example.phonebook.moodle.ContactManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvPhone;
    //private List<Contact> mListContact;
    private ContactAdapter mcontactAdapter;
    private ContactManager mcontactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvPhone = findViewById(R.id.rcv_phone);
        mcontactManager = new ContactManager(this);


//        Contact contact1 = new Contact("Nguyen Van A","49872645");
//        Contact contact2 = new Contact("Nguyen Van B","12345678");
//        Contact contact3 = new Contact("Nguyen Van C","10293847");
//
//        mListContact.add(contact2);
//        mListContact.add(contact1);
//        mListContact.add(contact3);

        mcontactAdapter = new ContactAdapter(mcontactManager.getmListContact());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPhone.setLayoutManager(linearLayoutManager);
        rcvPhone.setAdapter(mcontactAdapter);

    }
}