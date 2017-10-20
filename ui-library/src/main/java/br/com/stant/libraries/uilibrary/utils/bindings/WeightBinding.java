package br.com.stant.libraries.uilibrary.utils.bindings;

import android.databinding.BindingAdapter;
import android.widget.LinearLayout;

/**
 * Created by denisvieira on 18/10/17.
 */

public class WeightBinding {

    @BindingAdapter("android:layout_weight")
    public static void setWeight(LinearLayout view, float value) {
        view.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, value));
    }
}
