package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.simplerequestinfosnackbar.SimpleRequestInfoSnackbarActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.viewinguserdialog.ViewingUserDialogActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUserDto;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.RecyclerViewMatcher.withRecyclerView;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Ui tests for the implementation of {@link ViewingUserDialogActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class ViewingUserDialogActivityTest {

    public abstract static class Describe_Viewing_User_Activity_content extends TestBase {

        @Rule
        public ActivityTestRule<ViewingUserDialogActivity> mActivity = new ActivityTestRule<>(ViewingUserDialogActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(ViewingUserDialogActivity.class);
            mActivity.launchActivity(intent);
        }

    }

    public abstract static class Context_when_click_on_horizontal_action_button_view extends Describe_Viewing_User_Activity_content {
        @Before
        public void clickOnButton() {
            onView(allOf(
                    withId(R.id.action_button_view_horizontal_main_title_text_view),
                    isDescendantOfA(withId(R.id.action_button_view_horizontal_component))))
                    .perform(click());
        }

    }

    public static class Context_when_open_viewing_user_dialog extends Context_when_click_on_horizontal_action_button_view {
        @Test
        public void It_should_show_correct_user_information_on_first_user() {
            onView(Matchers.allOf(withId(R.id.viewing_users_dialog_item_user_name_text_view),
                    isDescendantOfA(withRecyclerView(R.id.viewing_users_dialog_recycler).
                            atPosition(0))))
                    .check(matches(withText("User 1")));

            onView(Matchers.allOf(withId(R.id.viewing_users_dialog_item_user_function_text_view),
                    isDescendantOfA(withRecyclerView(R.id.viewing_users_dialog_recycler).
                            atPosition(0))))
                    .check(matches(withText("Role 1")));
        }

        @Test
        public void It_should_show_correct_user_information_on_second_user() {
            onView(Matchers.allOf(withId(R.id.viewing_users_dialog_item_user_name_text_view),
                    isDescendantOfA(withRecyclerView(R.id.viewing_users_dialog_recycler).
                            atPosition(1))))
                    .check(matches(withText("User 2")));

            onView(Matchers.allOf(withId(R.id.viewing_users_dialog_item_user_function_text_view),
                    isDescendantOfA(withRecyclerView(R.id.viewing_users_dialog_recycler).
                            atPosition(1))))
                    .check(matches(withText("Role 2")));
        }

        @Test
        public void It_should_show_correct_user_information_on_third_user() {
            onView(Matchers.allOf(withId(R.id.viewing_users_dialog_item_user_name_text_view),
                    isDescendantOfA(withRecyclerView(R.id.viewing_users_dialog_recycler).
                            atPosition(2))))
                    .check(matches(withText("User 3")));

            onView(Matchers.allOf(withId(R.id.viewing_users_dialog_item_user_function_text_view),
                    isDescendantOfA(withRecyclerView(R.id.viewing_users_dialog_recycler).
                            atPosition(2))))
                    .check(matches(withText("Role 3")));
        }

    }


}
