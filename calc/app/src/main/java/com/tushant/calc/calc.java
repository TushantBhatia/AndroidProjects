package com.tushant.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.tushant.calc.R.id.button3;

public class calc extends AppCompatActivity implements View.OnClickListener{
    private EditText ed1, ed2;
    private Button b1, b2, b3, b4;
    private TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        //Button b1, b2, b3, b4;

        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        t3 = (TextView) findViewById(R.id.textView3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            String n1=ed1.getText().toString();
            String n2=ed2.getText().toString();
            Integer t1,t2;
            t1=Integer.parseInt(n1)  ;
            t2=Integer.parseInt(n2);
            Integer result;
            result=t1+t2;
            t3.setText(""+result);
        }
        else if(v.getId() == R.id.button2){
            String n1=ed1.getText().toString();
            String n2=ed2.getText().toString();
            Integer t1,t2;
            t1=Integer.parseInt(n1)  ;
            t2=Integer.parseInt(n2);
            Integer result;
            result=t1-t2;
            t3.setText(""+result);
        }
        else if(v.getId() == button3){
            String n1=ed1.getText().toString();
            String n2=ed2.getText().toString();
            Integer t1,t2;
            t1=Integer.parseInt(n1)  ;
            t2=Integer.parseInt(n2);
            Integer result;
            result=t1*t2;
            t3.setText(""+result);
        }
        else if(v.getId() == R.id.button4){
            String n1=ed1.getText().toString();
            String n2=ed2.getText().toString();
            Integer t1,t2;
            t1=Integer.parseInt(n1)  ;
            t2=Integer.parseInt(n2);
            Float result;
            result= Float.valueOf(t1/t2);
            t3.setText(""+result);
        }

    }
};
    /* we can also create a class like this

        View.OnClickListener l =new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s1=ed1.getText().toString();
                t3.setText(s1);
            }
        };
    }
    */
    /*  we  can also create a inner class and call onclick function in it
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.getText().toString();

            }
        });
    }*/
    /*
    public void add(View view)
    {
        String n1=ed1.getText().toString();
        String n2=ed2.getText().toString();
        Integer t1,t2;
        t1=Integer.parseInt(n1)  ;
        t2=Integer.parseInt(n2);
        Integer result;
        result=t1+t2;
        t3.setText(""+result);
    }

    public void subtract(View view)
    {
        String n1=ed1.getText().toString();
        String n2=ed2.getText().toString();
        Integer t1,t2;
        t1=Integer.parseInt(n1)  ;
        t2=Integer.parseInt(n2);
        Integer result;
        result=t1-t2;
        t3.setText(""+result);
    }

    public void multiply(View view)
    {
        String n1=ed1.getText().toString();
        String n2=ed2.getText().toString();
        Integer t1,t2;
        t1=Integer.parseInt(n1)  ;
        t2=Integer.parseInt(n2);
        Integer result;
        result=t1*t2;
        t3.setText(""+result);
    }

    public void divide(View view)
    {
        String n1=ed1.getText().toString();
        String n2=ed2.getText().toString();
        Integer t1,t2;
        t1=Integer.parseInt(n1)  ;
        t2=Integer.parseInt(n2);
        Float result;
        result= Float.valueOf(t1/t2);
        t3.setText(""+result);
    }
}*/
