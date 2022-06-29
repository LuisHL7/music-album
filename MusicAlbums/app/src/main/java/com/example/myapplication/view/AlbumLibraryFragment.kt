package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAlbumLibraryBinding
import com.example.myapplication.model.Album
import com.example.myapplication.viewModel.AlbumViewModel


class AlbumLibraryFragment : Fragment() {
    private var _binding: FragmentAlbumLibraryBinding? = null
    private val binding get() = _binding!!
    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlbumLibraryBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spGenero.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            arrayOf("", *Album.Genre.values()) // recoge los valores del array y almacena sus valores
        ).apply { setDropDownViewResource(R.layout.item_spinner) }



        binding.btnIr.setOnClickListener {
            albumViewModel.genre.postValue(
                when (binding.spGenero.selectedItemPosition) {
                    1 -> Album.Genre.Rock
                    2 -> Album.Genre.Blues
                    3 -> Album.Genre.Jazz
                    else -> genderNotValid()
                }
            )
            findNavController().navigate(AlbumLibraryFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }

    private fun genderNotValid(): Nothing = throw RuntimeException("Option incorrectly")

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}