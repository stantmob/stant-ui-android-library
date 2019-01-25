package br.com.stant.libraries.uilibrary.components.increasedecreasebuttonsview;

import android.view.View;

/**
 * Created by denisvieira on 24/10/17.
 */

public interface IncreaseDecreaseButtonsViewContract {
    void setOnPressIncreaseButton(View.OnClickListener onClickListener);
    void setOnPressDecreaseButton(View.OnClickListener onClickListener);
    void onPressIncreaseButton(View view);
    void onPressDecreaseButton(View view);
    void setIncreaseDecreaseTextSize(Integer size);
}
