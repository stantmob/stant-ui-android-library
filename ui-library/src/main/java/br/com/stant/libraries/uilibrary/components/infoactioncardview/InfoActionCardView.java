package br.com.stant.libraries.uilibrary.components.infoactioncardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.InfoActionCardViewBinding;
import br.com.stant.libraries.uilibrary.utils.ViewUtils;

/**
 * Created by denisvieira on 27/07/17.
 */

public class InfoActionCardView extends LinearLayout implements InfoActionCardViewContract {

    private InfoActionCardViewBinding mInfoActionCardViewBinding;
    private OnClickActionCardListener mOnClickActionCardListener;
    private Integer actionActiveTextColor;
    private String mInfoText;
    private String mActionText;

    public InfoActionCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInfoActionCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.info_action_card_view, this, true);

        getAttributes(attrs);
        setAttributes();
    }

    private void getAttributes(AttributeSet attrs){
        mInfoText = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.InfoActionCardView,
                attrs, R.styleable.InfoActionCardView_infoText);
        mActionText = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.InfoActionCardView,
                attrs, R.styleable.InfoActionCardView_actionName);
    }

    private void setAttributes() {
        mInfoActionCardViewBinding.setHandler(this);
        mInfoActionCardViewBinding.setInfoText(mInfoText);
        mInfoActionCardViewBinding.setActionText(mActionText);
    }


    @Override
    public void setOnClickActionCardListener(OnClickActionCardListener onClickActionCardListener) {
        setActiveActionColor();
        mOnClickActionCardListener = onClickActionCardListener;
    }

    private void setActiveActionColor(){
        if(actionActiveTextColor != null)
            mInfoActionCardViewBinding.infoActionCardViewActionText.setTextColor(actionActiveTextColor);
        else
            mInfoActionCardViewBinding.infoActionCardViewActionText.setTextColor(getResources().getColor(R.color.green_base));
    }

    @Override
    public void onClickActionCard(View view) {
        if (mOnClickActionCardListener != null) {
            mOnClickActionCardListener.onClick();
        }
    }

    @Override
    public void setActionActiveTextColor(int color) {
        actionActiveTextColor = getResources().getColor(color);
    }
}
