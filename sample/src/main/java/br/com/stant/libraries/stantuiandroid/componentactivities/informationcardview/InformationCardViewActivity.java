package br.com.stant.libraries.stantuiandroid.componentactivities.informationcardview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.databinding.InformationCardViewTestActBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class InformationCardViewActivity extends AppCompatActivity {

    private InformationCardViewTestActBinding mInformationCardViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInformationCardViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.information_card_view_test_act);
        setInformation();

    }

    public void setInformation() {
        mInformationCardViewTestActBinding.informationCardView.setTitle("Title");
        mInformationCardViewTestActBinding.informationCardView.setType("Type");
        mInformationCardViewTestActBinding.informationCardView.setActions("4/5");
        mInformationCardViewTestActBinding.informationCardView.setCreatedAt("01/01/2018");
        mInformationCardViewTestActBinding.informationCardView.setDeadline("30/12/2018");
    }
}
