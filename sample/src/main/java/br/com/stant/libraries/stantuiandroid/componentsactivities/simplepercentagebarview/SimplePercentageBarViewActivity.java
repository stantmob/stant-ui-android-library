package br.com.stant.libraries.stantuiandroid.componentsactivities.simplepercentagebarview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SimpleInformationsCardViewTestActBinding;
import br.com.stant.libraries.stantuiandroid.databinding.SimplePercentageBarViewTestActBinding;

public class SimplePercentageBarViewActivity extends AppCompatActivity {

    private SimplePercentageBarViewTestActBinding mSimplePercentageBarViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSimplePercentageBarViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.simple_percentage_bar_view_test_act);
        mSimplePercentageBarViewTestActBinding.simplePercentageBar.setExecutedPercent(10);
        mSimplePercentageBarViewTestActBinding.simplePercentageBar.setSelectedPercent(30);
    }

}
