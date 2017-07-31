package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ActionButtonViewContract {

    void setIcon(int iconResourceId);
    void setOnClickActionButtonListener(OnClickActionButtonListener onClickActionButtonListener);
    void onClickActionButton(View view);
    void withVerticalConfiguration();
    void withHorizontalConfiguration();

    interface OnClickActionButtonListener {
        void onClick();
    }
}
