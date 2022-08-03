package ru.dsvusial.badhabitsdestroyer.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dsvusial.badhabitsdestroyer.R
import ru.dsvusial.badhabitsdestroyer.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //initialization of binding, get access to view root
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


}