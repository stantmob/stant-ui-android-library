package br.com.stant.libraries.uilibrary.components.buttoncomponent;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ButtonComponentBinding;
import br.com.stant.libraries.uilibrary.utils.ViewUtils;

/**
 * Created by liu on 26/12/17.
 */

public class ButtonComponentView extends CardView implements ButtonComponentViewContract {

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

        getAttributesFromView(attrs);
        setAttributesIntoView();
    }

    @Override
    public void getAttributesFromView(AttributeSet attrs) {
    }

    @Override
    public void setAttributesIntoView() {

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
}
