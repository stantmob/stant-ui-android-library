package br.com.stant.libraries.uilibrary.components.simplepercentagebarview;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SimplePercentageBarViewBinding;

/**
 * Created by denisvieira on 18/10/17.
 */

public class SimplePercentageBarView extends LinearLayout implements SimplePercentageBarViewContract {

    private SimplePercentageBarViewBinding mSimplePercentageBarViewBinding;
    private float mExecutedPercentage;
    private float mSelectedPercentage;

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
    public void setSelectedPercent(float selectedPercent) {
        float percentageTotalSum = mExecutedPercentage + selectedPercent;
        if(percentageTotalSum > 100){
            float remaningValue = 100 - mExecutedPercentage;
            mSelectedPercentage = remaningValue;
            mSimplePercentageBarViewBinding.setSelectedPercentValue(remaningValue);
        }else{
            mSelectedPercentage = selectedPercent;
            mSimplePercentageBarViewBinding.setSelectedPercentValue(selectedPercent);
        }
    }

    @Override
    public void setExecutedPercent(float executedPercent) {
        mExecutedPercentage = executedPercent;
        mSimplePercentageBarViewBinding.setExecutedPercentValue(executedPercent);

        if(mExecutedPercentage == 100){
            mSimplePercentageBarViewBinding.simplePercentageBarViewExecutedLinearLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_rounded_green_strength));
        } else if (mExecutedPercentage == 0){
            mSimplePercentageBarViewBinding.simplePercentageBarViewSelectedLinearLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_rounded_percentage_bar_green_base));
        }
    }
}
