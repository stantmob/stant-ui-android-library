package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Date;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.selectdatepickerview.SelectDatePickerViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.selecttimepickerview.SelectTimePickerViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.utils.DateUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
