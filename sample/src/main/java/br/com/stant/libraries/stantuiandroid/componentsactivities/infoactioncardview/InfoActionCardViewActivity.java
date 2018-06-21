package br.com.stant.libraries.stantuiandroid.componentsactivities.infoactioncardview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.InfoActionCardViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.infoactioncardview.InfoActionCardViewContract;

public class InfoActionCardViewActivity extends AppCompatActivity {

    private InfoActionCardViewTestActBinding mInfoActionCardViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInfoActionCardViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.info_action_card_view_test_act);

        mInfoActionCardViewTestActBinding.infoActionCard.setInfoText(getResources().getString(R.string.info_action_card_information_text));
        mInfoActionCardViewTestActBinding.infoActionCard.setActionText(getResources().getString(R.string.info_action_card_action_text));

        mInfoActionCardViewTestActBinding.infoActionCard.setOnClickActionCardListener(new InfoActionCardViewContract.OnClickActionCardListener() {
            @Override
            public void onClick() {
                Toast.makeText(InfoActionCardViewActivity.this, "Info card action", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
