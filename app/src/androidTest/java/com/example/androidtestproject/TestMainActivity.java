package com.example.androidtestproject;

import android.app.Activity;
import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class TestMainActivity {
    @Test
    public void check_activity_launch(){
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void check_btn_clicked(){

        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Espresso.onView(withId(R.id.next)).perform(click());
        ActivityScenario activityScenario1 = ActivityScenario.launch(SecondActivity.class);
        Espresso.onView(withId(R.id.second)).check(matches(isDisplayed()));
    }

    @Test
    public void on_back_button_pressed(){
        pressBack();
    }

}
