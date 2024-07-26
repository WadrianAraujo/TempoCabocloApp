package com.wax.tempocabocloapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wax.tempocabocloapp.data.CurrentLocation
import com.wax.tempocabocloapp.data.WeatherData
import com.wax.tempocabocloapp.databinding.ItemContainerCurrentLocationBinding

class WeatherDataAdapter(
    private val onLocationClicked: () -> Unit
) : RecyclerView.Adapter<WeatherDataAdapter.CurrentLocationViewHolder>() {

    private companion object {
        const val INDEX_CURRENT_LOCATION = 0
        const val INDEX_CURRENT_WEATHER = 1
        const val INDEX_FORECAST = 2
    }

    private val weatherData = mutableListOf<WeatherData>()

    fun setCurrentLocation(currentLocation: CurrentLocation) {
        if (weatherData.isEmpty()){
            weatherData.add(INDEX_CURRENT_LOCATION, currentLocation)
            notifyItemInserted(INDEX_CURRENT_LOCATION)
        }else{
            weatherData[INDEX_CURRENT_LOCATION] = currentLocation
            notifyItemChanged(INDEX_CURRENT_LOCATION)
        }
    }

    inner class CurrentLocationViewHolder(
        private val binding: ItemContainerCurrentLocationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentLocation: CurrentLocation) {
            binding.textCurrentDate.text = currentLocation.date
            binding.textCurrentLocation.text = currentLocation.location
            binding.imageCurrentLocation.setOnClickListener {
                onLocationClicked()
            }
            binding.imageLocation.setOnClickListener {
                onLocationClicked()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentLocationViewHolder {
        return CurrentLocationViewHolder(
            ItemContainerCurrentLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    override fun onBindViewHolder(holder: CurrentLocationViewHolder, position: Int) {
        holder.bind(weatherData[position] as CurrentLocation)
    }

}