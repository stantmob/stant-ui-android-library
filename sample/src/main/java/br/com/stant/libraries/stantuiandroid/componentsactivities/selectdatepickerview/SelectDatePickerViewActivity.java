package br.com.stant.libraries.stantuiandroid.componentsactivities.selectdatepickerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SelectDatePickerViewTestActBinding;

public class SelectDatePickerViewActivity extends AppCompatActivity {

    private SelectDatePickerViewTestActBinding mSelectDatePickerViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSelectDatePickerViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.select_date_picker_view_test_act);
    }


}
