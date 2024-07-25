package com.wax.tempocabocloapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.wax.tempocabocloapp.adapters.WeatherDataAdapter
import com.wax.tempocabocloapp.data.CurrentLocation
import com.wax.tempocabocloapp.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val weatherDataAdapter = WeatherDataAdapter(
        onLocationClicked = {
            Toast.makeText(requireContext(), "onLocationClicked()", Toast.LENGTH_SHORT).show()
            setWeatherData()
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWeatherDataAdapter()
        setWeatherData()
    }

    private fun setWeatherDataAdapter(){
        binding.weatherDataRecyclerView.adapter = weatherDataAdapter
    }

    private fun setWeatherData() {
        weatherDataAdapter.setData(data = listOf(CurrentLocation(date = getCurrentDate())))
    }

    private fun getCurrentDate(): String {
        val currentData = Date()
        val formatter = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
        return "Today, ${formatter.format(currentData)}"
    }

}