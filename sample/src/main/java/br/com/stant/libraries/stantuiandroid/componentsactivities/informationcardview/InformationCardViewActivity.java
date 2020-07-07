package br.com.stant.libraries.stantuiandroid.componentsactivities.informationcardview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
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
    }

    public void setInformation(String title, String type, String actions, String createdAt,
                               String deadline, String occurrenceID, Integer severityLevel) {

        mInformationCardViewTestActBinding.informationCardView.setDarkCardStyle();
        mInformationCardViewTestActBinding.informationCardView.setTitle(title);
        mInformationCardViewTestActBinding.informationCardView.setType(type);
        mInformationCardViewTestActBinding.informationCardView.setActions(actions);
        mInformationCardViewTestActBinding.informationCardView.setCreatedAt(createdAt);
        mInformationCardViewTestActBinding.informationCardView.setDeadline(deadline);
        mInformationCardViewTestActBinding.informationCardView.setOccurrenceID(occurrenceID);
        mInformationCardViewTestActBinding.informationCardView.setSeverityLevel(severityLevel);
    }


}
