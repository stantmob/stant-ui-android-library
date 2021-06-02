package br.com.stant.libraries.stantuiandroid.componentsactivities.increasedecreasebuttonsview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.IncreaseDecreaseButtonsViewTestActBinding;

public class IncreaseDecreaseButtonsViewActivity extends AppCompatActivity {

    private IncreaseDecreaseButtonsViewTestActBinding mIncreaseDecreaseButtonsViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIncreaseDecreaseButtonsViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.increase_decrease_buttons_view_test_act);

        mIncreaseDecreaseButtonsViewTestActBinding.increaseDecreaseButtons.setOnPressIncreaseButton(
                (view) -> Toast.makeText(IncreaseDecreaseButtonsViewActivity.this, "Increase Button Action", Toast.LENGTH_SHORT).show()
        );

        mIncreaseDecreaseButtonsViewTestActBinding.increaseDecreaseButtons.setOnPressDecreaseButton(
                (view) -> Toast.makeText(IncreaseDecreaseButtonsViewActivity.this, "Decrease Button Action", Toast.LENGTH_SHORT).show()
        );

        mIncreaseDecreaseButtonsViewTestActBinding.increaseDecreaseButtons.setIncreaseDecreaseTextSize(16);
    }


}
