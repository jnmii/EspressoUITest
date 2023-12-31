package com.example.espressouitest

import androidx.compose.ui.test.hasClickAction
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun test_isActivityinView() {
       val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
        //tests the  visinillity of title and the button in mainactivity
    @Test
    fun test_visibility_title_nextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //tests visibility of the main activity main title on start up,     checks if the it can be displayed on emulator
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))

        //tests if the button becomes visible on the main activity screen, not the functionanlity
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed())) //method1

        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))// method  2, can be set to GONE.VISBILE, INVISIBLE
    }
@Test
fun test_isTitleTextDisplayed(){
    val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))}

    @Test
    fun test_navSecondaryActivity() {
      val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
       // onView(withId(R.id.button_back)).perform(click())//method 1 uses the back button from the layout
        pressBack()//method 2 uses the "go back function from the device
        //to confrim that mainactivty is back in view
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}
//Tests ran in alphabetical order