package com.example.kerulis_praktinis_2;


import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {

        onView(withId(R.id.inputTextWordCounter)).perform(clearText());

        onView(withId(R.id.inputTextWordCounter)).perform(typeText("This is a preliminary test of text input"));
        closeSoftKeyboard();
        onView(allOf(withText("Word counter"))).perform(click());

        onView(withId(R.id.inputTextWordCounter)).perform(clearText()).perform(typeText("Input text here"));
        onView(withId(R.id.inputTextWordCounter)).check(matches(withText("Input text here")));

        onView(withId(R.id.inputTextWordCounter)).perform(typeText("tHis   is   a   preliminary   test   of   text   input"));
        closeSoftKeyboard();
        onView(allOf(withText("Word counter"))).perform(click());

        onView(withId(R.id.inputTextWordCounter)).perform(clearText()).perform(typeText("Input text here"));
        onView(withId(R.id.inputTextWordCounter)).check(matches(withText("Input text here")));

        onView(withId(R.id.inputTextWordCounter)).perform(typeText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
        closeSoftKeyboard();
        onView(allOf(withText("Word counter"))).perform(click());

        onView(withId(R.id.inputTextWordCounter)).perform(clearText()).perform(typeText("Input text here"));
        onView(withId(R.id.inputTextWordCounter)).check(matches(withText("Input text here")));

        onView(withId(R.id.inputTextWordCounter)).perform(typeText("123321323 This is a test                       preliminary."));
        closeSoftKeyboard();
        onView(allOf(withText("Word counter"))).perform(click());

        onView(withId(R.id.inputTextWordCounter)).perform(clearText()).perform(typeText("Input text here"));
        onView(withId(R.id.inputTextWordCounter)).check(matches(withText("Input text here")));


        onView(withId(R.id.inputTextWordCounter)).perform(typeText("___________________________...@#########@@@!@!@#$&*(Y&^&^                                                        preliminary."));
        closeSoftKeyboard();
        onView(allOf(withText("Word counter"))).perform(click());

        onView(withId(R.id.inputTextWordCounter)).perform(clearText()).perform(typeText("Input text here"));
        onView(withId(R.id.inputTextWordCounter)).check(matches(withText("Input text here")));

       /* onView(withId(R.id.inputTextWordCounter),withText("Input text here"))
                .perform(typeText("This is a preliminary test of text input"),click())
                .check(matches(withText("This is a preliminary test of text input")))
                .perform(typeText("Input text here"));

        onView(withId(R.id.inputTextWordCounter),withText("Input text here"))
                .perform(typeText("tHis   is   a   preliminary   test   of   text   input"),click())
                .check(matches(withText("tHis   is   a   preliminary   test   of   text   input")))
                .perform(typeText("Input text here"));

        onView(withId(R.id.inputTextWordCounter),withText("Input text here"))
                .perform(typeText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"),click())
                .check(matches(withText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")))
                .perform(typeText("Input text here"));

        onView(withId(R.id.inputTextWordCounter),withText("Input text here"))
                .perform(typeText("123321323 This is a test                       preliminary."),click())
                .check(matches(withText("123321323 This is a test                       preliminary.")))
                .perform(typeText("Input text here"));

        onView(withId(R.id.inputTextWordCounter),withText("Input text here"))
                .perform(typeText("___________________________...@#########@@@!@!@#$&*(Y&^&^                                                        preliminary."),click())
                .check(matches(withText("___________________________...@#########@@@!@!@#$&*(Y&^&^                                                        preliminary.")))
                .perform(typeText("Input text here"));

        onView(withId(R.id.inputTextWordCounter),withText("Input text here"))
                .perform(typeText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"),click())
                .check(matches(withText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")))
                .perform(typeText("Input text here"));*/



       /*ViewInteraction editText = onView(
                allOf(withId(R.id.inputTextWordCounter), withText("Input text here"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("This is a preliminary test of text input")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.inputTextWordCounter), withText("Input text here"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText2.check(matches(withText("tHis   is   a   preliminary   test   of   text   input")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.inputTextWordCounter), withText("Input text here"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText3.check(matches(withText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.inputTextWordCounter), withText("Input text here"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText4.check(matches(withText("123321323 This is a test                                                                                      preliminary.")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.inputTextWordCounter), withText("Input text here"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText5.check(matches(withText("___________________________...@#########@@@!@!@#$&*(Y&^&^                                                        preliminary.")));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.inputTextWordCounter), withText("Input text here"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText6.check(matches(withText("___________________________...@#########@@@!@!@#$&*(Y&^&^                                                        preliminary.")));
*/
    }



}
