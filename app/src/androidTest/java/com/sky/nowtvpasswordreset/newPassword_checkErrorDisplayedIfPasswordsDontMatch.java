package com.sky.nowtvpasswordreset;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class newPassword_checkErrorDisplayedIfPasswordsDontMatch {

    @Rule
    public ActivityTestRule<NewPasswordActivity> mActivityTestRule = new ActivityTestRule<>(NewPasswordActivity.class);


}
