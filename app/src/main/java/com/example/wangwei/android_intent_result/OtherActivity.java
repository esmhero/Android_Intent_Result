package com.example.wangwei.android_intent_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by wangwei on 2017/5/10.
 */

public class OtherActivity extends Activity {
    private Button button;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        button =(Button)this.findViewById(R.id.button2);
        textView=(TextView)this.findViewById(R.id.textView2);
        editText=(EditText)this.findViewById(R.id.three);
        final Intent intent= getIntent();
        int a=intent.getIntExtra("a",0);
        int b=intent.getIntExtra("b",0);
        textView.setText(a+"+"+b+"="+"?");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                int three=Integer.parseInt(editText.getText().toString());
                intent1.putExtra("three",three);
                setResult(2,intent1);
                finish();

            }
        });

    }
}
