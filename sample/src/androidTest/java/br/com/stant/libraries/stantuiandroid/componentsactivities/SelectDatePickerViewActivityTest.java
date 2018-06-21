package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.PickerActions;
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
import br.com.stant.libraries.stantuiandroid.componentsactivities.infoactioncardview.InfoActionCardViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.selectdatepickerview.SelectDatePickerViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.utils.DateUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Ui tests for the implementation of {@link SelectDatePickerViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class SelectDatePickerViewActivityTest {

    public abstract static class Describe_Select_Date_Picker_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<SelectDatePickerViewActivity> mActivity = new ActivityTestRule<>(SelectDatePickerViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SelectDatePickerViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_select_date_picker_view extends Describe_Select_Date_Picker_View_Activity_content {

        @Test
        public void It_should_show_date_text_correctly() {
            Date date = new Date();
            String stringDate = DateUtils.formatBrDate(date);

            onView(allOf(
                    withId(R.id.select_date_picker_view_date_text_view),
                    isDescendantOfA(withId(R.id.select_date_picker))))
                    .check(matches(withText(stringDate)));
        }


    }

    public static class Context_when_click_on_calendar_icon extends Describe_Select_Date_Picker_View_Activity_content {
        int year = 2020;
        int month = 11;
        int day = 10;

        @Before
        public void clickOnCalendar() {
            onView(withId(R.id.inspection_data_card_reprove_general_add_item_inspection_reproved_deadline_calendar_image_view))
                    .perform(click());

            onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month, day));
            onView(withId(android.R.id.button1)).perform(click());
        }

        @Test
        public void It_should_change_date() {
            onView(allOf(
                    withId(R.id.select_date_picker_view_date_text_view),
                    isDescendantOfA(withId(R.id.select_date_picker))))
                    .check(matches(withText(day + "/" + month + "/" + year)));
        }
    }


}
