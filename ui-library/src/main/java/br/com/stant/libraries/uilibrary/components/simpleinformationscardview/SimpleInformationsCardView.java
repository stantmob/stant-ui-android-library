package br.com.stant.libraries.uilibrary.components.simpleinformationscardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.SimpleInformationsCardViewBinding;
import br.com.stant.libraries.uilibrary.utils.ViewUtils;

/**
 * Created by denisvieira on 27/07/17.
 */

public class SimpleInformationsCardView extends CardView implements SimpleInformationsCardViewContract {

    private SimpleInformationsCardViewBinding mSimpleInformationsCardViewBinding;
    private String mFirstTitle;
    private String mFirstValue;
    private String mSecondTitle;
    private String mSecondValue;
    private Integer mInformationsColor;

    public SimpleInformationsCardView(Context context) {
        super(context);

        if(!isInEditMode()) {
            mSimpleInformationsCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                    R.layout.simple_informations_card_view, this, true);
        }
    }

    public SimpleInformationsCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context,attrs);
    }

    public SimpleInformationsCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        mSimpleInformationsCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.simple_informations_card_view, this, true);

        mSimpleInformationsCardViewBinding.setHandler(this);
        getAttributesFromView(attrs);
        setAttributesIntoView();
    }

    @Override
    public void getAttributesFromView(AttributeSet attrs){
        mFirstTitle = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_firstTitle);
        mSecondTitle = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_secondTitle);
        mInformationsColor = ViewUtils.getColorFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_informationsColor);
    }

    @Override
    public void setAttributesIntoView() {
        mSimpleInformationsCardViewBinding.setHandler(this);
        mSimpleInformationsCardViewBinding.setInformationsColor(mInformationsColor);
        mSimpleInformationsCardViewBinding.setFirstTitle(mFirstTitle);
        mSimpleInformationsCardViewBinding.setSecondTitle(mSecondTitle);
    }

    @Override
    public void setFirstValue(String firstValue) {
        mFirstValue = firstValue;
        mSimpleInformationsCardViewBinding.setFirstValue(firstValue);
    }

    @Override
    public void setSecondValue(String secondValue) {
        mSecondValue = secondValue;
        mSimpleInformationsCardViewBinding.setSecondValue(secondValue);
        mSimpleInformationsCardViewBinding.simpleInformationsCardViewSecondInfoContainerLinearLayout.setVisibility(VISIBLE);
    }

}
