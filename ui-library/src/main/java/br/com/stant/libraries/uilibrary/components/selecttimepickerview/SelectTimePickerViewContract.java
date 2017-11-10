package br.com.stant.libraries.uilibrary.components.selecttimepickerview;

import android.view.View;

/**
 * Created by denisvieira on 07/11/17.
 */

public interface SelectTimePickerViewContract {


    void openTimePickerDialog(View view);
    void setOnTimeSelected(OnTimeSelected onTimeSelected);
    void setTime(int hour, int minute);
    String getCurrentTime();
    void onPressOkButtonOnNumberPickerDialog(View view);

    interface OnTimeSelected {
        void onTimeSelected(String newTimeTextValue);
    }

}
