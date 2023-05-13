package com.example.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.category
import com.example.laboratorio05.data.description
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.data.movies
import com.example.laboratorio05.data.name
import com.example.laboratorio05.data.qualification
import com.example.laboratorio05.databinding.FragmentMovieBinding
import com.example.laboratorio05.databinding.MovieItemBinding
import com.example.laboratorio05.repository.MovieRepository
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewHolder
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class MovieFragment : Fragment() {
    private val ViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewMovie()
    }

    private fun setViewMovie(){
        binding.viewmodel = ViewModel
        binding.imageView.setOnClickListener {
            Toast.makeText(requireContext(), "Movie", Toast.LENGTH_SHORT).show()
        }
    }
}