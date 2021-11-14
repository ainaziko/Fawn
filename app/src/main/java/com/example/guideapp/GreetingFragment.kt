package com.example.guideapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.guideapp.databinding.FragmentGreetingBinding

class GreetingFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentGreetingBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_greeting, container, false)
        binding.exploreButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_greetingFragment_to_mainFragment))
        // Inflate the layout for this fragment
        return binding.root
    }

}