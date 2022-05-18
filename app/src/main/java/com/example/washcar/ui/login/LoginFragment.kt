package com.example.washcar.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.washcar.R
import com.example.washcar.api.auth.model.LoginResponse
import com.example.washcar.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sessionManager: SessionManager

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        auth = Firebase.auth

        sessionManager = SessionManager(requireContext())

        binding.goToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment)
        }




        return binding.root

    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            //reload();
        }
    }

    private fun reload() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading

        loginViewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                loginButton.isEnabled = loginFormState.isDataValid
                loginFormState.usernameError?.let {
                    usernameEditText.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    passwordEditText.error = getString(it)
                }
            })

        loginViewModel.loginResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer
                loadingProgressBar.visibility = View.GONE
                showLoginFailed(loginResult.error)
                loginResult.success?.let {
                    updateUiWithUser(it)
                    saveAccessToken(it.accessToken)

                }
            })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
        usernameEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
            false
        }

        loginButton.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            loginViewModel.login(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
            //findNavController().navigate(R.id.action_loginFragment2_to_blankFragment)
            loginViewModel.loginStatus.observe(viewLifecycleOwner, Observer {
                if (it){
                    Log.i("loginStatus", "$it")
                    findNavController().navigate(R.id.action_loginFragment2_to_blankFragment)
                    loginViewModel.setStatusFalse()

                }
                Log.i("loginStatus", "$it")
            })
//            if(loginViewModel.loginStatus.value == true){
//                findNavController().navigate(R.id.action_loginFragment2_to_blankFragment)
//            }



            //signIn(usernameEditText.text.toString(), passwordEditText.text.toString())


        }
    }

    private fun signInWithFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(
            email, password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")

                val user = auth.currentUser

                user?.getIdToken(true)?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val idToken: String? = task.result.token
                            // Send token to your backend via HTTPS
                            // ...

                            //incluir o retrofit para mandar o token para a API Node.js
                           // Log.i("token", "$idToken")
                       } else {
                          // Handle error -> task.getException();
                        }
                }

//

                updateUI(user)

                //codigo para ir para a poxima UI autenticado

            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)

                updateUI(null)
            }
        }
    }
    private fun signIn(email: String, password: String) {
        loginViewModel.login(email,password)
        loginViewModel.loginResult.observe(viewLifecycleOwner, Observer {
            //findNavController().navigate(R.id.action_loginFragment2_to_blankFragment)
        })


    }

    // Nao usar, pq para qualquer usuario digitado ele eh dado como aceito
    private fun updateUiWithUser(model: LoginResponse) {
        val welcome = getString(R.string.welcome)
        // TODO : initiate successful logged in experience
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()


    }

    private fun saveAccessToken(token: String) {
        Log.i("token", "$token")
        sessionManager.saveAuthToken(token)

    }

    private fun updateUI(user: FirebaseUser?) {
        Toast.makeText(
            requireActivity(), "Authentication sucess. ${user?.email}",
            Toast.LENGTH_SHORT
        ).show()
        if (user == null) {
            Toast.makeText(
                requireActivity(), "Authentication failed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun showLoginFailed(errorString: String) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private const val TAG = "EmailPassword"
    }
}