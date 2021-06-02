package br.com.stant.libraries.uilibrary.components.selectdatepickerview;

import android.app.DatePickerDialog;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Calendar;
import java.util.Date;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SelectDatePickerViewBinding;

import static br.com.stant.libraries.uilibrary.utils.DateUtils.formatBrDate;

/**
 * Created by denisvieira on 26/10/17.
 */

public class SelectDatePickerView extends LinearLayout implements SelectDatePickerViewContract {

    private SelectDatePickerViewBinding mSelectDatePickerViewBinding;
    private DatePickerDialog mDatePickerDialog;
    private Date mDateSelected;
    private OnDateSelect mOnDateSelected;

    public SelectDatePickerView(Context context) {
        super(context);
        if(!isInEditMode())
            init(context);
    }

    public SelectDatePickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context);
    }

    public SelectDatePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context);
    }

    private void init(Context context) {
        mSelectDatePickerViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                context), R.layout.select_date_picker_view, this, true);

        mSelectDatePickerViewBinding.setDate(formatBrDate(new Date()));

        setOnClickListener(this::openDatePickerDialog);

        initializeDatePickerDialogConfiguration();
    }

    private void initializeDatePickerDialogConfiguration() {
        Calendar calendar  = Calendar.getInstance();

        mDatePickerDialog = new DatePickerDialog(getContext(),
                getOnDateSetListener(), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    private DatePickerDialog.OnDateSetListener getOnDateSetListener() {
        return (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            setDate(newDate.getTime());

            if(mOnDateSelected != null)
                mOnDateSelected.onDateSelect(mDateSelected);
        };
    }

    @Override
    public void openDatePickerDialog(View view) {
        mDatePickerDialog.show();
    }

    @Override
    public void setOnDateSelected(OnDateSelect onDateSelected) {
        mOnDateSelected = onDateSelected;
    }

    @Override
    public void setDate(Date date) {
        mDateSelected = date;
        mSelectDatePickerViewBinding.setDate(formatBrDate(mDateSelected));
    }

    @Override
    public Date getCurrentDate() {
        return mDateSelected;
    }
}
