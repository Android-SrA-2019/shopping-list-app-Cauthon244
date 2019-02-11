package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private ShopList items = new ShopList();
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if ((savedInstanceState != null)&& (savedInstanceState.getSerializable("list")!= null)){
            HashMap<String, Integer> l = (HashMap<String, Integer>)savedInstanceState.getSerializable("list");
            TextView tv = findViewById(R.id.textView);
            tv.setText("");
            for (String k : l.keySet()) {
                String s = l.get(k).toString() + " " + k + "\n";
                tv.setText(tv.getText() + s);
                for(int i = 0; i<l.get(k); i++){
                items.addItem(k);}
            }
            }
        }

    public void launchSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("list", items.getItems());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
                items.addItem(item);
            }
            drawView();
        }
    }

    public void drawView() {
        HashMap<String, Integer> l = items.getItems();
        TextView tv = findViewById(R.id.textView);
        tv.setText("");
        for (String k : l.keySet()) {
            String s = l.get(k).toString() + " " + k + "\n";
            tv.setText(tv.getText() + s);
        }
    }
}
