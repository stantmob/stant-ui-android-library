package br.com.stant.libraries.uilibrary.components.selectdatepickerview;

import android.view.View;

import java.util.Date;

/**
 * Created by denisvieira on 26/10/17.
 */

public interface SelectDatePickerViewContract {
    void openDatePickerDialog(View view);
    void setOnDateSelected(OnDateSelect onDateSelect);
    void setDate(Date date);
    Date getCurrentDate();

    interface OnDateSelect {
        void onDateSelect(Date date);
    }

}
