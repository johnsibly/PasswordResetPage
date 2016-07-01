package com.sky.nowtvpasswordreset;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import android.support.test.espresso.Root;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;



@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewPasswordActivityTest {

    @Rule
    public ActivityTestRule<NewPasswordActivity> mActivityTestRule = new ActivityTestRule<>(NewPasswordActivity.class);

    @Test
    public void newPassword_checkSuccessMessageDisplayed() {
        ViewInteraction appCompatAutoCompleteTextView = onView(allOf(withId(R.id.password1), isDisplayed()));
        appCompatAutoCompleteTextView.perform(replaceText("P@5sword"));

        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.password2), isDisplayed()));
        appCompatEditText.perform(replaceText("P@5sword"));

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.set_password_button), withText("Set password"), withParent(allOf(withId(R.id.email_login_form), withParent(withId(R.id.login_form)))), isDisplayed()));
        appCompatButton.perform(click());

        onView(withText(R.string.password_set_successfully)).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));
    }

    @Test
    public void newPassword_checkErrorDisplayedIfPasswordsDontMatch() {
        ViewInteraction appCompatAutoCompleteTextView = onView(allOf(withId(R.id.password1), isDisplayed()));
        appCompatAutoCompleteTextView.perform(replaceText("123"));

        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.password2), isDisplayed()));
        appCompatEditText.perform(replaceText("abc"));

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.set_password_button), withText("Set password"), withParent(allOf(withId(R.id.email_login_form), withParent(withId(R.id.login_form)))), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(allOf(withId(R.id.set_password_result), withText("The passwords entered were invalid"), withParent(allOf(withId(R.id.email_login_form), withParent(withId(R.id.login_form)))), isDisplayed()));
        textView.check(matches(withText("The passwords entered were invalid")));
    }
}
