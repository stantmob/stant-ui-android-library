package br.com.stant.libraries.stantuiandroid.testutils;

import android.graphics.drawable.ColorDrawable;
import androidx.test.espresso.intent.Checks;
import androidx.test.espresso.matcher.BoundedMatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ColorUtils {

    public static Matcher<View> withBgColor(final int color) {
        Checks.checkNotNull(color);
        return new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
            @Override
            public boolean matchesSafely(LinearLayout row) {
                return color == ((ColorDrawable) row.getBackground()).getColor();
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("with text color: ");
            }
        };
    }

    public static Matcher<View> withBackgroundColor(final int backgroundColor) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                int color = ((ColorDrawable) view.getBackground().getCurrent()).getColor();
                Log.w("espresso", "view has color  " + color);
                return color == view.getResources().getColor(backgroundColor);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with background color from id: " + backgroundColor);
            }
        };
    }
}
