package br.com.stant.libraries.stantuiandroid.componentsactivities.headerentitycardview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.HeaderEntityCardViewTestActBinding;
import br.com.stant.libraries.uilibrary.databinding.HeaderEntityCardViewBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class HeaderEntityCardViewActivity extends AppCompatActivity {

    private HeaderEntityCardViewTestActBinding mHeaderEntityCardViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHeaderEntityCardViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.header_entity_card_view_test_act);

    }

    public void setInformation(String title, String endAt, String startAt, String firstQuantity, String secondQuantity) {
        mHeaderEntityCardViewTestActBinding.headerEntityCardView.setTitle(title);
        mHeaderEntityCardViewTestActBinding.headerEntityCardView.setEndAt(endAt);
        mHeaderEntityCardViewTestActBinding.headerEntityCardView.setStartAt(startAt);
        mHeaderEntityCardViewTestActBinding.headerEntityCardView.setFirstQuantity(firstQuantity);
        mHeaderEntityCardViewTestActBinding.headerEntityCardView.setSecondQuantity(secondQuantity);

    }
}
