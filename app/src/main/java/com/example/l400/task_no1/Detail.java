package com.example.l400.task_no1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {

    TextView name,rol,quli,expe,cont;
    ImageView imageView,messger,call;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar();
        name = (TextView)findViewById(R.id.ilyas);
        rol = (TextView)findViewById(R.id.textView2);
        quli = (TextView)findViewById(R.id.quli);
        expe = (TextView)findViewById(R.id.expe);
        cont = (TextView)findViewById(R.id.cont);
        imageView = (ImageView)findViewById(R.id.imageVie);
        messger = (ImageView)findViewById(R.id.messger);
        call = (ImageView)findViewById(R.id.call);
        String value = getIntent().getStringExtra("value");
        if(value.equals("ILYAS")){
            name.setText(value);
            rol.setText("Internee");
            quli.setText("BS SE");
            expe.setText("Android Developer");
            cont.setText("03139997889");
            String val = "ilyas";
            int res = getResources().getIdentifier(val , "drawable",getPackageName());
            imageView.setImageResource(res);
        }
        if (value.equals("FAZAL NABI")){
            name.setText(value);
            rol.setText("Team Member");
            quli.setText("BS cE");
            expe.setText("IOS Developer");
            cont.setText("03328767543");
            String val = "av";
            int res = getResources().getIdentifier(val , "drawable",getPackageName());
            imageView.setImageResource(res);
        }
        if(value.equals("HAMMAD")){
            name.setText(value);
            rol.setText("Developer");
            quli.setText("MS SE");
            expe.setText("Web Developer");
            cont.setText("03457563421");
            String val = "im";
            int res = getResources().getIdentifier(val , "drawable",getPackageName());
            imageView.setImageResource(res);
        }
        messger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("Sms TO :"));
                    intent.setType("vnd.android-dir/mms-sms");
                    intent.putExtra("address" ,cont.getText().toString());
                    intent.putExtra("sms_body" , "hi");
                    startActivity(intent);
                }
              catch (Exception e){
                  e.printStackTrace();
              }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:"+cont.getText()));
                try { startActivity(phoneIntent);
                    finish();
                }
                catch (android.content.ActivityNotFoundException ex)
                { Toast.makeText(Detail.this, "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
