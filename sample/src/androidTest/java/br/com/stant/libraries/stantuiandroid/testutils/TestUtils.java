package br.com.stant.libraries.stantuiandroid.testutils;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.Visibility;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;

public class TestUtils {

    public static void waitEspresso(long milles) {
        try {
            sleep(milles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void checkIfIdIsDisplayed(int id){
        onView(withId(id)).check(matches(isDisplayed()));
    }

    public static void checkIfIdIsNotVisible(int id){
        onView(withId(id)).check(matches(withEffectiveVisibility(Visibility.GONE)));
    }

    public static void findAndClick(int id){
        onView(withId(id)).perform(click());
    }

    public static String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }

}
