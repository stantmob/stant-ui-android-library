package br.com.stant.libraries.uilibrary.components.executedpercentbarview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.Locale;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ExecutedPercentBarViewBinding;

/**
 * Created by stant on 25/07/17.
 */

public class ExecutedPercentBarView extends CardView implements ExecutedPercentBarViewContract{

    private ExecutedPercentBarViewBinding mExecutedPercentBarViewBinding;
    private String mPercentDescriptionStringpt1;
    private String mPercentDescriptionStringpt2;
    private String mPercentValueStringpt1;
    private String mPercentValueStringpt2;
    private Integer mPercentValue;

    public ExecutedPercentBarView(Context context) {
        super(context);
        if(!isInEditMode())
            mExecutedPercentBarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                    context), R.layout.executed_percent_bar_view, this, true);
    }

    public ExecutedPercentBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context, attrs);
    }

    public ExecutedPercentBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mExecutedPercentBarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                context), R.layout.executed_percent_bar_view, this, true);

    }

    @Override
    public void setPercentValue(Integer percentValue) {
        if(percentValue == null)
            percentValue = 0;

        mPercentValue = percentValue;
        executedPercentDescriptionListener(percentValue);
        executedPercentValueListener(percentValue);
        setGreenBarWeight(percentValue);
    }

    private void setGreenBarWeight(float percentValue){
        LinearLayout.LayoutParams greenPercentBarLayoutParams = new LinearLayout.LayoutParams(0,
                LayoutParams.MATCH_PARENT, percentValue);
        mExecutedPercentBarViewBinding.executedPercentBarGreenBarPercentLinearLayout.setLayoutParams(greenPercentBarLayoutParams);
    }

    public void executedPercentDescriptionListener(float percentage){
        mPercentDescriptionStringpt1 = "";
        mPercentDescriptionStringpt2 = "";
        String percentDescriptionLabel = getResources().getString(R.string.executed_percent_bar_bar_title);
        String language = Locale.getDefault().getDisplayLanguage();

        if (percentage <= 6)
            generatePercentDescriptionStringParts(0);
        else if(percentage > 6 && percentage <= 8)
            generatePercentDescriptionStringParts(1);
        else if(percentage > 8 && percentage <= 11)
            generatePercentDescriptionStringParts(2);
        else if(percentage > 11 && percentage <= 13)
            generatePercentDescriptionStringParts(3);
        else if(percentage > 13 && percentage <= 16)
            generatePercentDescriptionStringParts(4);
        else if(percentage > 16 && percentage <= 18)
            generatePercentDescriptionStringParts(5);
        else if(percentage > 18 && percentage <= 21)
            generatePercentDescriptionStringParts(6);
        else if(percentage > 21 && percentage <= 23)
            generatePercentDescriptionStringParts(7);
        else if(percentage > 23 && percentage <= 28)
            generatePercentDescriptionStringParts(8);
        else if(percentage > 28 && percentage <= 30 && language.equals("português"))
            generatePercentDescriptionStringParts(9);
        else
            generatePercentDescriptionStringParts(percentDescriptionLabel.length());

        mExecutedPercentBarViewBinding.setPercentDescriptionPt1(mPercentDescriptionStringpt1);
        mExecutedPercentBarViewBinding.setPercentDescriptionPt2(mPercentDescriptionStringpt2);
    }

    public void executedPercentValueListener(float percentage){
        mPercentValueStringpt1 = "";
        mPercentValueStringpt2 = "";

        if (percentage <= 46)
            generatePercentValueStringParts(percentage,0);
        else if(percentage > 46 && percentage <= 49)
            generatePercentValueStringParts(percentage,1);
        else if(percentage > 49 && percentage <= 53)
            generatePercentValueStringParts(percentage,2);
        else if(percentage == 100)
            generatePercentValueStringParts(percentage,4);
        else
            generatePercentValueStringParts(percentage,3);

        mExecutedPercentBarViewBinding.setPercentValuePt1(mPercentValueStringpt1);
        mExecutedPercentBarViewBinding.setPercentValuePt2(mPercentValueStringpt2);
    }

    public void generatePercentValueStringParts(float percentage, Integer limit){
        int intPercentage = (int) percentage;
        String percentValueLabel = intPercentage+"%";

        mPercentValueStringpt1 = percentValueLabel.substring(0, limit);
        mPercentValueStringpt2 = percentValueLabel.substring(limit);
    }

    public void generatePercentDescriptionStringParts(Integer limit){
        String percentDescriptionLabel = getContext().getResources().getString(R.string.executed_percent_bar_bar_title);
        mPercentDescriptionStringpt1 = percentDescriptionLabel.substring(0, limit);
        mPercentDescriptionStringpt2 = percentDescriptionLabel.substring(limit);
    }

}
