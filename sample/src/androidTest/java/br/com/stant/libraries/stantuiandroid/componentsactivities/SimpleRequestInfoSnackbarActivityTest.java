package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.simplerequestinfosnackbar.SimpleRequestInfoSnackbarActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Ui tests for the implementation of {@link SimpleRequestInfoSnackbarActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class SimpleRequestInfoSnackbarActivityTest {

    public abstract static class Describe_Simple_Request_Info_Snackbar_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<SimpleRequestInfoSnackbarActivity> mActivity = new ActivityTestRule<>(SimpleRequestInfoSnackbarActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SimpleRequestInfoSnackbarActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_click_on_horizontal_action_button_view extends Describe_Simple_Request_Info_Snackbar_Activity_content {
        @Before
        public void clickOnButton() {
            waitEspresso(500);
            onView(allOf(
                    withId(R.id.action_button_view_horizontal_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .perform(click());
        }

        @Test
        public void It_should_show_success_snackbar_when_click() {
            String successText = "Success message";

            onView(withText(successText))
                    .check(matches(isDisplayed()));

        }
    }

    public static class Context_when_click_on_vertical_action_button_view extends Describe_Simple_Request_Info_Snackbar_Activity_content {
        @Before
        public void clickOnButton() {
            onView(allOf(
                    withId(R.id.action_button_view_vertical_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_vertical_component))))
                    .perform(click());

        }

        @Test
        public void It_should_show_toast_when_click() {
            String failText = "Fail message";

            onView(withText(failText))
                    .check(matches(isDisplayed()));
        }
    }


}
