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
import br.com.stant.libraries.stantuiandroid.componentsactivities.informationcardview.InformationCardViewActivity;
import br.com.stant.libraries.stantuiandroid.testutils.IntentFactory;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview.SeverityLevelEnum;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.TestUtils.waitEspresso;
import static org.hamcrest.Matchers.allOf;

/**
 * Ui tests for the implementation of {@link InformationCardViewActivity}
 */
@RunWith(Enclosed.class)
@LargeTest
public class InformationCardViewActivityTest {
    public abstract static class Describe_Information_Card_View_Activity_content extends TestBase {

        static final String TITLE                           = "Grade de proteção colocada de forma incorreta";
        static final String TYPE                            = "Qualidade";
        static final String ACTIONS                         = "4/5";
        static final String CREATED_AT                      = "01/01/2018";
        static final String DEADLINE                        = "30/12/2018";
        static final String OCCURRENCE_ID                   = "333333";
        static final Integer SEVERITY_LEVEL                 = 3;
        static final Integer SERVICE_INSPECTION_FORM_FILLED = 4;

        @Rule
        public ActivityTestRule<InformationCardViewActivity> mActivity = new ActivityTestRule<>(InformationCardViewActivity.class);

        @Before
        public void before() {
            Intent intent = IntentFactory.createIntentWithoutBundle(InformationCardViewActivity.class);
            mActivity.launchActivity(intent);

        }

    }

    public static class Context_when_check_information_card_view_content extends Describe_Information_Card_View_Activity_content {

        @Before
        public void setCardInformations() {
            mActivity.getActivity().setInformation(TITLE, TYPE, ACTIONS, CREATED_AT, DEADLINE, OCCURRENCE_ID, SEVERITY_LEVEL, SERVICE_INSPECTION_FORM_FILLED);
            waitEspresso(500);
        }

        @Test
        public void It_should_show_severity_level() {
            onView(allOf(withId(R.id.information_card_view_severity_level),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        }

        @Test
        public void It_should_show_title_text_correctly() {
            onView(allOf(withId(R.id.information_card_view_title_text),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withText(TITLE)));
        }

        @Test
        public void It_should_show_deadline_text_correctly() {
            onView(allOf(withId(R.id.information_card_view_deadline_date),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withText(DEADLINE)));
        }

        @Test
        public void It_should_show_occurrence_id_text_correctly() {
            onView(allOf(withId(R.id.information_card_view_id_value),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withText(OCCURRENCE_ID)));
        }

        @Test
        public void It_should_show_actions_text_correctly() {
            onView(allOf(withId(R.id.information_card_view_actions),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withText(ACTIONS)));
        }

        @Test
        public void It_should_show_type_text_correctly() {
            onView(allOf(withId(R.id.information_card_view_type_text),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withText(TYPE)));
        }

        @Test
        public void It_should_show_created_at_text_correctly() {
            onView(allOf(withId(R.id.information_card_view_created_at_date),
                    isDescendantOfA(withId(R.id.information_card_view))))
                    .check(matches(withText(CREATED_AT)));
        }

    }

}
