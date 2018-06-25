package br.com.stant.libraries.uilibrary.components.buttoncomponentview;

import android.graphics.drawable.Drawable;
import android.view.View;

import br.com.stant.libraries.uilibrary.BaseView;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ButtonComponentViewContract extends BaseView {

    void setButtonText(String buttonText);
    void setButtonShape(Drawable buttonShape);
    void setButtonShadowShape(Drawable buttonShadowShape);
    void setInactiveStatusOnButton();
    void setActiveStatusOnButton(View.OnClickListener onClickButton);

}
