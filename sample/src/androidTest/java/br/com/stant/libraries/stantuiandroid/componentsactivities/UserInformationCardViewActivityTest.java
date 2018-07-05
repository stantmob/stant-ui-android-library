package br.com.stant.libraries.stantuiandroid.componentsactivities;

/**
 * Created by stant02 on 25/06/18.
 */

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.TestBase;
import br.com.stant.libraries.stantuiandroid.componentsactivities.userinformationcardview.UserInformationCardViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.allOf;

/**
 * Ui tests for the implementation of {@link UserInformationCardViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class UserInformationCardViewActivityTest {
    public abstract static class Describe_User_Information_Card_View_Activity_content extends TestBase {

        static final String USER_PHOTO   = "http://seatotal.com.br/wp-content/uploads/2014/11/imagem_post-construtoras-seatotal.jpg";
        static final String USER_NAME    = "User Name";
        static final String USER_ROLE    = "User Role";
        static final String USER_TYPE    = "C";

        @Rule
        public ActivityTestRule<UserInformationCardViewActivity> mActivity = new ActivityTestRule<>(UserInformationCardViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(UserInformationCardViewActivity.class);
            mActivity.launchActivity(intent);

        }

    }

    public static class Context_when_check_user_information_card_view_content extends Describe_User_Information_Card_View_Activity_content {

        @Before
        public void setCardInformation() {
            Drawable BADGE_ICON = InstrumentationRegistry.getTargetContext().getDrawable(R.drawable.ic_polygon_2);
            mActivity.getActivity().setCardWithBadgeEnable(USER_NAME, USER_ROLE, USER_TYPE, USER_PHOTO, BADGE_ICON);
            waitEspresso(500);
        }

        @Test
        public void It_should_show_name_correctly() {
            onView(allOf(withId(R.id.user_information_card_name),
                    isDescendantOfA(withId(R.id.user_information_card_view))))
                    .check(matches(withText(USER_NAME)));
        }

        @Test
        public void It_should_show_role_correctly() {
            onView(allOf(withId(R.id.user_information_card_role),
                    isDescendantOfA(withId(R.id.user_information_card_view))))
                    .check(matches(withText(USER_ROLE)));
        }

        @Test
        public void It_should_show_type_correctly() {
            onView(allOf(withId(R.id.user_information_card_type),
                    isDescendantOfA(withId(R.id.user_information_card_view))))
                    .check(matches(withText(USER_TYPE)));
        }

        @Test
        public void It_should_show_user_photo() {
            onView(allOf(withId(R.id.user_information_card_photo),
                    isDescendantOfA(withId(R.id.user_information_card_view))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }

        @Test
        public void It_should_show_badge() {
            onView(allOf(withId(R.id.user_information_card_badge),
                    isDescendantOfA(withId(R.id.user_information_card_view))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }

    }

    public static class Context_when_check_user_information_card_view_content_with_badge_disable extends Describe_User_Information_Card_View_Activity_content {

        @Before
        public void setBadgeDisable() {
            mActivity.getActivity().setCardWithBadgeDisable(USER_NAME, USER_ROLE, USER_TYPE, USER_PHOTO);
            waitEspresso(500);
        }

        @Test
        public void It_should_show_badge_with_visibility_gone() {
            onView(allOf(withId(R.id.user_information_card_badge),
                    isDescendantOfA(withId(R.id.user_information_card_view))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }


}
