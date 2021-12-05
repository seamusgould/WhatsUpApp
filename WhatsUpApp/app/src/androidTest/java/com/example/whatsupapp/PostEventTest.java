package com.example.whatsupapp;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Test;


import com.example.whatsupapp.Controller.ControllerActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
//public class PostEventTest {
//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.whatsupapp", appContext.getPackageName());
//    }
//}

public class PostEventTest {

    @org.junit.Rule
    ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);

    @Test
    public void testPostEvent(){

    }

}


