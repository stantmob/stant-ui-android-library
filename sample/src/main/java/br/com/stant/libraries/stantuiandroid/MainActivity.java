package br.com.stant.libraries.stantuiandroid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.databinding.ActivityMainBinding;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorview.SeverityLevelEnum;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String text = "Você compra o equipamento";
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setExpandableText(text);
        activityMainBinding.setTitle("titulo test");
        activityMainBinding.setValue(0);
        activityMainBinding.setSeverityLevelValue(SeverityLevelEnum.SERIOUS);
//        activityMainBinding.setSubtitle("subtitulo test");

    }
}
