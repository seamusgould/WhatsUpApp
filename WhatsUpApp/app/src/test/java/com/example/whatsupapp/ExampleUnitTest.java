package com.example.whatsupapp;

import org.testng.annotations.Test;

import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}