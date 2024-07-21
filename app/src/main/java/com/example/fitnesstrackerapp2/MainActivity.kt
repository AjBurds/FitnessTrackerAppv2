package com.example.fitnesstrackerapp2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnesstrackerapp2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Setup RecyclerView
        val adapter = HistoryAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.historyItems.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        // Setup Navigation
        try {
            val navController = findNavController(R.id.nav_host_fragment)
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNavigationView.setupWithNavController(navController)

            // Always show selected Bottom Navigation item as selected
            bottomNavigationView.setOnItemSelectedListener { item ->
                // Call default Navigation method manually
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }

            // Observe destination changes to show/hide RecyclerView
            navController.addOnDestinationChangedListener { _, destination, _ ->
                binding.recyclerView.visibility = if (destination.id == R.id.navigation_history) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        } catch (e: IllegalStateException) {
            Log.e("MainActivity", "Error finding NavController", e)
        }
    }
}
