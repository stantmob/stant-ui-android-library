package br.com.stant.libraries.uilibrary.components.infoactioncardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.InfoActionCardViewBinding;
import br.com.stant.libraries.uilibrary.utils.ViewUtils;

/**
 * Created by denisvieira on 27/07/17.
 */

public class InfoActionCardView extends CardView implements InfoActionCardViewContract {

    private InfoActionCardViewBinding mInfoActionCardViewBinding;
    private OnClickActionCardListener mOnClickActionCardListener;
    private Integer actionActiveTextColor;
    private String mInfoText;
    private String mActionText;

    public InfoActionCardView(Context context) {
        super(context);
        if(!isInEditMode()) {
            mInfoActionCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                    R.layout.info_action_card_view, this, true);
        }
    }

    public InfoActionCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context,attrs);
    }

    public InfoActionCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        mInfoActionCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.info_action_card_view, this, true);
        mInfoActionCardViewBinding.setHandler(this);

        getAttributes(attrs);
        setAttributes();
    }

    public void setInfoText(String infoText) {
        this.mInfoText = infoText;
        mInfoActionCardViewBinding.setInfoText(infoText);
    }

    public void setActionText(String actionText) {
        this.mActionText = actionText;
        mInfoActionCardViewBinding.setActionText(actionText);
    }

    private void getAttributes(AttributeSet attrs){
        mInfoText = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.InfoActionCardView,
                attrs, R.styleable.InfoActionCardView_infoText);
        mActionText = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.InfoActionCardView,
                attrs, R.styleable.InfoActionCardView_actionName);
    }

    private void setAttributes() {
        setInfoText(mInfoText);
        setActionText(mActionText);
    }

    @Override
    public void setOnClickActionCardListener(OnClickActionCardListener onClickActionCardListener) {
        setActiveColorOnAction();
        mOnClickActionCardListener = onClickActionCardListener;
    }

    private void setActiveColorOnAction(){
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
