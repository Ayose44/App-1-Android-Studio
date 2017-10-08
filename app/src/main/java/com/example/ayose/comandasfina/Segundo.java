package com.example.ayose.comandasfina;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Segundo extends Activity {
    Button r1,r2,r3,r4,r5,r6,r7,r8;
    String pla,pla2,pla3,bebi;
    Bundle b = new Bundle();
    Intent ini;
    private static final int MNU_OPC=1;
    private static final int MNU_OPC2=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo);
        if(b==null){
            b=new Bundle();
        }

        b = getIntent().getExtras();
        if(b==null){
            b=new Bundle();
        }

        r1 = (Button) findViewById(R.id.r1);
        r2 = (Button) findViewById(R.id.r2);
        r3 = (Button) findViewById(R.id.r3);
        r4 = (Button) findViewById(R.id.r4);
        r5 = (Button) findViewById(R.id.r5);
        r6 = (Button) findViewById(R.id.r6);
        r7 = (Button) findViewById(R.id.r7);
        r8 = (Button) findViewById(R.id.r8);



        pla=b.getString("pla");
        pla2=b.getString("pla2");
        pla3=b.getString("pla3");
        bebi=b.getString("beb");
        r1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                b.putString("pla2" , r1.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();

            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla2" , r2.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });

        r3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                b.putString("pla2" , r3.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();         }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla2" , r5.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });
        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla2" , r6.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });
        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla2" , r7.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });
        r8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla2" , r8.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla2" , r4.getText().toString());
                ini = new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()){
            case R.id.s:
                // int id=item.getItemId();
                // if(id==R.id.opt1){
                finish();
                System.exit(0);
                return true;
            case R.id.b:
                b.putString("pla",pla);
                b.putString("pla2",pla2);
                b.putString("pla3",pla3);
                b.putString("beb",bebi);
                ini =  new Intent(Segundo.this,MainActivity.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        LayoutInflater inflater = getLayoutInflater();
        // Inflate the Layout
        View layout = inflater.inflate(R.layout.my_custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_layout));

        TextView text = (TextView) layout.findViewById(R.id.textToShow);
        // Set the Text to show in TextView
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
}
