package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ActionButtonViewBinding;

/**
 * Created by denisvieira on 26/07/17.
 */

public class ActionButtonView extends LinearLayout implements ActionButtonViewContract{

    private ActionButtonViewContract.OnClickActionButtonListener mOnClickActionButtonListener;

    private ActionButtonViewBinding mActionButtonViewBinding;

    public ActionButtonView(Context context) {
        super(context);
        init(context);
    }

    public ActionButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ActionButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mActionButtonViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.action_button_view, this, true);
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
