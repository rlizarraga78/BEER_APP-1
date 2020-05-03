package com.example.beer_app;

import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.beer_app.HomeFragment;
import com.example.beer_app.MainActivity;
import com.example.beer_app.R;
import com.example.beer_app.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    //private ActivityEmailPasswordBinding mBinding;
    //private LoginViewModel loginViewModel;
    EditText emailId, password, name;
    Button buttonSignUp;
    TextView tvSignUp;
    CheckBox ageCheck;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReference();
    //DatabaseReference mUsername = myRef.child("users");

    DatabaseReference databaseUsers;

    private void updateUI(FirebaseUser currentUser) {
    }

    //end database stuff
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.enter_username);
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        buttonSignUp = findViewById(R.id.signup);
        tvSignUp = findViewById(R.id.textView20);
        ageCheck = findViewById(R.id.checkBox);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(SignUpActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUpActivity.this, HomeFragment.class);
                    startActivity(i);
                } else {
                    Toast.makeText(SignUpActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                final String userName = name.getText().toString();

                if (userName.isEmpty()) {
                    name.setError("Please enter your name");
                    name.requestFocus();
                } else if (email.isEmpty()) {
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (!ageCheck.isChecked()) {
                    Toast.makeText(SignUpActivity.this, "Sorry, must be 21 or up to join", Toast.LENGTH_SHORT).show();
                    Intent intToLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intToLogin);
                } else {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Sign Up Error, Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                //String id = databaseUsers.push().getKey();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                databaseUsers = FirebaseDatabase.getInstance().getReference();
                                final String uid = user.getUid();

                                User newUser = new User(uid, name.getText().toString());
                                databaseUsers.child("users").child(uid).setValue(newUser);
                                Toast.makeText(SignUpActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

                                Intent intToHome = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
            }
        });


        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intSignUp);
            }
        });
    }
}
/**
    @Override
    public void onStart () {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    mFirebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success");
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                updateUI(null);
            }

            // ...
        }
    });

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mBinding.fieldEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mBinding.fieldEmail.setError("Required.");
            valid = false;
        } else {
            mBinding.fieldEmail.setError(null);
        }

        String password = mBinding.fieldPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mBinding.fieldPassword.setError("Required.");
            valid = false;
        } else {
            mBinding.fieldPassword.setError(null);
        }

        return valid;
    }
}
    */


/**
 loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
 .get(LoginViewModel.class);

 //database stuff
 FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
 FirebaseUser user = firebaseAuth.getCurrentUser();
 //checks if user logged in or not
 if(user != null)
 {
 finish();
 startActivity(new Intent(LoginActivity.this, MainActivity.class));
 }
 */
        /* If the user is logged in then go to the main page and skip the login.
           May not be necessary for this project, but good to have for testing*/
//end database stuff
/**
 final EditText username = findViewById(R.id.username);
 final EditText password = findViewById(R.id.password);
 final Button loginButton = findViewById(R.id.login);
 final ProgressBar loadingProgressBar = findViewById(R.id.loading);

 loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
@Override
public void onChanged(@Nullable LoginFormState loginFormState) {
if (loginFormState == null) {
return;
}
loginButton.setEnabled(loginFormState.isDataValid());
if (loginFormState.getUsernameError() != null) {
username.setError(getString(loginFormState.getUsernameError()));
}
if (loginFormState.getPasswordError() != null) {
password.setError(getString(loginFormState.getPasswordError()));
}
}
});

 loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
@Override
public void onChanged(@Nullable LoginResult loginResult) {
if (loginResult == null) {
return;
}
loadingProgressBar.setVisibility(View.GONE);
if (loginResult.getError() != null) {
showLoginFailed(loginResult.getError());
}
if (loginResult.getSuccess() != null) {
updateUiWithUser(loginResult.getSuccess());
}
setResult(Activity.RESULT_OK);
Intent intent = new Intent(LoginActivity.this, MainActivity.class);
startActivity(intent);
//Complete and destroy login activity once successful
//finish();
}
});

 TextWatcher afterTextChangedListener = new TextWatcher() {
@Override
public void beforeTextChanged(CharSequence s, int start, int count, int after) {
// ignore
}

@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
// ignore
}

@Override
public void afterTextChanged(Editable s) {
loginViewModel.loginDataChanged(username.getText().toString(),
password.getText().toString());
}
};
 username.addTextChangedListener(afterTextChangedListener);
 password.addTextChangedListener(afterTextChangedListener);
 password.setOnEditorActionListener(new TextView.OnEditorActionListener() {

@Override
public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
if (actionId == EditorInfo.IME_ACTION_DONE) {
loginViewModel.login(username.getText().toString(),
password.getText().toString());
}
return false;
}
});

 loginButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
loadingProgressBar.setVisibility(View.VISIBLE);
loginViewModel.login(username.getText().toString(),
password.getText().toString());
//maybe intent goes here
//Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//startActivity(intent);
}
});
 }
 */

/**
 private void updateUiWithUser(LoggedInUserView model) {
 String welcome = getString(R.string.welcome) + model.getDisplayName();

 // TODO : initiate successful logged in experience
 Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();


 }

 private void showLoginFailed(@StringRes Integer errorString) {
 Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
 }
 */

