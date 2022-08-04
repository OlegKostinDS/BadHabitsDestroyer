package ru.dsvusial.badhabitsdestroyer.ui.main

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import ru.dsvusial.badhabitsdestroyer.R
import ru.dsvusial.badhabitsdestroyer.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    var running = false
    var offset: Long = 0

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.start.setOnClickListener {
            if (!running) {
                setBaseTime()
                binding.chronometer.start()
                running = true
            }
        }
        binding.stop.setOnClickListener {
            if (running) {
                saveOffset()
                binding.chronometer.stop()
                running = false
            }
        }
        binding.reset.setOnClickListener {
            offset = 0
            setBaseTime()
        }

        return view
    }

    private fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - binding.chronometer.base


    }

    private fun setBaseTime() {
        binding.chronometer.base = SystemClock.elapsedRealtime() - offset
    }
}