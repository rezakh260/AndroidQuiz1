package com.example.androidquiz1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidquiz1.databinding.FragmentSignupBinding
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private val viewModel: FirstViewModel by viewModels()
    private lateinit var binding: FragmentSignupBinding
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
        //val view= inflater.inflate(R.layout.fragment_signup, container, false)
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        //val btnSignup2 = view?.findViewById<MaterialButton>(R.id.btn_signup2)
        //val userSignup = view?.findViewById<EditText>(R.id.signupUserEt)
        //val passwordSignup = view?.findViewById<EditText>(R.id.signupPasswordEt)

        val args = this.arguments
        val inputUser = args?.get("User")
        val inputPassword = args?.get("Pass")

        binding.signupUserEt.setText(inputUser.toString())
        binding.signupPasswordEt.setText(inputPassword.toString())


        binding.btnSignup2.setOnClickListener {


            if (binding.signupUserEt.text.toString()
                    .isEmpty() || binding.signupPasswordEt.text.toString().isEmpty()
            ) {
                Toast.makeText(context, "Please Insert Username and Password", Toast.LENGTH_SHORT)
                    .show()
            }
            else{


            val bundle = Bundle()
            val inputUser2 = binding.signupUserEt.text.toString()
            val inputPassword2 = binding.signupPasswordEt.text.toString()
            bundle.putString("User2", inputUser2)
            bundle.putString("Pass2", inputPassword2)

            val fragment2 = LoginFragment()
            fragment2.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.Id_fragmentContainer, fragment2)
                ?.commit()
            }
        }



        return binding.root
    }


}