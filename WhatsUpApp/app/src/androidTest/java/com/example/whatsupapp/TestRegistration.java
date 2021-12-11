package com.example.whatsupapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.whatsupapp.Controller.ControllerActivity;
import com.example.whatsupapp.R;

import org.junit.Test;

public class TestRegistration {

        @org.junit.Rule
        public ActivityScenarioRule<ControllerActivity> activityRule =
                new ActivityScenarioRule<>(ControllerActivity.class);

        @Test
        public void useAppContext() {
                // Context of the app under test.
                Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                assertEquals("com.example.whatsupapp", appContext.getPackageName());
        }

        @Test
        public void testRegister(){

                ViewInteraction password = onView(withId(R.id.passwordEditText))
                        .perform(ViewActions.typeText("password"));

                ViewInteraction username = onView(withId(R.id.usernameEditText))
                        .perform(ViewActions.typeText("username"));

                username.check(ViewAssertions.matches(ViewMatchers.withSubstring("username")));
                password.check(ViewAssertions.matches(ViewMatchers.withSubstring("password")));

        }
}