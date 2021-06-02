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
import br.com.stant.libraries.stantuiandroid.componentsactivities.selecttimepickerview.SelectTimePickerViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.findAndClick;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Ui tests for the implementation of {@link SelectTimePickerViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class SelectTimePickerViewActivityTest {

    public abstract static class Describe_Select_Time_Picker_View_Activity_content extends TestBase {

        static final String TIME = "00:00";
        @Rule
        public ActivityTestRule<SelectTimePickerViewActivity> mActivity = new ActivityTestRule<>(SelectTimePickerViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SelectTimePickerViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_select_time_picker_view extends Describe_Select_Time_Picker_View_Activity_content {

        @Test
        public void It_should_show_time_text_correctly() {
            onView(allOf(
                    withId(R.id.select_time_picker_view_time_value_text_view),
                    isDescendantOfA(withId(R.id.select_time_picker))))
                    .check(matches(withText(TIME)));
        }


    }

    public abstract static class Context_when_click_on_time_text extends Describe_Select_Time_Picker_View_Activity_content {
        @Before
        public void clickOnTime() {
            onView(withId(R.id.select_time_picker_view_time_value_text_view))
                    .perform(click());

            onView(withId(R.id.select_time_picker_view_time_number_picker_dialog_rework_hours_number_picker)).
                    perform(swipeUp());
            onView(withId(R.id.select_time_picker_view_time_number_picker_dialog_rework_minutes_number_picker)).
                    perform(swipeDown());
            findAndClick(R.id.select_time_picker_view_time_number_picker_dialog_ok_button_text_view);

        }


    }


    public static class Context_when_choose_a_diferent_time extends Context_when_click_on_time_text {

        @Test
        public void It_should_change_time_text() {
            onView(allOf(
                    withId(R.id.select_time_picker_view_time_value_text_view),
                    isDescendantOfA(withId(R.id.select_time_picker))))
                    .check(matches(withText(not(TIME))));
        }
    }

}
