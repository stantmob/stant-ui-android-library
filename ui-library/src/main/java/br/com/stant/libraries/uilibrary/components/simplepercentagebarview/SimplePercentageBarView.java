package br.com.stant.libraries.uilibrary.components.simplepercentagebarview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.math.BigDecimal;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SimplePercentageBarViewBinding;

/**
 * Created by denisvieira on 18/10/17.
 */

public class SimplePercentageBarView extends LinearLayout implements SimplePercentageBarViewContract {

    private SimplePercentageBarViewBinding mSimplePercentageBarViewBinding;
    private double mExecutedPercentage;
    private double mSelectedPercentage;

    public SimplePercentageBarView(Context context) {
        super(context);
        if(!isInEditMode())
            mSimplePercentageBarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                    context), R.layout.simple_percentage_bar_view, this, true);
    }

    public SimplePercentageBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context, attrs);
    }

    public SimplePercentageBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mSimplePercentageBarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                context), R.layout.simple_percentage_bar_view, this, true);
    }

    @Override
    public void setSelectedPercent(double selectedPercent) {
        double percentageTotalSum = mExecutedPercentage + selectedPercent;
        if(percentageTotalSum > 100){
            double remaningValue = 100 - mExecutedPercentage;
            mSelectedPercentage = remaningValue;
            BigDecimal number = new BigDecimal(mSelectedPercentage);
            float remainingValueInFloat = number.floatValue();
            mSimplePercentageBarViewBinding.setSelectedPercentValue(remainingValueInFloat);
        }else{
            mSelectedPercentage = selectedPercent;
            float selectedPercentInFloat = (float) selectedPercent;
            mSimplePercentageBarViewBinding.setSelectedPercentValue(selectedPercentInFloat);
        }
    }

    @Override
    public void setExecutedPercent(double executedPercent) {
        mExecutedPercentage = executedPercent;
        BigDecimal number = new BigDecimal(mExecutedPercentage);
        float executedPercentInFloat = number.floatValue();
        mSimplePercentageBarViewBinding.setExecutedPercentValue(executedPercentInFloat);

        if(mExecutedPercentage == 100){
            mSimplePercentageBarViewBinding.simplePercentageBarViewExecutedLinearLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_rounded_green_strength));
        } else if (mExecutedPercentage == 0){
            mSimplePercentageBarViewBinding.simplePercentageBarViewSelectedLinearLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_rounded_percentage_bar_green_base));
        }
    }
}
