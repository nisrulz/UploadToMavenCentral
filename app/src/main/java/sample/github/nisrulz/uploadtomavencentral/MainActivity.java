package sample.github.nisrulz.uploadtomavencentral;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sample.github.nisrulz.demolibrary.ShowToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ShowToast.getInstance().toast(this, "Hello World Hooman!");
    }
}
