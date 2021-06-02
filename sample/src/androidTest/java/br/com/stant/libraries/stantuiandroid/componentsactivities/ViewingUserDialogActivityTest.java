package br.com.stant.libraries.stantuiandroid.componentsactivities;

import android.content.Intent;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.viewinguserdialog.ViewingUserDialogActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUserDto;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
            createUsers();
        }

        private void createUsers(){
            ViewingUserDto user1 = new ViewingUserDto("User 1", null, "Role 1");
            ViewingUserDto user2 = new ViewingUserDto("User 2", null, "Role 2");
            mActivity.getActivity().setUsers(user1, user2);
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


    }


}
