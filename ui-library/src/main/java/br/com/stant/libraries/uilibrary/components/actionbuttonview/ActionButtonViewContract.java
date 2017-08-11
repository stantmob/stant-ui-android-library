package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.graphics.drawable.Drawable;
import android.view.View;

import br.com.stant.libraries.uilibrary.BaseView;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ActionButtonViewContract extends BaseView {

    void setCardStyle(int cardStyleReference);
    void setOnClickActionButtonListener(final OnClickActionButtonListener onClickActionButtonListener);
    void onClickActionButton(View view);

    interface OnClickActionButtonListener {
        void onClick();
    }
}
