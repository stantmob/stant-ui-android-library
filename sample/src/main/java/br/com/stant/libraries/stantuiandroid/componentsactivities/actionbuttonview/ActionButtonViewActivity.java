package br.com.stant.libraries.stantuiandroid.componentsactivities.actionbuttonview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ActionButtonViewTestActBinding;

public class ActionButtonViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionButtonViewTestActBinding mActionButtonViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.action_button_view_test_act);

        mActionButtonViewTestActBinding.actionButtonViewHorizontalComponent.setOnClickActionButtonListener(
                () -> Toast.makeText(ActionButtonViewActivity.this, "Horizontal Component", Toast.LENGTH_SHORT).show()
        );
        mActionButtonViewTestActBinding.actionButtonViewVerticalComponent.setOnClickActionButtonListener(
                () -> Toast.makeText(ActionButtonViewActivity.this, "Vertical Component", Toast.LENGTH_SHORT).show()
        );
    }


}
