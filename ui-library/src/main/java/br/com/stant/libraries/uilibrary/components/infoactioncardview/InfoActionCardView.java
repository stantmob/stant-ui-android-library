package br.com.stant.libraries.uilibrary.components.infoactioncardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.InfoActionCardViewBinding;

/**
 * Created by denisvieira on 27/07/17.
 */

public class InfoActionCardView extends LinearLayout implements InfoActionCardViewContract {

    private InfoActionCardViewBinding mInfoActionCardViewBinding;

    public InfoActionCardView(Context context) {
        super(context);
        init(context);
    }

    public InfoActionCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InfoActionCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mInfoActionCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.executed_percent_bar_view, this, true);

//        mInfoActionCardViewBinding.filterPositionCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            mInfoActionCardViewBinding.filterPositionValue.setEnabled(isChecked);
//            if (!isChecked) mInfoActionCardViewBinding.filterPositionValue.setText("");
//        });
    }

//
//    @BindingAdapter("info_action_card_view_info_title")
//    public static void setInfoActionCardViewInfoTitle(InfoActionCardView view, String infoTitle) {
//        Log.i("info_title",infoTitle);
//    }

}
