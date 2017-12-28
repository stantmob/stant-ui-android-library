package br.com.stant.libraries.uilibrary.components.buttoncomponent;

import android.graphics.drawable.Drawable;
import android.view.View;

import br.com.stant.libraries.uilibrary.BaseView;
import br.com.stant.libraries.uilibrary.components.actionbuttonview.ActionButtonViewContract;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ButtonComponentViewContract extends BaseView {

    void setButtonText(String buttonText);
    void setButtonShape(Drawable buttonShape);
    void setButtonShadowShape(Drawable buttonShadowShape);

}
