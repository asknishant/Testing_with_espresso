package com.example.androidtestproject;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.Espresso;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.androidtestproject", appContext.getPackageName());
    }
    @Test
    public void enter_first_name(){
        onView(withId(R.id.fname)).perform(typeText("Nishant"));
    }
    @Test
    public void enter_last_name(){
        onView(withId(R.id.lname)).perform(typeText("Kumar"));
    }
    @Test
    public void checkName(){
        onView(withId(R.id.fname)).perform(typeText("Nishant"), closeSoftKeyboard());
        onView(withId(R.id.lname)).perform(typeText("Kumar"), closeSoftKeyboard());
        onView(withId(R.id.btn)).perform(click());
        onView(withId(R.id.display)).check(matches(isDisplayed()));
    }
}
