package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.executedpercentbarview.ExecutedPercentBarViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.increasedecreasebuttonsview.IncreaseDecreaseButtonsViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Ui tests for the implementation of {@link IncreaseDecreaseButtonsViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class IncreaseDecreaseButtonsViewActivityTest {

    public abstract static class Describe_Increase_Decrease_Buttons_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<IncreaseDecreaseButtonsViewActivity> mActivity = new ActivityTestRule<>(IncreaseDecreaseButtonsViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(IncreaseDecreaseButtonsViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_increase_decrease_buttons_view extends Describe_Increase_Decrease_Buttons_View_Activity_content {

        @Test
        public void It_should_show_increase_icon_correctly() {
            onView(allOf(
                    withId(R.id.increase_decrease_buttons_view_more_button_text_view),
                    isDescendantOfA(withId(R.id.increase_decrease_buttons))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }

        @Test
        public void It_should_show_decrease_icon_correctly() {
            onView(allOf(
                    withId(R.id.increase_decrease_buttons_view_less_button_text_view),
                    isDescendantOfA(withId(R.id.increase_decrease_buttons))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }

    }

    public static class Context_when_click_on_increase_button extends Describe_Increase_Decrease_Buttons_View_Activity_content {
        @Before
        public void clickOnIncreaseButton() {
            waitEspresso(2000);
            onView(withId(R.id.increase_decrease_buttons_view_more_button_text_view))
                    .perform(click());
        }

        @Test
        public void It_should_show_increase_toast_when_click() {
            String toastText = "Increase Button Action";

            onView(withText(toastText)).
                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
                            getDecorView())))).check(matches(isDisplayed()));
        }
    }

    public static class Context_when_click_on_decrease_button extends Describe_Increase_Decrease_Buttons_View_Activity_content {
        @Before
        public void clickOnDecreaseButton() {
            onView(withId(R.id.increase_decrease_buttons_view_less_button_text_view))
                    .perform(click());
        }

        @Test
        public void It_should_show_decrease_toast_when_click() {
            String toastText = "Decrease Button Action";

            onView(withText(toastText)).
                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
                            getDecorView())))).check(matches(isDisplayed()));
        }
    }


}
