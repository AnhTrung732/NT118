package com.example.phonebook.moodle;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ContactManager {
    private Context mContext;
    private List<Contact> mListContact;

    public List<Contact> getmListContact() {
        return mListContact;
    }


    public ContactManager(Context mContext) {
        this.mContext = mContext;
        getContactData();
        Collections.sort(mListContact);
    }

    private void getContactData() {
        mListContact = new ArrayList<>();
        String[] projections = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
        };
        Cursor phones = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,projections,null,null,null);
        int nameIndex = phones.getColumnIndex(projections[0]);
        int numberIndex = phones.getColumnIndex(projections[1]);
        phones.moveToFirst();



        while(phones.moveToNext()){
            String name  =  phones.getString(nameIndex);
            String number = phones.getString(numberIndex);
            mListContact.add(new Contact(name,number));
        }
        phones.close();
    }
}
