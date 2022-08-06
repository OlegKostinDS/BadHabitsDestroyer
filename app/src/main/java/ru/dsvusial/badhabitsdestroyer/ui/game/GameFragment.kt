package ru.dsvusial.badhabitsdestroyer.ui.game

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import ru.dsvusial.badhabitsdestroyer.Constants
import ru.dsvusial.badhabitsdestroyer.R
import ru.dsvusial.badhabitsdestroyer.databinding.FragmentGameBinding
import ru.dsvusial.badhabitsdestroyer.databinding.FragmentMainBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }


}