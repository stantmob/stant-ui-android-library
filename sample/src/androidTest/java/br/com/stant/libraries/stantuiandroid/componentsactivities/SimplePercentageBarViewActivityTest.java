package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.simplepercentagebarview.SimplePercentageBarViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Ui tests for the implementation of {@link SimplePercentageBarViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class SimplePercentageBarViewActivityTest {

    public abstract static class Describe_Simple_Percentage_Bar_View_Activity_content extends TestBase {
        static final int EXECUTED_VALUE = 10;
        static final int SELECTED_VALUE = 30;

        @Rule
        public ActivityTestRule<SimplePercentageBarViewActivity> mActivity = new ActivityTestRule<>(SimplePercentageBarViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SimplePercentageBarViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_simple_percentage_bar_view extends Describe_Simple_Percentage_Bar_View_Activity_content {

        @Before
        public void setPercentValues () {
            mActivity.getActivity().setPercentage(EXECUTED_VALUE,SELECTED_VALUE);
        }
        //TODO: Check how to verify a layout_weight on a linear layout
        @Ignore
        @Test
        public void It_should_executed_percent_correctly() {
            onView(allOf(
                    withId(R.id.simple_percentage_bar_view_executed_linear_layout),
                    isDescendantOfA(withId(R.id.simple_percentage_bar))))
                    .check(matches(isDisplayed()));
        }

        //TODO: Check how to verify a layout_weight on a linear layout
        @Ignore
        @Test
        public void It_should_selected_percent_correctly() {
            onView(allOf(
                    withId(R.id.simple_percentage_bar_view_selected_linear_layout),
                    isDescendantOfA(withId(R.id.simple_percentage_bar))))
                    .check(matches(withText(SELECTED_VALUE)));
        }


    }


}
