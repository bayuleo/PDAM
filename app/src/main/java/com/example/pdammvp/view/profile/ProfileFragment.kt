package com.example.pdammvp.view.profile

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import com.example.pdammvp.R
import com.example.pdammvp.databinding.FragmentProfileBinding
import com.example.pdammvp.view.login.LoginActivity
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class ProfileFragment : Fragment() {

    private lateinit var mBinding: FragmentProfileBinding

    lateinit var googleSignInClient: GoogleSignInClient
    lateinit var mGoogle: GoogleSignInOptions
    var name: String? = ""
    var email: String? = ""
    var image: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        initIntent()
        initLayout()

        return mBinding.root
    }

    private fun initIntent() {
        var googleSignInAccount: GoogleSignInAccount? = activity?.intent?.getParcelableExtra("Google")

        if (googleSignInAccount != null) {
            name    = googleSignInAccount?.displayName
            email   = googleSignInAccount?.email
            image   = (googleSignInAccount?.photoUrl).toString()
        } else {
            name    = activity?.intent?.getStringExtra("name")
            email   = activity?.intent?.getStringExtra("email")
            image   = activity?.intent?.getStringExtra("image")
        }
    }

    private fun initLayout() {

        mGoogle = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.id_token))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), mGoogle)

        Glide.with(this)
            .load(image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(mBinding.imgAvatar)

        mBinding.tvName.text = name
        mBinding.tvEmail.text = email

        mBinding.btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setIcon(R.drawable.ic_info)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    logout()
                })
                .setNegativeButton("cancel", null)
                .show()
        }
    }

    fun logout(){
        googleSignInClient.signOut().addOnCompleteListener {
            //On Succesfull signout we navigate the user back to LoginActivity
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        LoginManager.getInstance().logOut()
    }
}
