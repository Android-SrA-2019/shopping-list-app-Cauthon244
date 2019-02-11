package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class SecondActivity extends AppCompatActivity {

public static final String EXTRA_MESSAGE = "ca.nbcc.shoppinglist.extra.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addItem (View view) {
        Intent replyIntent=new Intent();
        String message=((Button)view).getText().toString();
        replyIntent.putExtra(EXTRA_MESSAGE, message);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
