package com.example.pdammvp.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pdammvp.R
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import com.example.pdammvp.view.login.LoginActivity
import com.facebook.AccessToken
import com.facebook.FacebookSdk
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.json.JSONException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.google.android.material.bottomnavigation.BottomNavigationView


public class HomeActivity : AppCompatActivity() {

    public val GOOGLE_ACCOUNT: String = "google_account"
    lateinit var googleSignInClient: GoogleSignInClient
    lateinit var mGoogle: GoogleSignInOptions
    var name: String? = ""
    var email: String? = ""
    var image: String? = ""

    private val mOnNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.btn_home -> {
                Toast.makeText(this@HomeActivity, "home", Toast.LENGTH_LONG).show()
                return@OnNavigationItemSelectedListener true
            }

            R.id.btn_history -> {
                Toast.makeText(this@HomeActivity, "history", Toast.LENGTH_LONG).show()
                return@OnNavigationItemSelectedListener true
            }

            R.id.btn_exit -> {
                Toast.makeText(this@HomeActivity, "exit", Toast.LENGTH_LONG).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        FacebookSdk.sdkInitialize(getApplicationContext())

        initIntent()
        initLayout()
    }

    private fun initIntent() {

        var googleSignInAccount: GoogleSignInAccount? = intent.getParcelableExtra("Google")

        if (googleSignInAccount != null) {
            name = googleSignInAccount?.displayName
            email = googleSignInAccount?.email
            image = (googleSignInAccount?.photoUrl).toString()
        } else {
            name = intent.getStringExtra("name")
            email = intent.getStringExtra("email")
            image = intent.getStringExtra("image")
        }
    }

    private fun initLayout() {

        mGoogle = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.id_token))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, mGoogle)

        Glide.with(this)
            .load(image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(img_avatar)

        tv_name.text = name
        tv_email.text = email

        btn_logout.setOnClickListener {
            googleSignInClient.signOut().addOnCompleteListener {
                //On Succesfull signout we navigate the user back to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
            LoginManager.getInstance().logOut()
        }

        nav_home.setOnNavigationItemSelectedListener(mOnNavigationItemSelected)

    }

}
