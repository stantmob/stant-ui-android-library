package br.com.stant.libraries.stantuiandroid.componentsactivities.buttoncomponentview;

import androidx.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ButtonComponentViewTestActBinding;

public class ButtonComponentViewActivity extends AppCompatActivity {

    private ButtonComponentViewTestActBinding mButtonComponentViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mButtonComponentViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.button_component_view_test_act);

        mButtonComponentViewTestActBinding.buttonComponentView.setActiveStatusOnButton(
                (view) -> Toast.makeText(ButtonComponentViewActivity.this, "Button", Toast.LENGTH_SHORT).show()
        );

    }

    public void setButtonDesign(Drawable shadowShape, Drawable shape, String text) {
        mButtonComponentViewTestActBinding.buttonComponentView.setButtonShadowShape(shadowShape);
        mButtonComponentViewTestActBinding.buttonComponentView.setButtonShape(shape);
        mButtonComponentViewTestActBinding.buttonComponentView.setButtonText(text);
    }


}
