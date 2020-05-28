package com.example.androidtestproject;

import android.app.Activity;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {
    @Test
    public void check_back_button(){
        ActivityScenario<SecondActivity> activityActivityScenario = ActivityScenario.launch(SecondActivity.class);
        onView(withId(R.id.second)).check(matches(isDisplayed()));
        onView(withId(R.id.backBtn)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
}
