package com.example.project1;

import android.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Trace;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Button get=(Button) findViewById(R.id.get);
        final Button refresh=(Button)findViewById(R.id.refresh);
        Button clear=(Button)findViewById(R.id.clear);
        final MessageController msgController=new MessageController(new NotificationCenter());
        NotificationCenter notificationCenter=new NotificationCenter();
        notificationCenter.register(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
               RelativeLayout layout=(RelativeLayout) findViewById(R.id.my_layout);
               LinearLayout list =findViewById(R.id.list);
               list.removeView(findViewById(1));
               list.removeView(findViewById(2));

            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                TextView textView=new TextView(getApplicationContext());
                textView.setGravity(1);
                textView.setId(1);
                StringBuilder numList=new StringBuilder();
                LinearLayout layout=findViewById(R.id.list);
                msgController.fetch(false);
//                int[] nums=msgController.fetch(false);
//                for (int i = 0; i <nums.length; i++) {
//                    numList.append(nums[i]);
//                    numList.append("\n");
//                }
//                textView.setText(numList);
//                layout.addView(textView);


               // list.addView(text);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                TextView textView=new TextView(getApplicationContext());
                textView.setGravity(1);
                textView.setId(2);
                StringBuilder numList=new StringBuilder();
                LinearLayout layout=findViewById(R.id.list);
                msgController.fetch(true);
//                int[] nums=msgContoller.fetch(true);
//                for (int i = 0; i <nums.length; i++) {
//                    numList.append(nums[i]);
//                    numList.append("\n");
//                }
//                textView.setText(numList);
//                layout.addView(textView);



            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("ResourceType")
    @Override
        public void update(Observable o, Object message) {
            System.out.println("in update");
            int [] messages = (int[]) message;
            TextView textView=new TextView(getApplicationContext());
            textView.setGravity(1);
            textView.setId(1);
            StringBuilder numList=new StringBuilder();
            LinearLayout layout=findViewById(R.id.list);

            for (int i = 0; i <messages.length; i++) {
                numList.append(messages[i]);
                numList.append("\n");
            }
            textView.setText(numList);
            layout.addView(textView);

        }
}
