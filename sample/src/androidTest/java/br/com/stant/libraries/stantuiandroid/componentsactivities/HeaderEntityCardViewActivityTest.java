package br.com.stant.libraries.stantuiandroid.componentsactivities;

/**
 * Created by stant02 on 25/06/18.
 */

import android.content.Intent;
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
import br.com.stant.libraries.stantuiandroid.componentsactivities.headerentitycardview.HeaderEntityCardViewActivity;
import br.com.stant.libraries.stantuiandroid.componentsactivities.informationcardview.InformationCardViewActivity;
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
 * Ui tests for the implementation of {@link HeaderEntityCardViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class HeaderEntityCardViewActivityTest {
    public abstract static class Describe_Header_Entity_Card_View_Activity_content extends TestBase {

        static final String TITLE            = "Title";
        static final String END_AT           = "30/12/2018";
        static final String START_AT         = "01/01/2018";
        static final String FIRST_QUANTITY   = "3";
        static final String SECOND_QUANTITY  = "5";

        @Rule
        public ActivityTestRule<HeaderEntityCardViewActivity> mActivity = new ActivityTestRule<>(HeaderEntityCardViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(HeaderEntityCardViewActivity.class);
            mActivity.launchActivity(intent);

        }

    }

    public static class Context_when_check_header_entity_card_view_content extends Describe_Header_Entity_Card_View_Activity_content {

        @Before
        public void setCardInformations() {
            mActivity.getActivity().setInformation(TITLE, END_AT, START_AT, FIRST_QUANTITY, SECOND_QUANTITY);
            waitEspresso(500);
        }

        @Test
        public void It_should_show_title_text_correctly() {
            onView(allOf(withId(R.id.header_entity_card_view_type_text),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withText(TITLE)));
        }

        @Test
        public void It_should_show_end_at_text_correctly() {
            onView(allOf(withId(R.id.header_entity_card_view_end_at_date),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withText(END_AT)));
        }

        @Test
        public void It_should_show_start_at_text_correctly() {
            onView(allOf(withId(R.id.header_entity_card_view_start_at_date),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withText(START_AT)));
        }

        @Test
        public void It_should_show_first_quantity_correctly() {
            onView(allOf(withId(R.id.header_entity_first_quantity),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withText(FIRST_QUANTITY)));
        }

        @Test
        public void It_should_show_second_quantity_correctly() {
            onView(allOf(withId(R.id.header_entity_second_quantity),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withText(SECOND_QUANTITY)));
        }

        @Test
        public void It_should_hide_critical_icon() {
            onView(allOf(withId(R.id.header_entity_card_critical_icon),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }

    }

    public static class Context_when_check_header_critical_entity_card_view_content extends Describe_Header_Entity_Card_View_Activity_content {

        @Before
        public void setCardInformations() {
            mActivity.getActivity().setInformation(TITLE, END_AT, START_AT, FIRST_QUANTITY, SECOND_QUANTITY);
            mActivity.getActivity().setCritical();
            waitEspresso(500);
        }

        @Test
        public void It_should_show_critical_icon() {
            onView(allOf(withId(R.id.header_entity_card_critical_icon),
                    isDescendantOfA(withId(R.id.header_entity_card_view))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }

    }

}

