package br.com.stant.libraries.uilibrary.components.executedpercentbarview;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ExecutedPercentBarViewBinding;

/**
 * Created by stant on 25/07/17.
 */

public class ExecutedPercentBarView extends CardView implements ExecutedPercentBarViewContract{

    private ExecutedPercentBarViewBinding mExecutedPercentBarViewBinding;

    public ExecutedPercentBarView(Context context) {
        super(context);
        isInEditMode();
            init(context);
    }

    public ExecutedPercentBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        isInEditMode();
        init(context);
    }

    public ExecutedPercentBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        isInEditMode();
        init(context);
    }

    @Override
    protected void onLayout(boolean changed,
                            int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    private void init(Context context) {
        mExecutedPercentBarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.executed_percent_bar_view, this, true);
//        setBackgroundColor(getResources().getColor(R.color.bg_gray));
//        mExecutedPercentBarViewBinding.filterPositionCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            mExecutedPercentBarViewBinding.filterPositionValue.setEnabled(isChecked);
//            if (!isChecked) mExecutedPercentBarViewBinding.filterPositionValue.setText("");
//        });
    }

    @BindingAdapter("executed_percent_bar_view_percent_value")
    public static void setInfoActionCardViewInfoTitle(ExecutedPercentBarView view, int percentValue) {
        Log.i("percentValue", String.valueOf(percentValue));
    }

}
