package com.example.ayose.comandasfina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    String pla,pla2,pla3,nota;
    TextView note,pri1,pri2,sec1,sec2,sec3,sec4,terc1,terc2 , usu;
    Button fin;
    String pizza;
    String aco ;
    String notas;
    String aco2 ;
    String aco3 ;
    String aco4 ;
    String aco5 ;
    Intent ini;
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rfinal);
        if(b==null) {
            b = new Bundle();
        }
        pri1 = (TextView) findViewById(R.id.t1);
        pri2 = (TextView) findViewById(R.id.t2);
        sec1 = (TextView) findViewById(R.id.t3);
        sec2 = (TextView) findViewById(R.id.t4);
        sec3 = (TextView) findViewById(R.id.t43);
        sec4 = (TextView) findViewById(R.id.t44);
        terc1 = (TextView) findViewById(R.id.t5);
        terc2= (TextView) findViewById(R.id.t52);
        usu = (TextView) findViewById(R.id.t41);
        note = (TextView) findViewById(R.id.note);
        fin = (Button) findViewById(R.id.fin2);
        b = getIntent().getExtras();
        pla = b.getString("pla");
        pizza = b.getString("pizza");
        aco2 = b.getString("co2");
        aco3 = b.getString("co3");
        aco4 = b.getString("co4");
        aco5 = b.getString("co5");
        pla2 = b.getString("pla2");
        pla3 = b.getString("pla3");
        notas = b.getString("nota");
        note.setText(notas);
        if(pla!=null){
            pri1.setVisibility(View.VISIBLE);
            pri2.setText(pla);
        }
        if(pla2!=null){
            sec1.setVisibility(View.VISIBLE);
            sec2.setText(pla2);
            if(pizza!=null){
                usu.setText(pizza);
            } else {
                usu.setText(aco2+""+aco3+""+aco4+""+aco5);
            }
        }
        if(pla3!=null){
            terc1.setVisibility(View.VISIBLE);
            terc2.setText(pla3);
        }
    }
}
