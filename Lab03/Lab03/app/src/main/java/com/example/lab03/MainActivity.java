package com.example.lab03;

import static android.content.ContentValues.TAG;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  StudentAdapter.OnItemClickListener{

    EditText edtName, edtCode, edtMark;
    Button btnAdd, btnUpdate;
    RecyclerView rcv_Student;
    ArrayList<Student> students;
    StudentAdapter adapter;
    DatabaseHelper myDB;
    Cursor cursor;
    int itemClickId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity);
        myDB = new DatabaseHelper(this);

        edtCode = (EditText) findViewById(R.id.edtCode);
        edtName = (EditText) findViewById(R.id.edtName);
        edtMark = (EditText) findViewById(R.id.edtMark);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        students = new ArrayList<Student>();

        rcv_Student = (RecyclerView) findViewById(R.id.rcvStudent);
        adapter = new StudentAdapter(this, myDB, R.layout.item_student, students);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Student.setLayoutManager(linearLayoutManager);

        myDB.deleteAllData();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCode.getText().toString().isEmpty() || edtName.getText().toString().isEmpty() ||edtMark.getText().toString().isEmpty()){
                    showMessage("Error","Please fill the all fields to Inserting");
                    return;
                }
                boolean isInserted = myDB.insertData(edtCode.getText().toString(), edtName.getText().toString(), edtMark.getText().toString());

                // Show toast when data inserted successfully
                if(isInserted){
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

                // Update on RecyclerView

                students = getData();
                showData();

                // After inserting make edit box empty
                edtCode.setText("");
                edtName.setText("");
                edtMark.setText("");
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCode.getText().toString().isEmpty() || edtName.getText().toString().isEmpty() ||edtMark.getText().toString().isEmpty()){
                    showMessage("Error","Please fill the all fields to Updating");
                    return;
                }

                boolean isUpdated = myDB.updateData(Integer.toString(itemClickId),edtCode.getText().toString(), edtName.getText().toString(),  edtMark.getText().toString());

                if(isUpdated){
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                }
                students = getData();
                showData();
            }
        });

    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    private ArrayList<Student> getData() {
        ArrayList<Student> students = new ArrayList<Student>();
        cursor = myDB.getAllData();
        while (cursor.moveToNext()) {
            String _code = cursor.getString(1);
            String _name = cursor.getString(2);
            String _mark = cursor.getString(3);
            if (_mark.equals(""))
            {
                _mark = "0";
            }
            students.add(new Student(_code,_name,parseInt(_mark)));
        }
        return students;
    }
    private void showData() {
        rcv_Student = (RecyclerView) findViewById(R.id.rcvStudent);
        adapter = new StudentAdapter(this, myDB, R.layout.item_student, students);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Student.setLayoutManager(linearLayoutManager);
        rcv_Student.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int elementId) {
        Toast.makeText(MainActivity.this, "Position is " + elementId, Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onItemClick: "+String.valueOf(elementId));
        itemClickId = elementId;
    }
}