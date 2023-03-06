package com.example.androidquiz1

import android.R.attr.password
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidquiz1.databinding.FragmentLoginBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private val viewModel: FirstViewModel by viewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view =  inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        //val btnSignup = view?.findViewById<MaterialButton>(R.id.btn_signup1)
        //val userLogin = view?.findViewById<EditText>(R.id.loginUserEt)
        //val passwordLogin = view?.findViewById<EditText>(R.id.passwordUserEt)

        binding.btnSignup1.setOnClickListener {

            val inputUser = binding.loginUserEt.text.toString()
            val inputPassword = binding.passwordUserEt.text.toString()

            val bundle = Bundle()

            bundle.putString("User", inputUser)
            bundle.putString("Pass", inputPassword)
            val fragment = SignupFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.Id_fragmentContainer, fragment)
                ?.commit()
        }
        val args = this.arguments
//        val inputUser3 = args?.get("User2")
//        val inputPassword3 = args?.get("Pass2")

        viewModel.saveUsernameAndPassword(args?.getString("User2").toString(),args?.getString("Pass2").toString())
        if (args?.getString("User2")!=null){



            binding.loginUserEt.setText(viewModel._username.value.toString())
            binding.passwordUserEt.setText(viewModel._password.value.toString())
        }







        return binding.root
    }


}