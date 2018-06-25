package br.com.stant.libraries.stantuiandroid.componentsactivities.buttoncomponentview;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.componentsactivities.actionbuttonview.ActionButtonViewActivity;
import br.com.stant.libraries.stantuiandroid.databinding.ButtonComponentViewTestActBinding;
import br.com.stant.libraries.uilibrary.databinding.ButtonComponentBinding;

public class ButtonComponentViewActivity extends AppCompatActivity {

    private ButtonComponentViewTestActBinding mButtonComponentViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mButtonComponentViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.button_component_view_test_act);

        mButtonComponentViewTestActBinding.buttonComponentView.setActiveStatusOnButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonComponentViewActivity.this, "Button", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void setButtonDesign(Drawable shadowShape, Drawable shape, String text) {
        mButtonComponentViewTestActBinding.buttonComponentView.setButtonShadowShape(shadowShape);
        mButtonComponentViewTestActBinding.buttonComponentView.setButtonShape(shape);
        mButtonComponentViewTestActBinding.buttonComponentView.setButtonText(text);
    }

}
