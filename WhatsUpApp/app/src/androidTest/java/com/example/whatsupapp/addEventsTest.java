package com.example.whatsupapp;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import com.example.whatsupapp.Controller.ControllerActivity;


import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//@RunWith(AndroidJUnit4.class)
public class addEventsTest {

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
    public void testAddItems(){

        Espresso.onView(ViewMatchers.withId(R.id.PostButton)).perform(ViewActions.click());

        ViewInteraction addedEvents = Espresso.onView(ViewMatchers.withId(R.id.eventList));

        ViewInteraction name = Espresso.onView(ViewMatchers.withId(R.id.editName))
                .perform(ViewActions.typeText("Chess Club"));

        ViewInteraction date = Espresso.onView(ViewMatchers.withId(R.id.editDate))
                .perform(ViewActions.typeText("12/12/2022"));

        ViewInteraction time = Espresso.onView(ViewMatchers.withId(R.id.editTime))
                .perform(ViewActions.typeText("11:30am"));

        ViewInteraction loc = Espresso.onView(ViewMatchers.withId(R.id.editLoc))
                .perform(ViewActions.typeText("Main Building"));

        loc.perform(ViewActions.pressBack());

        ViewInteraction desc = Espresso.onView(ViewMatchers.withId(R.id.editDescription))
                .perform(ViewActions.typeText("Playing a tournament that has rating guides."));

        loc.perform(ViewActions.pressBack());

        Espresso.onView(ViewMatchers.withId(R.id.addEventButton)).perform(ViewActions.click());

        String str = "";
        str += "User" +" posted: \n";
        str += " On " + "12/12/2022" + " " + "11:30am" + " " + "Chess Club" + " at " + "Main Building";
        str += "\n " + "Playing a tournament that has rating guides.";


/*
        addedEvents.check(ViewAssertions.matches(ViewMatchers.withSubstring(str)));
*/

        addedEvents.check(ViewAssertions.matches(ViewMatchers.withSubstring("Main")));

        name.perform(ViewActions.typeText("Soccer Game"));
        date.perform(ViewActions.typeText("12/12/2022"));
        time.perform(ViewActions.typeText("11:30am"));
        loc.perform(ViewActions.typeText("Main Building"));
        desc.perform(ViewActions.typeText("Playing a pick up soccer game."));

        addedEvents.check(ViewAssertions.matches(ViewMatchers.withSubstring("User posted: \n On 12/12/2022 1:30am Chess Club at Main Building + \n Playing a tournament that has rating guides.")));
        addedEvents.check(ViewAssertions.matches(ViewMatchers.withSubstring("User posted: \n On 12/12/2022 11:30am Soccer Game at Main Building + \n Playing a pick up soccer game.")));

    }
}