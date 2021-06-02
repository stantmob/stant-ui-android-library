package br.com.stant.libraries.uilibrary.components.basictoolbarview;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.BasicToolbarViewBinding;

/**
 * Created by denisvieira on 25/07/17.
 */

public class BasicToolbarView extends LinearLayout implements BasicToolbarViewContract {


    private BasicToolbarViewBinding mBasicToolbarViewBinding;

    public BasicToolbarView(Context context) {
        super(context);
        init(context);
    }

    public BasicToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BasicToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mBasicToolbarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.basic_toolbar_view, this, true);
    }

    @Override
    public void setTitle(String title) {
        mBasicToolbarViewBinding.setTitle(title);
    }

    @Override
    public void setSubtitle(String subtitle) {
        mBasicToolbarViewBinding.setSubtitle(subtitle);
    }
}
