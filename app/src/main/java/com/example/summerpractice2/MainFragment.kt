package com.example.summerpractice2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice2.databinding.FragmentMusicBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMusicBinding.bind(view)

        val fragmentToShow = arguments?.getString(FRAGMENT).orEmpty()
        Snackbar.make(view, fragmentToShow, Snackbar.LENGTH_LONG).show()

        binding.btnMain.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val FRAGMENT = "const"

        fun createBundle(frag: String): Bundle {
            val bundle = Bundle()
            bundle.putString(FRAGMENT, frag)
            return bundle
        }
    }
}