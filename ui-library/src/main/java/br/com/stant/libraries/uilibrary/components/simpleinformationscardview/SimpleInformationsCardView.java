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

    public SimpleInformationsCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSimpleInformationsCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.simple_informations_card_view, this, true);

        getAttributesFromView(attrs);
        setAttributesIntoView();
    }

    @Override
    public void getAttributesFromView(AttributeSet attrs){
        mFirstTitle = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_firstTitle);
        mFirstValue = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_firstValue);
        mSecondTitle = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_secondTitle);
        mSecondValue = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_secondValue);
        mInformationsColor = ViewUtils.getColorFromTypedArray(getContext(), R.styleable.SimpleInformationsCardView,
                attrs, R.styleable.SimpleInformationsCardView_informationsColor);
    }

    @Override
    public void setAttributesIntoView() {
        mSimpleInformationsCardViewBinding.setHandler(this);
        mSimpleInformationsCardViewBinding.setInformationsColor(mInformationsColor);
        mSimpleInformationsCardViewBinding.setFirstTitle(mFirstTitle);
        mSimpleInformationsCardViewBinding.setFirstValue(mFirstValue);
        if(mSecondTitle != null && mSecondValue != null){
            mSimpleInformationsCardViewBinding.setSecondTitle(mSecondTitle);
            mSimpleInformationsCardViewBinding.setSecondValue(mSecondValue);
        }else{
            mSimpleInformationsCardViewBinding.simpleInformationsCardViewSecondInfoContainerLinearLayout.setVisibility(GONE);
        }
    }

}
