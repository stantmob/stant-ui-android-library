package br.com.stant.libraries.uilibrary.components.selecttimepickerview;

import android.app.Dialog;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.text.DecimalFormat;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SelectTimePickerViewBinding;
import br.com.stant.libraries.uilibrary.databinding.SelectTimePickerViewTimeNumberPickerDialogBinding;

/**
 * Created by denisvieira on 07/11/17.
 */

public class SelectTimePickerView extends LinearLayout implements SelectTimePickerViewContract {

    private SelectTimePickerViewBinding mSelectTimePickerViewBinding;
    private SelectTimePickerViewTimeNumberPickerDialogBinding mSelectTimePickerViewTimeNumberPickerDialogBinding;
    private Dialog mTimeNumberPickerDialog;
    private OnTimeSelected mOnTimeSelected;

    public SelectTimePickerView(Context context) {
        super(context);
        if(!isInEditMode())
            init(context);
    }

    public SelectTimePickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context);
    }

    public SelectTimePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context);
    }


    private void init(Context context) {
        mSelectTimePickerViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                context), R.layout.select_time_picker_view, this, true);
        setOnClickListener(this::openTimePickerDialog);
        initializeTimePickerDialogConfiguration();
    }

    private void initializeTimePickerDialogConfiguration() {
        mTimeNumberPickerDialog = new Dialog(getContext(), R.style.NumberPickerDialogTheme);
        mSelectTimePickerViewTimeNumberPickerDialogBinding =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                        R.layout.select_time_picker_view_time_number_picker_dialog,
                        null,
                        false);
        mTimeNumberPickerDialog.setContentView(mSelectTimePickerViewTimeNumberPickerDialogBinding.getRoot());
        mSelectTimePickerViewTimeNumberPickerDialogBinding.setHandler(this);
        numberPickerDialogConfiguration();
        setTime(0,0);
    }

    public void numberPickerDialogConfiguration() {
        mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogReworkHoursNumberPicker.setMaxValue(100);
        mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogReworkHoursNumberPicker.setMinValue(0);
        mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogReworkMinutesNumberPicker.setMaxValue(59);
        mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogReworkMinutesNumberPicker.setMinValue(0);
        mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogOkButtonTextView.setOnClickListener(this::onPressOkButtonOnNumberPickerDialog);
    }

    @Override
    public void openTimePickerDialog(View view) {
        mTimeNumberPickerDialog.show();
    }

    @Override
    public void setOnTimeSelected(OnTimeSelected onTimeSelected) {
        mOnTimeSelected = onTimeSelected;
    }

    @Override
    public void setTime(int hour, int minute) {
        String newTimeTextValue = getFormattedTimeValue(hour, minute);
        updateTimeTextValue(newTimeTextValue);
    }

    @Override
    public String getCurrentTime() {
        return mSelectTimePickerViewBinding.getTimeText();
    }

    @Override
    public void onPressOkButtonOnNumberPickerDialog(View view) {
        String newTimeTextValue = getTimeTextValueSelectedByPicker();
        updateTimeTextValue(newTimeTextValue);
        mTimeNumberPickerDialog.dismiss();

        if(mOnTimeSelected != null)
            mOnTimeSelected.onTimeSelected(newTimeTextValue);
    }

    private String getTimeTextValueSelectedByPicker(){
        int newHourValue = mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogReworkHoursNumberPicker.getValue();
        int newMinutesValue = mSelectTimePickerViewTimeNumberPickerDialogBinding.selectTimePickerViewTimeNumberPickerDialogReworkMinutesNumberPicker.getValue();
        return getFormattedTimeValue(newHourValue, newMinutesValue);
    }

    private void updateTimeTextValue(String newTimeTextValue){
        mSelectTimePickerViewBinding.setTimeText(newTimeTextValue);
    }

    private String getFormattedTimeValue(int hourValue, int minuteValue) {
        DecimalFormat df = new DecimalFormat("#00");
        String formattedTime = "";

        formattedTime = formattedTime.concat(String.valueOf(df.format(hourValue)));
        formattedTime = formattedTime.concat(":");
        formattedTime = formattedTime.concat(String.valueOf(df.format(minuteValue)));

        return formattedTime;
    }
}
