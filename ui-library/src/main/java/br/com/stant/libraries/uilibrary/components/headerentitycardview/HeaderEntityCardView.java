package br.com.stant.libraries.uilibrary.components.headerentitycardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.HeaderEntityCardViewBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class HeaderEntityCardView extends CardView implements HeaderEntityCardViewContract {

    private HeaderEntityCardViewBinding mHeaderEntityCardViewBinding;

    public HeaderEntityCardView(Context context) {
        super(context);
        init(context);
    }

    public HeaderEntityCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeaderEntityCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mHeaderEntityCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.header_entity_card_view, this, true);
        mHeaderEntityCardViewBinding.setHandler(this);
        mHeaderEntityCardViewBinding.setCriticalIconVisibility(GONE);
    }

    @Override
    public void setTitle(String title) {
        mHeaderEntityCardViewBinding.setTitle(title);
    }

    @Override
    public void setEndAt(String endAt) {
        mHeaderEntityCardViewBinding.setEndAt(endAt);
    }

    @Override
    public void setStartAt(String startAt) {
        mHeaderEntityCardViewBinding.setStartAt(startAt);
    }

    @Override
    public void setFirstQuantity(String firstQuantity) {
        mHeaderEntityCardViewBinding.setQuantity1(firstQuantity);
    }

    @Override
    public void setSecondQuantity(String secondQuantity) {
        mHeaderEntityCardViewBinding.setQuantity2(secondQuantity);
    }

    @Override
    public void setCardCritical() {
        mHeaderEntityCardViewBinding.setCriticalIconVisibility(VISIBLE);
    }

    @Override
    public void setEndAtVisibility(Integer visibility) {
        mHeaderEntityCardViewBinding.headerEntityCardSecondDateFrameLayout.setVisibility(visibility);
    }

    @Override
    public void setArrowVisibility(Integer visibility) {
        mHeaderEntityCardViewBinding.headerEntityCardArrowImageView.setVisibility(visibility);
    }


}

