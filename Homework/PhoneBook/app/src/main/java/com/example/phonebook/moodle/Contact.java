package com.example.phonebook.moodle;

import android.graphics.Bitmap;

public class Contact implements Comparable<Contact>{
    private String name;
    private String phone;
    private int avatar;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Contact contact) {
        return this.name.compareTo(contact.name);
    }
}
