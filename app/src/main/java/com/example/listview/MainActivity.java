package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import kotlin.collections.unsigned.UArraysKt;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<MatHang> arrayList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        arrayList = new ArrayList<>();
        listView = findViewById(R.id.list_view);
        arrayList.add(new MatHang("Sữa tươi  ","Trân châu,nóng,...","6$",R.drawable.trasua));
        arrayList.add(new MatHang("Trà sữa ","Truyền thống, socola,...","6$",R.drawable.trasua));
        arrayList.add(new MatHang("Trà đào","Nóng,lạnh,... ","6$",R.drawable.tradao));
        arrayList.add(new MatHang("Cà phê","Sữa,đen,bạc xỉu,... ","6$",R.drawable.caphe));
        arrayList.add(new MatHang("Nước ngọt","Coca,Sting,... ","6$",R.drawable.nuocngot));
        arrayList.add(new MatHang("Nước ép","Thái xanh đặc biệt ","6$",R.drawable.nuocep));

        adapter = new Adapter(MainActivity.this, R.layout.layoutitem, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(i==4){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(i==5){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }

        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Xoa(i);
                return false;
            }
        });
    }
    private void Xoa(final int  position){
        AlertDialog.Builder alterDialog  = new AlertDialog.Builder(this);
        alterDialog.setTitle("Thông báo ");
        alterDialog.setIcon(R.mipmap.ic_launcher);
        alterDialog.setMessage("Bạn có muốn xóa mặt hàng này không ?");
        alterDialog.setPositiveButton("Có", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alterDialog.setNegativeButton("Không", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alterDialog.show();
    }
}