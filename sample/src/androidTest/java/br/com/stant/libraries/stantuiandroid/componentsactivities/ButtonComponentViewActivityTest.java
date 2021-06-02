package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.buttoncomponentview.ButtonComponentViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Ui tests for the implementation of {@link ButtonComponentViewActivity}
 */

@RunWith(Enclosed.class)
@LargeTest
public class ButtonComponentViewActivityTest {

    public abstract static class Describe_Button_Component_View_Activity_content extends TestBase {
        static final Drawable SHADOW_SHAPE = InstrumentationRegistry.getTargetContext().getDrawable(R.drawable.shape_round_dark_blue);
        static final Drawable SHAPE = InstrumentationRegistry.getTargetContext().getDrawable(R.drawable.shape_round_blue);
        static final String TEXT = InstrumentationRegistry.getTargetContext().getString(R.string.button_component_text);

        @Rule
        public ActivityTestRule<ButtonComponentViewActivity> mActivity = new ActivityTestRule<>(ButtonComponentViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(ButtonComponentViewActivity.class);
            mActivity.launchActivity(intent);
            waitEspresso(500);

        }

    }

    public static class Context_when_check_button_component_view extends Describe_Button_Component_View_Activity_content {

        @Before
        public void setButtonDesign() {
            mActivity.getActivity().setButtonDesign(SHADOW_SHAPE, SHAPE, TEXT);
        }

        //TODO: Later, implement this test for drawable as well.
        @Test
        public void It_should_show_text_correctly() {
            waitEspresso(500);
            onView(allOf(withId(R.id.button_component_textview),
                    isDescendantOfA(withId(R.id.button_component_view))))
                    .check(matches(withText(TEXT)));
        }

    }

    public static class Context_when_click_on_button_component_view extends Describe_Button_Component_View_Activity_content {
        @Before
        public void clickOnButton() {
            onView(withId(R.id.button_component_view))
                    .perform(click());
        }

        @Test
        public void It_should_show_toast_when_click() {
            String buttonText = "Button";
            onView(withText(buttonText)).
                    inRoot(withDecorView(not(is(mActivity.getActivity().getWindow().
                            getDecorView())))).check(matches(isDisplayed()));
        }
    }


}
