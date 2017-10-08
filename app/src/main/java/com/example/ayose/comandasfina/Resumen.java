package com.example.ayose.comandasfina;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Resumen extends Activity {
String pla,pla2,pla3,bebi;
TextView pri1,pri2,sec1,sec2,terc1,terc2,bebi1,bebi2;
Intent ini;
    Bundle b = new Bundle();
    private static final int MNU_OPC=1;
    private static final int MNU_OPC2=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.resumen);
        if(b==null) {
            b = new Bundle();
        }

        pri1 = (TextView) findViewById(R.id.t1);
        pri2 = (TextView) findViewById(R.id.t2);
        sec1 = (TextView) findViewById(R.id.t3);
        sec2 = (TextView) findViewById(R.id.t4);
        terc1 = (TextView) findViewById(R.id.t5);
        terc2= (TextView) findViewById(R.id.t52);
        bebi1=(TextView) findViewById(R.id.t0);
        bebi2=(TextView)findViewById(R.id.t01);
         b = getIntent().getExtras();
             pla = b.getString("pla");
             pla2 = b.getString("pla2");
             pla3 = b.getString("pla3");
             bebi = b.getString("beb");

        if(pla!=null){
            pri1.setVisibility(View.VISIBLE);
            pri2.setText(pla);

        }
        if(pla2!=null){
            sec1.setVisibility(View.VISIBLE);
            sec2.setText(pla2);

        }
        if(pla3!=null){
            terc1.setVisibility(View.VISIBLE);
            terc2.setText(pla3);
        }

        if(bebi!=null){
            bebi1.setVisibility(View.VISIBLE);
            bebi2.setText(bebi);
        }
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
                ini =  new Intent(Resumen.this,MainActivity.class);
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
