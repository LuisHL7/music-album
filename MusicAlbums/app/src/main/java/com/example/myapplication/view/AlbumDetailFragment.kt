package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAlbumDetailBinding
import com.example.myapplication.model.Album
import com.example.myapplication.model.IMAGE_NO_AVALIABLE_RESOURCE
import com.example.myapplication.viewModel.AlbumViewModel

class AlbumDetailFragment : Fragment() {
    private var _binding: FragmentAlbumDetailBinding? = null
    private val binding get() = _binding!!
    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlbumDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            albumViewModel.id.observe(viewLifecycleOwner){ id ->
                val album:Album? = albumViewModel.detailAlbum(id,albumViewModel.listAlbum(albumViewModel.genre.value!!))
                binding.tvTitle.text = getString(R.string.title_author, album?.titulo, album?.autor)
                binding.imageMusic.setImageResource(album?.imageRes ?: IMAGE_NO_AVALIABLE_RESOURCE)
                binding.tvDescription.setText(album?.descRes!!)

                binding.btnRemove.setOnClickListener {
                    albumViewModel.listAlbum(albumViewModel.genre.value!!).remove(album)
                    findNavController().popBackStack()
                }
            }



    }

}