package br.com.stant.libraries.uilibrary.components.increasedecreasebuttonsview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.IncreaseDecreaseButtonsViewBinding;

/**
 * Created by denisvieira on 24/10/17.
 */

public class IncreaseDecreaseButtonsView extends LinearLayout implements IncreaseDecreaseButtonsViewContract {

    private IncreaseDecreaseButtonsViewBinding mIncreaseDecreaseButtonsViewBinding;
    private OnClickListener onPressIncreaseButton;
    private OnClickListener onPressDecreaseButton;

    public IncreaseDecreaseButtonsView(Context context) {
        super(context);
        if(!isInEditMode())
            mIncreaseDecreaseButtonsViewBinding = DataBindingUtil.inflate(LayoutInflater.from(
                    context), R.layout.increase_decrease_buttons_view, this, true);
    }

    public IncreaseDecreaseButtonsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mIncreaseDecreaseButtonsViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.increase_decrease_buttons_view, this, true);
        mIncreaseDecreaseButtonsViewBinding.setHandler(this);
    }

    @Override
    public void setOnPressIncreaseButton(OnClickListener onClickListener) {
        onPressIncreaseButton = onClickListener;
    }

    @Override
    public void setOnPressDecreaseButton(OnClickListener onClickListener) {
        onPressDecreaseButton = onClickListener;
    }

    @Override
    public void onPressIncreaseButton(View view) {
        onPressIncreaseButton.onClick(view);
    }

    @Override
    public void onPressDecreaseButton(View view) {
        onPressDecreaseButton.onClick(view);
    }
}
