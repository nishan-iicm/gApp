package com.example.greetingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edtxt;
    String strg;
    TextView txtview;
    TextView txtview1;
    TextView txtview2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.edtxt=(EditText) findViewById(R.id.Enter_Text);
        this.txtview=(TextView) findViewById(R.id.Show_Greetings);
        this.txtview1=(TextView) findViewById(R.id.vowels);
        this.txtview2=(TextView) findViewById(R.id.consonents);
        Button button=(Button) findViewById(R.id.Btn);
        this.btn=button;
        button.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                if(edtxt.getText().length()==0)
                {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else {
                    String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.strg = mainActivity.edtxt.getText().toString();
                    char n = time.charAt(0);
                    char p = time.charAt(1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(n);
                    sb.append(p);
                    int temp = Integer.parseInt(sb.toString());
                    if (temp >= 0 && temp < 12) {
                        TextView textView = MainActivity.this.txtview;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Good Morning! ");
                        sb2.append(MainActivity.this.strg);
                        textView.setText(sb2.toString());
                    } else if (temp < 12 || temp >= 17) {
                        TextView textView2 = MainActivity.this.txtview;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Good Evening! ");
                        sb3.append(MainActivity.this.strg);
                        textView2.setText(sb3.toString());
                    } else {
                        TextView textView3 = MainActivity.this.txtview;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Good Afternoon! ");
                        sb4.append(MainActivity.this.strg);
                        textView3.setText(sb4.toString());
                    }
                    Integer vCount, cCount;
                    vCount=0;
                    cCount=0;

                    String sb5 = edtxt.getText().toString();
                    sb5 = sb5.toLowerCase();

                    for(int i = 0; i < sb5.length(); i++) {
                        //Checks whether a character is a vowel
                        if(sb5.charAt(i) == 'a' || sb5.charAt(i) == 'e' || sb5.charAt(i) == 'i' || sb5.charAt(i) == 'o' || sb5.charAt(i) == 'u') {
                            //Increments the vowel counter
                            vCount++;
                        }
                        //Checks whether a character is a consonant
                        else if(sb5.charAt(i) >= 'a' && sb5.charAt(i)<='z') {
                            //Increments the consonant counter
                            cCount++;
                        }
                    }
                    txtview1.setText("No of Vowels in the name is "+vCount);
                    txtview2.setText("No of Consonents in the name is "+cCount);




                }
            }
        });
    }
}