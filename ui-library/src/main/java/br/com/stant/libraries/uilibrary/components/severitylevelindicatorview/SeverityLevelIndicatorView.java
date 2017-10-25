package br.com.stant.libraries.uilibrary.components.severitylevelindicatorview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFirstBallView.setBackground(ContextCompat.getDrawable(getContext(), LIGHT_SEVERITY_SHAPE));

        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewSecondBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewThirdBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFourthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFifthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));

        onChangeSeverityLevel(SeverityLevelEnum.VERY_LIGHT);
    }

    @Override
    public void setLightSeverityLevelConfiguration(View view) {
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFirstBallView.setBackground(ContextCompat.getDrawable(getContext(), LIGHT_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewSecondBallView.setBackground(ContextCompat.getDrawable(getContext(), LIGHT_SEVERITY_SHAPE));

        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewThirdBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFourthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFifthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        onChangeSeverityLevel(SeverityLevelEnum.LIGHT);
    }

    @Override
    public void setNormalSeverityLevelConfiguration(View view) {
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFirstBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewSecondBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewThirdBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));

        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFourthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFifthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        onChangeSeverityLevel(SeverityLevelEnum.NORMAL);
    }

    @Override
    public void setSeriousSeverityLevelConfiguration(View view) {
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFirstBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewSecondBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewThirdBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFourthBallView.setBackground(ContextCompat.getDrawable(getContext(), SERIOUS_SEVERITY_SHAPE));

        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFifthBallView.setBackground(ContextCompat.getDrawable(getContext(), EMPTY_GREY_SEVERITY_SHAPE));
        onChangeSeverityLevel(SeverityLevelEnum.SERIOUS);
    }

    @Override
    public void setGraveSeverityLevelConfiguration(View view) {
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFirstBallView.setBackground(ContextCompat.getDrawable(getContext(), GRAVE_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewSecondBallView.setBackground(ContextCompat.getDrawable(getContext(), GRAVE_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewThirdBallView.setBackground(ContextCompat.getDrawable(getContext(), GRAVE_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFourthBallView.setBackground(ContextCompat.getDrawable(getContext(), GRAVE_SEVERITY_SHAPE));
        mSeverityLevelIndicatorViewBinding.severityLevelIndicatorViewFifthBallView.setBackground(ContextCompat.getDrawable(getContext(), GRAVE_SEVERITY_SHAPE));
        onChangeSeverityLevel(SeverityLevelEnum.GRAVE);
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
