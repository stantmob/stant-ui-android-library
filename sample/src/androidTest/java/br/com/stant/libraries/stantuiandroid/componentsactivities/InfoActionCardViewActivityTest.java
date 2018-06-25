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
import br.com.stant.libraries.stantuiandroid.componentsactivities.increasedecreasebuttonsview.IncreaseDecreaseButtonsViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.infoactioncardview.InfoActionCardViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link InfoActionCardViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class InfoActionCardViewActivityTest {

    public abstract static class Describe_Info_Action_Card_View_Activity_content extends TestBase {
        static final String INFORMATION_TEXT = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.info_action_card_information_text);
        static final String ACTION_TEXT = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.info_action_card_action_text);

        @Rule
        public ActivityTestRule<InfoActionCardViewActivity> mActivity = new ActivityTestRule<>(InfoActionCardViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(InfoActionCardViewActivity.class);
            mActivity.launchActivity(intent);
            mActivity.getActivity().setText(INFORMATION_TEXT, ACTION_TEXT);
            waitEspresso(1000);
        }

    }

    public static class Context_when_check_info_action_card_view extends Describe_Info_Action_Card_View_Activity_content {

        @Test
        public void It_should_show_information_text_correctly() {
            String buttonText = InstrumentationRegistry.getTargetContext().getString(R.string.info_action_card_information_text);

            onView(allOf(
                    withId(R.id.info_action_card_view_title_text),
                    isDescendantOfA(withId(R.id.info_action_card))))
                    .check(matches(withText(buttonText)));
        }

        @Test
        public void It_should_show_action_text_correctly() {
            String buttonText = InstrumentationRegistry.getTargetContext().getString(R.string.info_action_card_action_text);

            onView(allOf(
                    withId(R.id.info_action_card_view_action_text),
                    isDescendantOfA(withId(R.id.info_action_card))))
                    .check(matches(withText(buttonText)));
        }

    }

    public static class Context_when_click_on_action_button extends Describe_Info_Action_Card_View_Activity_content {
        @Before
        public void clickOnButton() {
            waitEspresso(500);
            onView(withId(R.id.info_action_card_view_action_text))
                    .perform(click());
        }

        @Test
        public void It_should_show_toast_when_click() {
            String toastText = "Info card action";

            onView(withText(toastText)).
                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
                            getDecorView())))).check(matches(isDisplayed()));
        }
    }


}
