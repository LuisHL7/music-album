package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
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
            Album.Genero.values()
        ).apply { setDropDownViewResource(R.layout.item_spinner) }

        binding.spGenero.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                albumViewModel.genre.postValue( when(position){
                    0 -> "Rock"
                    1 -> "Blues"
                    2 -> "Jazz"
                    else -> throw RuntimeException("Option incorrectly")
                })
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        binding.btnIr.setOnClickListener {
            findNavController().navigate(AlbumLibraryFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}