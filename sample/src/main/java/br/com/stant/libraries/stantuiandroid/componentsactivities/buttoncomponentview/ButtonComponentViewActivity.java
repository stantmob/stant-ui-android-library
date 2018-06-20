package br.com.stant.libraries.stantuiandroid.componentsactivities.buttoncomponentview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ButtonComponentViewTestActBinding;
import br.com.stant.libraries.uilibrary.databinding.ButtonComponentBinding;

public class ButtonComponentViewActivity extends AppCompatActivity {

    private ButtonComponentViewTestActBinding mButtonComponentViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mButtonComponentViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.button_component_view_test_act);
        mButtonComponentViewTestActBinding.setButtonShadowShape(getResources().getDrawable(R.drawable.shape_round_dark_blue));
        mButtonComponentViewTestActBinding.setButtonShape(getResources().getDrawable(R.drawable.shape_round_blue));
        mButtonComponentViewTestActBinding.setButtonText(getResources().getString(R.string.button_component_text));

//        mButtonComponentBinding = DataBindingUtil.setContentView(this, R.layout.);
//
//
//
//        mButtonComponentBinding.buttonComponent.setAc(new OnClickActionButtonListener() {
//            @Override
//            public void onClick() {
//                Toast.makeText(ButtonComponentViewActivity.this, "Horizontal Component", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mButtonComponentBinding.actionButtonViewVerticalComponent.setOnClickActionButtonListener(new OnClickActionButtonListener() {
//            @Override
//            public void onClick() {
//                Toast.makeText(ButtonComponentViewActivity.this, "Vertical Component", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
