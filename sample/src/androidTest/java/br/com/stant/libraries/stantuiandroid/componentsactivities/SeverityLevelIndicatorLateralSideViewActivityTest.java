package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.severitylevelindicatorlateralsideview.SeverityLevelndicatorLateralSideViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview.SeverityLevelEnum;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static br.com.stant.libraries.stantuiandroid.testutils.CustomMatchers.withDrawable;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link SeverityLevelndicatorLateralSideViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class SeverityLevelIndicatorLateralSideViewActivityTest {

    public abstract static class Describe_Severity_Level_Indicator_Lateral_Side_View_Activity_content extends TestBase {
        static final SeverityLevelEnum SEVERITY_LEVEL_ENUM = SeverityLevelEnum.LIGHT;

        @Rule
        public ActivityTestRule<SeverityLevelndicatorLateralSideViewActivity> mActivity = new ActivityTestRule<>(SeverityLevelndicatorLateralSideViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SeverityLevelndicatorLateralSideViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_severity_balls extends Describe_Severity_Level_Indicator_Lateral_Side_View_Activity_content {
        @Before
        public void setSeverityLevel() {
            mActivity.getActivity().setSeverityLevel(SEVERITY_LEVEL_ENUM);
        }

        //TODO: Check for asserts with drawables.
        @Ignore
        @Test
        public void It_should_show_two_severity_ball_colored() {
            onView(allOf(
                    withId(R.id.severity_level_indicator_lateral_side_view_first_bar_view),
                    isDescendantOfA(withId(R.id.severity_level_indicator_lateral_side_view))))
                    .check(matches(withDrawable(R.drawable.shape_round_yellow_little_balls)));
        }

    }


}
