package com.example.engeneering_school_test1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {//implements GoogleApiClient.OnConnectionFailedListener {

    /* Login Google */
    @BindView(R.id.loginBtn_Google) SignInButton loginBtn_Google;
    private FirebaseAuth firebase_Auth;
    private GoogleSignInClient googleSignInClient;
    private static final int REQ_SIGN_GOOGLE = 100;     // Google Result Code

    /* Button */
    @BindView(R.id.input_ID) EditText input_ID;
    @BindView(R.id.input_PW) EditText input_PW;
    @BindView(R.id.loginBtn_Basic) Button loginBtn_Basic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        /* Listener */
        loginBtn_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginBasic(input_ID.getText().toString(), input_PW.getText().toString());
            }
        });

        /* Google Login */
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        firebase_Auth = FirebaseAuth.getInstance();     // Initialization Firebase authentication object

        loginBtn_Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        /* Google End */
    }

    private void LoginBasic(String id, String pw) {
        if (id.equals("admin") || pw.equals("1234")) {
            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainLobbyActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
        }
    }

    /* Google */

    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, REQ_SIGN_GOOGLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_SIGN_GOOGLE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                Log.d("확인", "확인");
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("확인", "확인");
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"ERROR", Toast.LENGTH_SHORT).show();
            }
            Log.d("확인", "구글 요청 통과");
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("확인", "F_With_G 함수접근 확인");
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebase_Auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = firebase_Auth.getCurrentUser();
                            updateUI(user);
                            Log.d("확인", "Firebase 구글 인증 통과");
                        } else {
                            // If sign in fails, display a message to the user.

                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) { //update ui code here
        if (user != null) {
            Intent intent = new Intent(this, MainLobbyActivity.class);
            startActivity(intent);
            finish();
        }
    }
    /* End */
}
