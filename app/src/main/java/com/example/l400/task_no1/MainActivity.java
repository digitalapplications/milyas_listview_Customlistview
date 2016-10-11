package com.example.l400.task_no1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.listView);
        String[] names = {"ILYAS \n ilyas@gmail.com" ,"FAZAL NABI\n fazal@gmail.com" , "HAMMAD \n hammad@gmail"};
        int[] images = {R.drawable.ilyas,R.drawable.av,R.drawable.im};
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,names,images);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Detail.class);
                String value = listView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "You just click on"+ value, Toast.LENGTH_SHORT).show();
                intent.putExtra("value",value);
                startActivity(intent);
            }
        });


    }
    private class CustomAdapter extends ArrayAdapter<String>{
            Context context;
            String[] names;
           int[] images;
        public CustomAdapter(Context context, String[] names, int[] images) {
            super(context,R.layout.custom_layout , names);
            this.context = context;
            this.names = names;
            this.images = images;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.custom_layout,parent,false);
            TextView textView = (TextView)view.findViewById(R.id.tetview);
            ImageView imageView = (ImageView)view.findViewById(R.id.ilyas);
            textView.setText(names[position]);
            imageView.setImageResource(images[position]);
            return view;

        }
    }
}
