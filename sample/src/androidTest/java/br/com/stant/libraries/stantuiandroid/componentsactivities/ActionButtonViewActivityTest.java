package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
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
import br.com.stant.libraries.stantuiandroid.componentsactivities.actionbuttonview.ActionButtonViewActivity;
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
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.findAndClick;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Ui tests for the implementation of {@link ActionButtonViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class ActionButtonViewActivityTest {

    public abstract static class Describe_Action_Button_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<ActionButtonViewActivity> mActivity = new ActivityTestRule<>(ActionButtonViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(ActionButtonViewActivity.class);
            mActivity.launchActivity(intent);
            waitEspresso(300);
        }

    }

    public static class Context_when_check_horizontal_action_button_view extends Describe_Action_Button_View_Activity_content {

        @Test
        public void It_should_show_horizontal_text_correctly() {
            String horizontalText = InstrumentationRegistry.getTargetContext().getString(R.string.action_button_view_text_button_horizontal_example);

            onView(allOf(
                    withId(R.id.action_button_view_horizontal_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .check(matches(withText(horizontalText)));
        }

        @Test
        public void It_should_show_horizontal_icon_correctly() {
            onView(allOf(
                    withId(R.id.action_button_view_horizontal_icon_image_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }


    }

    public static class Context_when_click_on_horizontal_action_button_view extends Describe_Action_Button_View_Activity_content {
        @Before
        public void clickOnButton() {
            onView(withId(R.id.action_button_view_horizontal_component))
                    .perform(click());
        }

        @Test
        public void It_should_show_toast_when_click() {
            String horizontalToastText = "Horizontal Component";
            onView(withText(horizontalToastText)).
                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
                            getDecorView())))).check(matches(isDisplayed()));
        }
    }

    public static class Context_when_check_vertical_action_button_view extends Describe_Action_Button_View_Activity_content {

        @Test
        public void It_should_show_vertical_text_correctly() {
            String horizontalText = InstrumentationRegistry.getTargetContext().getString(R.string.action_button_view_text_button_vertical_example);

            onView(allOf(
                    withId(R.id.action_button_view_vertical_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_vertical_component))))
                    .check(matches(withText(horizontalText)));
        }

        @Test
        public void It_should_show_vertical_icon_correctly() {
            onView(allOf(
                    withId(R.id.action_button_view_vertical_icon_image_view),
                    isDescendantOfA(withId(R.id.action_button_view_vertical_component))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }


    }

    public static class Context_when_click_on_vertical_action_button_view extends Describe_Action_Button_View_Activity_content {
        @Before
        public void clickOnButton() {
            onView(withId(R.id.action_button_view_vertical_component))
                    .perform(click());
        }

        @Test
        public void It_should_show_toast_when_click() {
            String horizontalToastText = "Vertical Component";

            onView(withText(horizontalToastText)).
                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
                            getDecorView())))).check(matches(isDisplayed()));
        }
    }


}
