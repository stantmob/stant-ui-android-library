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
import br.com.stant.libraries.stantuiandroid.componentsactivities.basictoolbarview.BasicToolbarViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link BasicToolbarViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class BasicToolbarViewActivityTest {

    public abstract static class Describe_Basic_Toolbar_View_Activity_content extends TestBase {

        static final String TITLE = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.basic_toolbar_view_text_title);
        static final String SUBTITLE = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.basic_toolbar_view_text_subtitle);

        @Rule
        public ActivityTestRule<BasicToolbarViewActivity> mActivity = new ActivityTestRule<>(BasicToolbarViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(BasicToolbarViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_basic_toolbar_view extends Describe_Basic_Toolbar_View_Activity_content {

        @Before
        public void setTitleAndSubtitle() {
            mActivity.getActivity().setTitleAndSubtittle(TITLE, SUBTITLE);
        }

        @Test
        public void It_should_show_title_text_correctly() {
            waitEspresso(500);
            onView(allOf(
                    withId(R.id.basic_toolbar_title_text_view),
                    isDescendantOfA(withId(R.id.basic_toolbar))))
                    .check(matches(withText(TITLE)));
        }

        @Test
        public void It_should_show_subtitle_text_correctly() {
            waitEspresso(500);
            onView(allOf(
                    withId(R.id.basic_toolbar_subtitle_text_view),
                    isDescendantOfA(withId(R.id.basic_toolbar))))
                    .check(matches(withText(SUBTITLE)));
        }

    }


}
