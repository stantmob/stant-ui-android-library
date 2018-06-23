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
import br.com.stant.libraries.stantuiandroid.componentsactivities.executedpercentbarview.ExecutedPercentBarViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.expandabletextview.ExpandableTextViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link ExpandableTextViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class ExpandableTextViewActivityTest {

    public abstract static class Describe_Expandable_Text_View_Activity_content extends TestBase {
        static final String EXPANDABLE_TEXT = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.expandable_text);

        @Rule
        public ActivityTestRule<ExpandableTextViewActivity> mActivity = new ActivityTestRule<>(ExpandableTextViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(ExpandableTextViewActivity.class);
            setText();
            mActivity.launchActivity(intent);
        }

        public void setText() {
            mActivity.getActivity().setExpandableText(EXPANDABLE_TEXT);
            waitEspresso(500);
        }

    }

    public static class Context_when_check_expandable_text_view extends Describe_Expandable_Text_View_Activity_content {
        @Test
        public void It_should_show_hidden_text_correctly() {
            String buttonText = "In lobortis";

            onView(allOf(
                    withId(R.id.expandable_text_view_hidden_text_view),
                    isDescendantOfA(withId(R.id.expandable_text_view))))
                    .check(matches(withText(containsString(buttonText))));
        }

    }

    public static class Context_when_click_and_text_expands extends Describe_Expandable_Text_View_Activity_content {
        @Before
        public void clickOnTextView() {
            onView(withId(R.id.expandable_text_view_down_arrow_image_view))
                    .perform(click());
            waitEspresso(500);
        }

        @Test
        public void It_should_show_all_text() {
            onView(allOf(
                    withId(R.id.expandable_text_view_hidden_text_view),
                    isDescendantOfA(withId(R.id.expandable_text_view))))
                    .check(matches(withText(EXPANDABLE_TEXT)));
        }
    }

}
