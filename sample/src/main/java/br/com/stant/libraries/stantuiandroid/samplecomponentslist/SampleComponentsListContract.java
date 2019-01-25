package br.com.stant.libraries.stantuiandroid.samplecomponentslist;

import br.com.stant.libraries.stantuiandroid.entities.UiComponent;

/**
 * Created by denisvieira on 29/10/17.
 */

public interface SampleComponentsListContract {

    interface View {
        void showComponents();

        void goToComponentDetail(UiComponent component);

        void goToWorkspaceScreen();
    }


}
