package br.com.stant.libraries.stantuiandroid.componentsactivities.simpleinformationscardview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SeverityLevelIndicatorViewTestActBinding;
import br.com.stant.libraries.stantuiandroid.databinding.SimpleInformationsCardViewTestActBinding;

public class SimpleInformationsCardViewActivity extends AppCompatActivity {

    private SimpleInformationsCardViewTestActBinding mSimpleInformationsCardViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSimpleInformationsCardViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.simple_informations_card_view_test_act);

        mSimpleInformationsCardViewTestActBinding.simpleInformationCard.setFirstValue("First Value");
        mSimpleInformationsCardViewTestActBinding.simpleInformationCard.setSecondValue("Second Value");


    }

}
