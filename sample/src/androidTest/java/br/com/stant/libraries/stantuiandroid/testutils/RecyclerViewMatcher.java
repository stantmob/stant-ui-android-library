package br.com.stant.libraries.stantuiandroid.testutils;


import android.content.res.Resources;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static br.com.stant.libraries.stantuiandroid.testutils.ColorUtils.withBgColor;
import static org.hamcrest.CoreMatchers.allOf;

public class RecyclerViewMatcher {

    private final int recyclerViewId;

    public RecyclerViewMatcher(int recyclerViewId) {
        this.recyclerViewId = recyclerViewId;
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {

        return new RecyclerViewMatcher(recyclerViewId);
    }

    public static void checkIfDisplayedOnRecycleViewItem(int recyclerViewId, int position, int contentId) {
        onView(withRecyclerView(recyclerViewId).atPosition(position))
                .check(matches(hasDescendant(withId(contentId))));
    }

    public static void checkIfHasColorInItemOnRecycleViewItem(int recyclerViewId, int position, int colorId) {
        onView(withRecyclerView(recyclerViewId).atPosition(position))
                .check(matches(withBgColor(colorId)));
    }

    public static void checkTextOnRecycleViewItem(int recyclerViewId, int position, int contentId, String text) {
            onView(withRecyclerView(recyclerViewId)
            .atPositionOnView(position,contentId))
                    .check(matches(withText(text)));
    }

    public static void checkIfIsDisplayedWithTextOnRecyclerView(int recyclerViewId, int position, String text){
        onView(withRecyclerView(recyclerViewId).atPosition(position))
                .check(matches(hasDescendant(withText(text))));
    }

    public Matcher<View> atPosition(final int position) {
        return atPositionOnView(position, -1);
    }

    public Matcher<View> atPositionOnView(final int position, final int targetViewId) {

        return new TypeSafeMatcher<View>() {
            Resources resources = null;
            View childView;

            public void describeTo(Description description) {
                String idDescription = Integer.toString(recyclerViewId);
                if (this.resources != null) {
                    try {
                        idDescription = this.resources.getResourceName(recyclerViewId);
                    } catch (Resources.NotFoundException var4) {
                        idDescription = String.format("%s (resource name not found)", recyclerViewId);
                    }
                }

                description.appendText("RecyclerView with id: " + idDescription + " at position: " + position);
            }

            public boolean matchesSafely(View view) {

                this.resources = view.getResources();

                if (childView == null) {
                    RecyclerView recyclerView =
                            (RecyclerView) view.getRootView().findViewById(recyclerViewId);
                    if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
                        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                        if (viewHolder != null) {
                            childView = viewHolder.itemView;
                        }
                    }
                    else {
                        return false;
                    }
                }

                if (targetViewId == -1) {
                    return view == childView;
                } else {
                    View targetView = childView.findViewById(targetViewId);
                    return view == targetView;
                }
            }
        };
    }

}
