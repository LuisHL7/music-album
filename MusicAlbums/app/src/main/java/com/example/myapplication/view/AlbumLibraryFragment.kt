package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
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

        with(binding.spGenero) {
            adapter = adapter()

            setSelection(0, false)
            onItemSelectedListener = objectListener()

            binding.btnIr.setOnClickListener { onClick() }
        }
    }

    private fun adapter(): SpinnerAdapter = ArrayAdapter(
        requireContext(),
        android.R.layout.simple_list_item_1,
        arrayOf(
            "",
            *Album.Genre.values()
        ) // recoge los valores del array y almacena sus valores
    ).apply { setDropDownViewResource(R.layout.item_spinner) }


    private fun objectListener(): AdapterView.OnItemSelectedListener =
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: AdapterView<*>?, v: View, position: Int, id: Long) {
                if (position == 0) noSelectionSpinner()
                else showButton()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    private fun showButton() {
        binding.btnIr.visibility = View.VISIBLE
    }

    private fun noSelectionSpinner() {
        binding.btnIr.visibility = View.INVISIBLE
    }

    private fun onClick() {
        albumViewModel.albumList.postValue(
            when (binding.spGenero.selectedItemPosition) {
                1 -> albumViewModel.listByGenre(Album.Genre.Rock)
                2 -> albumViewModel.listByGenre(Album.Genre.Blues)
                3 -> albumViewModel.listByGenre(Album.Genre.Jazz)
                else -> genreNotValid()
            }
        )
        findNavController().navigate(AlbumLibraryFragmentDirections.actionFirstFragmentToSecondFragment())
    }

    private fun genreNotValid(): Nothing = throw RuntimeException("Option incorrectly")

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}