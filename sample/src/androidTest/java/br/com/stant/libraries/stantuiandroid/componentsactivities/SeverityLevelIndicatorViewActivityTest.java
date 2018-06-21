package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
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
import br.com.stant.libraries.stantuiandroid.componentsactivities.selecttimepickerview.SelectTimePickerViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.severitylevelindicatorview.SeverityLevelndicatorViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorview.SeverityLevelEnum;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorview.SeverityLevelIndicatorView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link SeverityLevelndicatorViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class SeverityLevelIndicatorViewActivityTest {

    public abstract static class Describe_Severity_Level_Indicator_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<SeverityLevelndicatorViewActivity> mActivity = new ActivityTestRule<>(SeverityLevelndicatorViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SeverityLevelndicatorViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_severity_balls extends Describe_Severity_Level_Indicator_View_Activity_content {
        //TODO: change test for check drawable LIGHT_SEVERITY_SHAPE
        @Ignore
        @Test
        public void It_should_show_two_severity_ball_colored() {
            onView(allOf(
                    withId(R.id.severity_level_indicator_view_first_ball_view),
                    isDescendantOfA(withId(R.id.severity_level_indicator_view))))
                    .check(matches(withText("drawable")));
        }

    }


}
