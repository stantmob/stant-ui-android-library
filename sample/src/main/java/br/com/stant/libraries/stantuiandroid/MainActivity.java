package br.com.stant.libraries.stantuiandroid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String text = "In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.In lobortis quam sit amet.";
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setExpandableText(text);

    }
}
