package br.com.stant.libraries.stantuiandroid.componentsactivities.executedpercentbarview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ExecutedPercentBarViewTestActBinding;

public class ExecutedPercentBarViewActivity extends AppCompatActivity {

    private ExecutedPercentBarViewTestActBinding mExecutedPercentBarViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExecutedPercentBarViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.executed_percent_bar_view_test_act);
        setPercentage(60);
    }

    public void setPercentage(Integer percentage) {
        mExecutedPercentBarViewTestActBinding.executedPercentBar.setPercentValue(percentage);
    }


}
