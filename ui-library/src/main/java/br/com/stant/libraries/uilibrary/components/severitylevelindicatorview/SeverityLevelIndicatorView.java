package br.com.stant.libraries.uilibrary.components.severitylevelindicatorview;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SeverityLevelIndicatorViewBinding;

/**
 * Created by denisvieira on 24/10/17.
 */

public class SeverityLevelIndicatorView extends LinearLayout implements SeverityLevelIndicatorViewContract{

    SeverityLevelIndicatorViewBinding mSeverityLevelIndicatorViewBinding;
    Integer LIGHT_SEVERITY_SHAPE = R.drawable.shape_round_yellow_little_balls;
    Integer SERIOUS_SEVERITY_SHAPE = R.drawable.shape_round_orange_little_balls;
    Integer GRAVE_SEVERITY_SHAPE = R.drawable.shape_round_red_little_balls;
    Integer EMPTY_GREY_SEVERITY_SHAPE = R.drawable.shape_round_gray_little_balls;
    private Integer mSeverityLevelValue;
    private OnChangeSeverityLevel mOnChangeSeverityLevel;


    public SeverityLevelIndicatorView(Context context) {
        super(context);
        if(!isInEditMode())
            mSeverityLevelIndicatorViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                    context), R.layout.severity_level_indicator_view, this, true);
    }

    public SeverityLevelIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mSeverityLevelIndicatorViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.severity_level_indicator_view, this, true);
        mSeverityLevelIndicatorViewBinding.setHandler(this);
    }

    @Override
    public void setSeverityLevel(SeverityLevelEnum severityLevelEnum) {
        if(severityLevelEnum == null)
            severityLevelEnum = SeverityLevelEnum.VERY_LIGHT;

        showCorrectSeverityLevelBallsConfiguration(severityLevelEnum);
    }

    private void showCorrectSeverityLevelBallsConfiguration(SeverityLevelEnum severityLevelEnum) {
        switch (severityLevelEnum){
            case VERY_LIGHT:
                setVeryLightSeverityLevelConfiguration(this);
                break;
            case LIGHT:
                setLightSeverityLevelConfiguration(this);
                break;
            case NORMAL:
                setNormalSeverityLevelConfiguration(this);
                break;
            case SERIOUS:
                setSeriousSeverityLevelConfiguration(this);
                break;
            case GRAVE:
                setGraveSeverityLevelConfiguration(this);
                break;
            default:
                setVeryLightSeverityLevelConfiguration(this);
        }
    }

    @Override
    public void setVeryLightSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(LIGHT_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE,
                EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.VERY_LIGHT);
    }

    @Override
    public void setLightSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(LIGHT_SEVERITY_SHAPE, LIGHT_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE,
                EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.LIGHT);
    }

    @Override
    public void setNormalSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE,
                EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.NORMAL);
    }

    @Override
    public void setSeriousSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE,
                SERIOUS_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.SERIOUS);
    }

    @Override
    public void setGraveSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE,
                GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.GRAVE);
    }

    private void setSeverityLevelConfiguration(Integer firstBallLevel, Integer secondBallLevel, Integer thirdBallLevel,
                                               Integer fourthBallLevel, Integer fifthBallLevel) {
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFirstBallView.setBackground(ContextCompat.getDrawable(getContext(), firstBallLevel));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewSecondBallView.setBackground(ContextCompat.getDrawable(getContext(), secondBallLevel));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewThirdBallView.setBackground(ContextCompat.getDrawable(getContext(), thirdBallLevel));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFourthBallView.setBackground(ContextCompat.getDrawable(getContext(), fourthBallLevel));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFifthBallView.setBackground(ContextCompat.getDrawable(getContext(), fifthBallLevel));
    }
    @Override
    public void onChangeSeverityLevel(SeverityLevelEnum severityLevelEnum) {
        if(mOnChangeSeverityLevel != null)
            mOnChangeSeverityLevel.onChange(severityLevelEnum);
    }

    @Override
    public void setOnChangeSeverityLevel(OnChangeSeverityLevel onChangeSeverityLevel) {
        mOnChangeSeverityLevel = onChangeSeverityLevel;
    }

}
