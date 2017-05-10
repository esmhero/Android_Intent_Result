package com.example.wangwei.android_intent_result;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private final static int REQUESTCODE =1;//返回的结果码
    private EditText one,two,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)this.findViewById(R.id.button1);
        one=(EditText)this.findViewById(R.id.one);
        two=(EditText)this.findViewById(R.id.two);
        result=(EditText)this.findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(one.getText().toString()) ;
                int b=Integer.parseInt(two.getText().toString()) ;
                Intent intent=new Intent(MainActivity.this,OtherActivity.class);
                intent.putExtra("a",a);
                intent.putExtra("b",b);

                startActivityForResult(intent,REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==2){
            int three = data.getIntExtra("three",0);
            result.setText(String.valueOf(three));
        }

    }
}
