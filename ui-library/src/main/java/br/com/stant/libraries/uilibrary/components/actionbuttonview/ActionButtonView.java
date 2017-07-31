package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ActionButtonViewBinding;
import br.com.stant.libraries.uilibrary.utils.ViewUtils;

/**
 * Created by denisvieira on 26/07/17.
 */

public class ActionButtonView extends LinearLayout implements ActionButtonViewContract{

    private ActionButtonViewBinding mActionButtonViewBinding;
    private ActionButtonViewContract.OnClickActionButtonListener mOnClickActionButtonListener;
    private int mIconResource;
    private String mActionText;


    public ActionButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mActionButtonViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.action_button_view, this, true);

        getAttributes(attrs);
        setAttributes();
    }

    private void getAttributes(AttributeSet attrs){

        mActionText = ViewUtils.getStringFromTypedArray(getContext(), R.styleable.ActionButtonView,
                attrs, R.styleable.ActionButtonView_actionText);
    }

    private void setAttributes() {
        mActionButtonViewBinding.setHandler(this);
        mActionButtonViewBinding.setActionText(mActionText);
    }


    @Override
    public void setIcon(int iconResourceId) {
        mActionButtonViewBinding.actionButtonViewIcon.setImageResource(iconResourceId);
    }

    @Override
    public void setOnClickActionButtonListener(OnClickActionButtonListener onClickActionButtonListener) {
        mOnClickActionButtonListener = onClickActionButtonListener;
    }

    @Override
    public void onClickActionButton(View view) {
        mOnClickActionButtonListener.onClick();
    }

    @Override
    public void withVerticalConfiguration() {

    }

    @Override
    public void withHorizontalConfiguration() {

    }

}
