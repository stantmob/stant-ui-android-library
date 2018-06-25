package br.com.stant.libraries.stantuiandroid.componentactivities.actionbuttonview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import br.com.stant.libraries.stantuiandroid.databinding.ActionButtonViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.actionbuttonview.ActionButtonViewContract.OnClickActionButtonListener;

public class ActionButtonViewActivity extends AppCompatActivity {

    private ActionButtonViewTestActBinding mActionButtonViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionButtonViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.action_button_view_test_act);
        mActionButtonViewTestActBinding.actionButtonViewHorizontalComponent.setOnClickActionButtonListener(new OnClickActionButtonListener() {
            @Override
            public void onClick() {

            }
        });
        mActionButtonViewTestActBinding.actionButtonViewVerticalComponent.setOnClickActionButtonListener(new OnClickActionButtonListener() {
            @Override
            public void onClick() {

            }
        });
    }
}
