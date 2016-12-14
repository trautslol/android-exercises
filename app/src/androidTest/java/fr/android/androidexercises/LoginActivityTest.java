package fr.android.androidexercises;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        //injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    public void takeScreenshot(String name) {
        //Spoon.screenshot(getCurrentActivity(), name);
    }

//    public Activity getCurrentActivity() {
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        instrumentation.waitForIdleSync();
//        final Activity[] activity = new Activity[1];
//        instrumentation.runOnMainSync(new Runnable() {
//            @Override
//            public void run() {
//                ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
//                java.util.Collection<Activity> resumedActivities = activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
//                activity[0] = Iterables.getOnlyElement(resumedActivities);
//            }
//        });
//        return activity[0];
//    }
    public void testLogin() throws Exception {
        Espresso.onView(ViewMatchers.withId(R.id.usernameEdit)).perform(ViewActions.typeText("b@xebia.fr"));

        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("password"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.loggedText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}