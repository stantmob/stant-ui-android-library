package br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SeverityLevelIndicatorLateralSideViewBinding;

/**
 * Created by stant02 on 25/06/18.
 */
public class SeverityLevelIndicatorLateralSideView extends LinearLayout implements SeverityLevelIndicatorLateralSideViewContract {

    SeverityLevelIndicatorLateralSideViewBinding mSeverityLevelIndicatorLateralSideViewBinding;
    Integer LIGHT_SEVERITY_SHAPE = R.drawable.shape_round_yellow_little_balls;
    Integer SERIOUS_SEVERITY_SHAPE = R.drawable.shape_round_orange_little_balls;
    Integer GRAVE_SEVERITY_SHAPE = R.drawable.shape_round_red_little_balls;
    Integer EMPTY_GREY_SEVERITY_SHAPE = R.drawable.shape_round_gray_little_balls;
    private Integer mSeverityLevelValue;
    private OnChangeSeverityLevel mOnChangeSeverityLevel;


    public SeverityLevelIndicatorLateralSideView(Context context) {
        super(context);
        if(!isInEditMode())
            mSeverityLevelIndicatorLateralSideViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                    context), R.layout.severity_level_indicator_lateral_side_view, this, true);
    }

    public SeverityLevelIndicatorLateralSideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mSeverityLevelIndicatorLateralSideViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.severity_level_indicator_lateral_side_view, this, true);
        mSeverityLevelIndicatorLateralSideViewBinding.setHandler(this);
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
        setSeverityLevelConfiguration(EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, LIGHT_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.VERY_LIGHT);
    }

    @Override
    public void setLightSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, LIGHT_SEVERITY_SHAPE, LIGHT_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.LIGHT);
    }

    @Override
    public void setNormalSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(EMPTY_GREY_SEVERITY_SHAPE, EMPTY_GREY_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.NORMAL);
    }

    @Override
    public void setSeriousSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(EMPTY_GREY_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE, SERIOUS_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.SERIOUS);
    }

    @Override
    public void setGraveSeverityLevelConfiguration(View view) {
        setSeverityLevelConfiguration(GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE, GRAVE_SEVERITY_SHAPE);

        onChangeSeverityLevel(SeverityLevelEnum.GRAVE);
    }

    private void setSeverityLevelConfiguration(Integer firstBarLevel, Integer secondBarLevel, Integer thirdBarLevel,
                                               Integer fourthBarLevel, Integer fifthBarLevel) {
        mSeverityLevelIndicatorLateralSideViewBinding.severityLevelIndicatorLateralSideViewFirstBarView.setBackground(ContextCompat.getDrawable(getContext(), firstBarLevel));
        mSeverityLevelIndicatorLateralSideViewBinding.severityLevelIndicatorLateralSideViewSecondBarView.setBackground(ContextCompat.getDrawable(getContext(), secondBarLevel));
        mSeverityLevelIndicatorLateralSideViewBinding.severityLevelIndicatorLateralSideViewThirdBarView.setBackground(ContextCompat.getDrawable(getContext(), thirdBarLevel));
        mSeverityLevelIndicatorLateralSideViewBinding.severityLevelIndicatorLateralSideViewFourthBarView.setBackground(ContextCompat.getDrawable(getContext(), fourthBarLevel));
        mSeverityLevelIndicatorLateralSideViewBinding.severityLevelIndicatorLateralSideViewFifthBarView.setBackground(ContextCompat.getDrawable(getContext(), fifthBarLevel));

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