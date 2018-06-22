package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
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
import br.com.stant.libraries.stantuiandroid.componentsactivities.actionbuttonview.ActionButtonViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.simpleinformationscardview.SimpleInformationsCardViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Ui tests for the implementation of {@link SimpleInformationsCardViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class SimpleInformationsCardViewActivityTest {

    public abstract static class Describe_Simple_Informations_Card_View_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<SimpleInformationsCardViewActivity> mActivity = new ActivityTestRule<>(SimpleInformationsCardViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(SimpleInformationsCardViewActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public static class Context_when_check_simple_informations_card_view extends Describe_Simple_Informations_Card_View_Activity_content {

        //TODO refactor
        @Test
        public void It_should_show_first_title_text_correctly() {
            String horizontalText = InstrumentationRegistry.getTargetContext().getString(R.string.action_button_view_text_button_horizontal_example);

            onView(allOf(
                    withId(R.id.action_button_view_horizontal_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .check(matches(withText(horizontalText)));
        }

        //TODO refactor
        @Ignore
        @Test
        public void It_should_show_first_value_text_correctly() {
            onView(allOf(
                    withId(R.id.action_button_view_horizontal_icon_image_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }


    }

    public static class Context_when_change_for_second_status extends Describe_Simple_Informations_Card_View_Activity_content {
        @Before
        public void clickOnButton() {
            //ver como ele muda de status
        }
        //TODO refactor
        @Ignore
        @Test
        public void It_should_show_second_title_text_correctly() {
            String horizontalText = InstrumentationRegistry.getTargetContext().getString(R.string.action_button_view_text_button_horizontal_example);

            onView(allOf(
                    withId(R.id.action_button_view_horizontal_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .check(matches(withText(horizontalText)));
        }
        //TODO refactor
        @Ignore
        @Test
        public void It_should_show_second_value_text_correctly() {
            onView(allOf(
                    withId(R.id.action_button_view_horizontal_icon_image_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }
    }


}
