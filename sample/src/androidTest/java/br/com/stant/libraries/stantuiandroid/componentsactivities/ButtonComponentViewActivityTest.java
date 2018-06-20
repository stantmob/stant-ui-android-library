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
import br.com.stant.libraries.stantuiandroid.componentsactivities.buttoncomponentview.ButtonComponentViewActivity;
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
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Ui tests for the implementation of {@link ButtonComponentViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class ButtonComponentViewActivityTest {

    public abstract static class Describe_Button_Component_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<ButtonComponentViewActivity> mActivity = new ActivityTestRule<>(ButtonComponentViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(ButtonComponentViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_button_component_view extends Describe_Button_Component_View_Activity_content {

        @Test
        public void It_should_show_text_correctly() {
            String buttonText = InstrumentationRegistry.getTargetContext().getString(R.string.button_component_text);

            onView(allOf(
                    withId(R.id.button_component_textview),
                    isDescendantOfA(withId(R.id.button_component))))
                    .check(matches(withText(buttonText)));
        }

//        @Test
//        public void It_should_show_has_correct_shape() {
//
//        }
//
//        @Test
//        public void It_should_show_has_correct_shadow() {
//
//        }


    }

//    public static class Context_when_click_on_button_component_view extends Describe_Button_Component_View_Activity_content {
//        @Before
//        public void clickOnButton() {
////            onView(withId(R.id.action_button_view_horizontal_component))
////                    .perform(click());
//        }
//
//        @Test
//        public void It_should_show_toast_when_click() {
////            String horizontalToastText = "Horizontal Component";
////            onView(withText(horizontalToastText)).
////                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
////                            getDecorView())))).check(matches(isDisplayed()));
//        }
//    }
//
//    public static class Context_when_set_inactive_status_button_component_view extends Describe_Button_Component_View_Activity_content {
//        @Before
//        public void setInactive() {
//
//        }
//
//        @Test
//        public void It_should_not_be_able_to_click() {
//
//        }
//    }


}
