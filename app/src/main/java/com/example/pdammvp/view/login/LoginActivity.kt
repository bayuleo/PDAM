package com.example.pdammvp.view.login

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.example.pdammvp.R
import com.example.pdammvp.view.home.HomeActivity
import com.facebook.*
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginResult
import java.util.*
import com.facebook.AccessToken






class LoginActivity : AppCompatActivity(), LoginContract.View {

    //login google
    lateinit var mGoogle: GoogleSignInOptions
    lateinit var mGoogleSign: GoogleSignInClient

    //login facebook
    lateinit var callbackManager: CallbackManager
    lateinit var accessToken: AccessToken

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        initLayout()


        //Check already login using google
        val alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this)
        if (alreadyloggedAccount != null){
            openHomePageWithGoogle(alreadyloggedAccount)
        }

        //Check already login using facebook
        val accessToken = AccessToken.getCurrentAccessToken()
        if (accessToken != null){
            openHomePageWithFacebook(accessToken)
        }
    }

    private fun initLayout() {

        setupGoogle()
        setupFacebook()

    }

    private fun setupFacebook() {
        callbackManager = CallbackManager.Factory.create()

        btn_login_facebook.setReadPermissions(Arrays.asList("email", "public_profile"))
        btn_login_facebook.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult?) {
                    val accessToken = result?.getAccessToken()
                    openHomePageWithFacebook(accessToken)
                }

                override fun onCancel() {
                }

                override fun onError(error: FacebookException?) {
                }

            })
    }

    private fun setupGoogle() {
        mGoogle = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.id_token))
            .requestEmail()
            .build()

        mGoogleSign = GoogleSignIn.getClient(this, mGoogle)
        btn_login_google.setOnClickListener {
            val signInIntent = mGoogleSign.getSignInIntent()
            startActivityForResult(signInIntent, 101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            when (requestCode) {
                101 -> try {
                    var task: Task<GoogleSignInAccount> =
                        GoogleSignIn.getSignedInAccountFromIntent(data)
                    val account = task.getResult(ApiException::class.java)
                    openHomePageWithGoogle(account)
                } catch (e: ApiException) {

                }
                64206 -> {
                    callbackManager.onActivityResult(requestCode, resultCode, data);
                }
            }
    }


    private fun openHomePageWithGoogle(account: GoogleSignInAccount?) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("Google", account)
        startActivity(intent)
        finish()
    }

    private fun openHomePageWithFacebook(token: AccessToken?) {
        val profile = Profile.getCurrentProfile()
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        intent.putExtra("name", profile.name)
        intent.putExtra("email", profile.id.toString())
        intent.putExtra("image", (profile.getProfilePictureUri(200, 200)).toString())
        startActivity(intent)
        finish()
    }

    override fun onSuccessLogin() {

    }

    override fun onFailedLogin() {

    }

}
