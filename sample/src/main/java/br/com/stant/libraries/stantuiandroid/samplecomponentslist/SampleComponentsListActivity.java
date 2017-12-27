package br.com.stant.libraries.stantuiandroid.samplecomponentslist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SampleComponentsListActBinding;
import br.com.stant.libraries.stantuiandroid.entities.UiComponent;
import br.com.stant.libraries.stantuiandroid.samplecomponentdetail.SampleComponentDetailActivity;
import br.com.stant.libraries.stantuiandroid.workspace.WorkspaceActivity;

public class SampleComponentsListActivity extends AppCompatActivity implements SampleComponentsListContract.View {

    private SampleComponentsListActBinding mSampleComponentsListActBinding;
    private SampleComponentsListAdapter mSampleComponentsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSampleComponentsListActBinding = DataBindingUtil.setContentView(this, R.layout.sample_components_list_act);
        configureComponentsListRecycle();
        showComponents();
        mSampleComponentsListActBinding.sampleComponentListMainToolbar.inflateMenu(R.menu.workspace_menu);
        mSampleComponentsListActBinding.sampleComponentListMainToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_go_to_workspace:
                        goToWorkspaceScreen();
                        return true;
                }
                return true;
            }
        });
    }

    private void configureComponentsListRecycle(){
        mSampleComponentsListAdapter = new SampleComponentsListAdapter(getApplicationContext(), new ArrayList<UiComponent>(), this);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mSampleComponentsListActBinding.sampleComponentsListMainRecyclerView.setLayoutManager(layout);
        mSampleComponentsListActBinding.sampleComponentsListMainRecyclerView.setAdapter(mSampleComponentsListAdapter);
    }

    private List<UiComponent> buildComponentsList() {
        return new ArrayList<UiComponent>() {{
            add(new UiComponent("Action Button View", "https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/actionbuttonview/doc/buttoncomponentview.md"));
            add(new UiComponent("Expandable Text View", "https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/expandabletextview/doc/expandabletextview.md"));
        }};
    }

    @Override
    public void showComponents() {
        mSampleComponentsListAdapter.replaceData(buildComponentsList());
    }

    @Override
    public void goToComponentDetail(UiComponent component) {
        Intent intent = new Intent(getApplicationContext(), SampleComponentDetailActivity.class);
        intent.putExtra(SampleComponentDetailActivity.KEY_COMPONENT_OBJECT, component);
        startActivity(intent);
    }

    @Override
    public void goToWorkspaceScreen() {
        Intent intent = new Intent(getApplicationContext(), WorkspaceActivity.class);
        startActivity(intent);
    }
}
