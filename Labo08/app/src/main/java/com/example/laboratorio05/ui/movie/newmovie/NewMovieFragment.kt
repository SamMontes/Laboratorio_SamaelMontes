package com.example.laboratorio05.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.databinding.FragmentNewMovieBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class NewMovieFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentNewMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getMovies().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(MovieViewModel.WRONG_DATA) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }
            }
        }
    }

    private fun createMovie(){
        //viewModel.addMovies(newMovie)

        Log.d("APP TAG", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }
}