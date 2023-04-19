package com.example.laboratorio05montes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var actiontoMovie: CardView
    private lateinit var actionToCreateMovie: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actiontoMovie = view.findViewById(R.id.cardViewStarWars)
        actionToCreateMovie = view.findViewById(R.id.CreateMovieButton)

        actiontoMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        actionToCreateMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
        }
    }
}