package br.com.stant.libraries.stantuiandroid.componentsactivities.infoactioncardview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.InfoActionCardViewTestActBinding;

public class InfoActionCardViewActivity extends AppCompatActivity {

    private InfoActionCardViewTestActBinding mInfoActionCardViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInfoActionCardViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.info_action_card_view_test_act);

        mInfoActionCardViewTestActBinding.infoActionCard.setOnClickActionCardListener(
                () -> Toast.makeText(InfoActionCardViewActivity.this, "Info card action", Toast.LENGTH_SHORT).show()
        );

    }

    public void setText(String infoText, String actionText) {
        mInfoActionCardViewTestActBinding.infoActionCard.setInfoText(infoText);
        mInfoActionCardViewTestActBinding.infoActionCard.setActionText(actionText);
    }


}
