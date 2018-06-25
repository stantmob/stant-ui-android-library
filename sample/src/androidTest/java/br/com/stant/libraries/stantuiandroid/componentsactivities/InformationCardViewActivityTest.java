package br.com.stant.libraries.stantuiandroid.componentsactivities;

/**
 * Created by stant02 on 25/06/18.
 */

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentactivities.informationcardview.InformationCardViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static org.hamcrest.Matchers.allOf;

/**
 * Ui tests for the implementation of {@link InformationCardViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class InformationCardViewActivityTest {
    public abstract static class Describe_Information_Card_View_Activity_content extends TestBase {


        @Rule
        public ActivityTestRule<InformationCardViewActivity> mActivity = new ActivityTestRule<>(InformationCardViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(InformationCardViewActivity.class);
            mActivity.launchActivity(intent);

        }

    }

    public static class Context_when_check_information_card_view_content extends Describe_Information_Card_View_Activity_content {

        @Before
        public void setCardInformations() {
            mActivity.getActivity().setInformation();
        }

        @Test
        public void It_should_show_severity_level() {
//            onView(allOf(withId(R.id.button_component_textview),
//                    isDescendantOfA(withId(R.id.button_component_view))))
//                    .check(matches(withText(TEXT)));
        }

        @Test
        public void It_should_show_title_text_correctly() {

        }

        @Test
        public void It_should_show_deadline_text_correctly() {

        }

        @Test
        public void It_should_show_actions_text_correctly() {

        }

        @Test
        public void It_should_show_creator_name_correctly() {

        }

        @Test
        public void It_should_show_percentage_correctly() {

        }

    }

}
