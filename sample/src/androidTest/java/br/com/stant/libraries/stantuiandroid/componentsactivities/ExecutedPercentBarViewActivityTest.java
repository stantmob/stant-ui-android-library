package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.buttoncomponentview.ButtonComponentViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.executedpercentbarview.ExecutedPercentBarViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link ExecutedPercentBarViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class ExecutedPercentBarViewActivityTest {

    public abstract static class Describe_Executed_Percent_Bar_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<ExecutedPercentBarViewActivity> mActivity = new ActivityTestRule<>(ExecutedPercentBarViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(ExecutedPercentBarViewActivity.class);
            mActivity.launchActivity(intent);
            waitEspresso(500);
        }

    }

    public static class Context_when_check_executed_percent_bar_view extends Describe_Executed_Percent_Bar_View_Activity_content {

        @Test
        public void It_should_show_percentage_correctly() {
            String percentage = "60%";
            onView(allOf(
                    withId(R.id.executed_percent_bar_percent_number_value_pt1_text_view),
                    isDescendantOfA(withId(R.id.executed_percent_bar))))
                    .check(matches(withText(percentage)));
        }


    }


}
