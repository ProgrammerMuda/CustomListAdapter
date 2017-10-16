package com.example.raga.belajarlist2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] namapemain = {
            "aubameyang",
            "dybala",
            "ibrahimovic",
            "luis suarez",
            "k.mbappe",
            "messi",
            "neymar",
            "ozil",
            "pogba",
            "reus",
            "ronaldo",
            "rooney",

    };

    String[] subtitle = {
            "subtitle tentang aubameyang ",
            "subtitle tentang dybala",
            "subtitle tentang ibrahimovic",
            "subtitle tentang luis suarez",
            "subtitle tentang mbappe",
            "subtitle tentang messi",
            "subtitle tentang neymar",
            "subtitle tentang ozil",
            "subtitle tentang pogba",
            "subtitle tentang reus",
            "subtitle tentang ronaldo",
            "subtitle tentang rooney",

    };

    String[] webview1 = {
            "https://id.wikipedia.org/wiki/Pierre-Emerick_Aubameyang",
            "https://id.wikipedia.org/wiki/Paulo_Dybala",
            "https://id.wikipedia.org/wiki/Zlatan_Ibrahimović",
            "https://id.wikipedia.org/wiki/Luis_Suárez",
            "https://en.wikipedia.org/wiki/Kylian_Mbappé",
            "https://id.wikipedia.org/wiki/Lionel_Messi",
            "https://id.wikipedia.org/wiki/Neymar",
            "https://id.wikipedia.org/wiki/Mesut_Özil",
            "https://id.wikipedia.org/wiki/Paul_Pogba",
            "https://id.wikipedia.org/wiki/Marco_Reus",
            "https://id.wikipedia.org/wiki/Cristiano_Ronaldo",
            "https://id.wikipedia.org/wiki/Wayne_Rooney",

    };

    Integer[] gambarpemain = {
            R.drawable.aubameyang,
            R.drawable.dybala,
            R.drawable.ibrahimmovic,
            R.drawable.luissuarez,
            R.drawable.mbappe,
            R.drawable.messi,
            R.drawable.neymar,
            R.drawable.ozil,
            R.drawable.pogba,
            R.drawable.reus,
            R.drawable.ronaldo,
            R.drawable.rooney,

    };

    ListView list1;
    AlertDialog.Builder alertdialog;
    AlertDialog alert;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter cladapter = new CustomListAdapter(this,namapemain, subtitle, gambarpemain);
        list1 = (ListView)findViewById(R.id.idlist1);
        list1.setAdapter(cladapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog
                        .setTitle(namapemain[position])
                        .setMessage(namapemain[position]+" adalah salah satu pemain terkenal")
                        .setPositiveButton("lanjut", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String title = namapemain[position];
                                Integer gambar= gambarpemain[position];
                                String url = webview1[position];

                                Bundle ngambil = new Bundle();

                                ngambil.putString("title1",title);
                                ngambil.putInt("gambar",gambar);
                                ngambil.putString("url1", url);

                                Intent kirim = new Intent(MainActivity.this,details.class);
                                kirim.putExtras(ngambil);
                                startActivity(kirim);








                            }
                        })
                        .setNegativeButton("batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert=alertdialog.create();
                alert.show();
            }
        });


    }
}
