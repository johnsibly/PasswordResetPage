package com.sky.nowtvpasswordreset;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A password reset screen
 */
public class NewPasswordActivity extends AppCompatActivity {

    // UI references.
    private EditText mPassword1View;
    private EditText mPassword2View;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        // Set up the login form.
        mPassword1View = (EditText) findViewById(R.id.password1);
        mPassword2View = (EditText) findViewById(R.id.password2);

        Button mSetPasswordButton = (Button) findViewById(R.id.set_password_button);
        mSetPasswordButton .setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSetPassword();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptSetPassword() {
        // Reset errors.
        mPassword1View.setError(null);
        mPassword2View.setError(null);

        // Store values at the time of the login attempt.
        String password1 = mPassword1View.getText().toString();
        String password2 = mPassword2View.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!isPasswordValid(password1, password2)) {
            mPassword2View.setError(getString(R.string.error_invalid_password));
            focusView = mPassword2View;
            cancel = true;
        }
        else {
            Toast.makeText(getApplicationContext(), "Your password was successfully set", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isPasswordValid(String password1, String password2) {
        return (new PasswordComplexityValidator().Validate(password1, password2));
    }

}

