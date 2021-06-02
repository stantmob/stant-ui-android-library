package br.com.stant.libraries.stantuiandroid.componentsactivities.selecttimepickerview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SelectTimePickerViewTestActBinding;

public class SelectTimePickerViewActivity extends AppCompatActivity {

    private SelectTimePickerViewTestActBinding mSelectTimePickerViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSelectTimePickerViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.select_time_picker_view_test_act);

    }


}
