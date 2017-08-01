package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ActionButtonViewBinding;
import br.com.stant.libraries.uilibrary.utils.ViewUtils;

/**
 * Created by denisvieira on 26/07/17.
 */

public class ActionButtonView extends CardView implements ActionButtonViewContract{

    private ActionButtonViewBinding mActionButtonViewBinding;
    private ActionButtonViewContract.OnClickActionButtonListener mOnClickActionButtonListener;
    private String mActionText;
    private Drawable mActionIcon;
    private int mCardStyle;


    public ActionButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mActionButtonViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.action_button_view, this, true);

        setBackground(getResources().getDrawable(R.drawable.shape_white_with_green_border));
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        getAttributesFromView(attrs);
        setAttributesIntoView();

    }

    @Override
    public void getAttributesFromView(AttributeSet attrs){
        mActionText = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.ActionButtonView,
                attrs, R.styleable.ActionButtonView_actionText);
        mActionIcon = ViewUtils.getDrawableFromTypedArray(getContext(), R.styleable.ActionButtonView,
                attrs, R.styleable.ActionButtonView_actionIcon);
        mCardStyle = ViewUtils.getIntegerFromTypedArray(getContext(), R.styleable.ActionButtonView,
                attrs, R.styleable.ActionButtonView_cardStyle);
    }

    @Override
    public void setAttributesIntoView() {
        mActionButtonViewBinding.setHandler(this);
        mActionButtonViewBinding.setActionText(mActionText);
        mActionButtonViewBinding.setActionIcon(mActionIcon);
        setCardStyle(mCardStyle);
    }

    @Override
    public void setCardStyle(int cardStyleReference) {
        if(cardStyleReference == ActionButtonCardStyleEnum.VERTICAL.getValue())
            setVerticalViewStyleCard();
        else if (cardStyleReference == ActionButtonCardStyleEnum.HORIZONTAL.getValue())
            setHorizontalViewStyleCard();
    }

    @Override
    public void setOnClickActionButtonListener(OnClickActionButtonListener onClickActionButtonListener) {
        mOnClickActionButtonListener = onClickActionButtonListener;
    }

    @Override
    public void onClickActionButton(View view) {
        mOnClickActionButtonListener.onClick();
    }

    private void setVerticalViewStyleCard(){
        mActionButtonViewBinding.actionButtonViewHorizontalContainerLinearLayout.setVisibility(GONE);
        mActionButtonViewBinding.actionButtonViewVerticalContainerLinearLayout.setVisibility(VISIBLE);
    }

    private void setHorizontalViewStyleCard(){
       mActionButtonViewBinding.actionButtonViewHorizontalContainerLinearLayout.setVisibility(VISIBLE);
       mActionButtonViewBinding.actionButtonViewVerticalContainerLinearLayout.setVisibility(GONE);
    }

}
