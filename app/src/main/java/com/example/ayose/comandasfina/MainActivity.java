package com.example.ayose.comandasfina;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.ayose.comandasfina.R.drawable.eng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {
    Button primer, sec, terc, fin, beb,idiom;
    String pla , pla2 , pla3 , bebi;
    Intent ini;
     Locale locale,myLocale;
    Configuration config = new Configuration();
    Context context;
    Spinner spinnerctrl;

    Bundle b = new Bundle();
    private static final int MNU_OPC=1;
    private static final int MNU_OPC2=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = getIntent().getExtras();
        if(b==null) {
            b = new Bundle();
        }
        primer = (Button) findViewById(R.id.prim);
        sec = (Button) findViewById(R.id.sec);
        terc = (Button) findViewById(R.id.postre);
        fin = (Button) findViewById(R.id.fin);
        beb = (Button) findViewById(R.id.beb);
        bebi=b.getString("beb");
        pla2=b.getString("pla2");
        pla=b.getString("pla");
        pla3=b.getString("pla3");
        if(pla!=null && pla2!=null) {
            fin.setVisibility(View.VISIBLE);
        } else {
            if (pla2 != null && pla3 != null) {
                fin.setVisibility(View.VISIBLE);
            } else {
                if (pla != null && pla3 != null) {
                    fin.setVisibility(View.VISIBLE);
                } else {
                    if (pla != null && bebi != null) {
                        fin.setVisibility(View.VISIBLE);
                    } else {
                        if (pla2 != null && bebi != null) {
                            fin.setVisibility(View.VISIBLE);
                        } else {
                            if (pla3 != null && bebi != null) {
                                fin.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }
            }
        }
            primer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b.putString("pla2", pla2);
                    b.putString("beb",bebi);
                    b.putString("pla3", pla3);
                    ini = new Intent(MainActivity.this, Primer.class);
                    ini.putExtras(b);
                    startActivity(ini);
                    finish();
                }
            });

        beb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("pla", pla);
                b.putString("pla2", pla2);
                b.putString("pla3",pla3);
                ini = new Intent(MainActivity.this, Bebida.class);
                ini.putExtras(b);
                startActivity(ini);
                finish();
            }
        });

        sec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b.putString("pla", pla);
                    b.putString("beb",bebi);
                    b.putString("pla3", pla3);
                    ini = new Intent(MainActivity.this, Segundo.class);
                    ini.putExtras(b);
                    startActivity(ini);
                    finish();
                }
            });

            terc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b.putString("pla", pla);
                    b.putString("pla2", pla2);
                    b.putString("beb",bebi);
                    ini = new Intent(MainActivity.this, Postre.class);
                    ini.putExtras(b);
                    startActivity(ini);
                    finish();
                }
            });


            fin.setOnClickListener(new View.OnClickListener() {

                @Override


                public void onClick(View v) {
                    b.putString("pla", pla);
                    b.putString("pla2", pla2);
                    b.putString("pla3", pla3);
                    ini = new Intent(MainActivity.this, Resumen.class);
                    ini.putExtras(b);
                    startActivity(ini);
                    finish();

                }

            });

        spinnerctrl = (Spinner) findViewById(R.id.spinner1);
        String[] idioma = {"Language","Español","English"};
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, R.layout.spinner_item, idioma);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropwdown_item);
        spinnerctrl.setAdapter(dataAdapter);

        spinnerctrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {


                    if (pos == 1) {
                        setLocale("es");
                    } else if (pos == 2) {
                        setLocale("en");
                    }

                }


            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
        }

    private static boolean updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
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
        toast.show();    }

    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);

    }


}
