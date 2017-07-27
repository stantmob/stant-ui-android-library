package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ActionButtonBinding;

/**
 * Created by denisvieira on 26/07/17.
 */

public class ActionButton extends LinearLayout implements ActionButtonViewContract{

    private ActionButtonViewContract.OnClickActionButtonListener mOnClickActionButtonListener;

    public ActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        ActionButtonBinding mActionButtonBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.action_button, this, true);
        mActionButtonBinding.setHandler(this);
    }

    @Override
    public void setOnClickActionButtonListener(OnClickActionButtonListener onClickActionButtonListener) {
        mOnClickActionButtonListener = onClickActionButtonListener;
    }

    @Override
    public void onClickActionButton(View view) {
        mOnClickActionButtonListener.onClick();
    }
}
