package br.com.stant.libraries.uilibrary.components.expandabletoolbarview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ExpandableToolbarViewBinding;

/**
 * Created by denisvieira on 25/07/17.
 */

public class ExpandableToolbarView extends ViewGroup implements ExpandableToolbarViewContract {

    private FrameLayout containerLayout;

    public ExpandableToolbarView(Context context) {
        super(context);
        init(context);
    }

    private ExpandableToolbarViewBinding mExpandableToolbarViewBinding;

    public ExpandableToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ExpandableToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mExpandableToolbarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.expandable_toolbar_view, this, true);
//        addView();
    }

    @Override
    public void setTitle(String title) {
        mExpandableToolbarViewBinding.setTitle(title);
    }

    @Override
    public void setSubtitle(String subtitle) {
        mExpandableToolbarViewBinding.setSubtitle(subtitle);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

//    @Override
//    public void addView(View child, int index, LayoutParams params) {
//        super.addView(child, index, params);
//        switch (child.getId()) {
//            case R.id.favourite_iv:
//                spinner = (ProgressBar) child;
//                break;
//            case R.id.favorite_spinner:
//                star = (ImageView) child;
//                break;
//        }
//    }
}
