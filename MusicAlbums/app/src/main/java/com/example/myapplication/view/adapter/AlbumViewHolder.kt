package com.example.myapplication.view.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.model.Album
import com.example.myapplication.model.IMAGE_NO_AVALIABLE_RESOURCE
import com.example.myapplication.view.AlbumListFragmentDirections
import com.example.myapplication.viewModel.AlbumViewModel

class AlbumViewHolder(view: ItemListBinding) : RecyclerView.ViewHolder(view.root) {
    private val bindingItem = ItemListBinding.bind(view.root)
    private val binding = view.root

    fun render(album: Album, albumViewModel: AlbumViewModel) {
        bindingItem.imageMusic.setImageResource(album.imageRes ?: IMAGE_NO_AVALIABLE_RESOURCE)
        bindingItem.tvTitle.text = album.titulo
        bindingItem.tvAuthor.text = album.autor

        itemView.setOnClickListener {
            albumViewModel.id.postValue(album.id)
            binding.findNavController().navigate(AlbumListFragmentDirections.actionSecondFragmentToAlbumDetailFragment())
        }

    }
}