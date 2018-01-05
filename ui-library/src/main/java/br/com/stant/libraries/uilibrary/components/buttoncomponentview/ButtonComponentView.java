package br.com.stant.libraries.uilibrary.components.buttoncomponentview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ButtonComponentBinding;

/**
 * Created by liu on 26/12/17.
 */

public class ButtonComponentView extends LinearLayout implements ButtonComponentViewContract {

    private ButtonComponentBinding mButtonComponentBinding;

    public ButtonComponentView(Context context) {
        super(context);
        if(!isInEditMode())
            mButtonComponentBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                    R.layout.button_component, this, true);
    }

    public ButtonComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())
            init(context,attrs);
    }

    public ButtonComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        mButtonComponentBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.button_component, this, true);

    }

    @Override
    public void setButtonText(String buttonText) {
        mButtonComponentBinding.setButtonText(buttonText);
    }

    @Override
    public void setButtonShape(Drawable buttonShape) {
        mButtonComponentBinding.setButtonShape(buttonShape);
    }

    @Override
    public void setButtonShadowShape(Drawable buttonShadowShape) {
        mButtonComponentBinding.setButtonShadowShape(buttonShadowShape);
    }

    @Override
    public void setInactiveStatusOnButton() {
        mButtonComponentBinding.buttonShadowShape.setVisibility(View.GONE);
        setOnClickListener(v -> {});
    }

    @Override
    public void setActiveStatusOnButton(OnClickListener onClickButton) {
        setOnClickListener(onClickButton);
        mButtonComponentBinding.buttonShadowShape.setVisibility(View.VISIBLE);
    }

}
