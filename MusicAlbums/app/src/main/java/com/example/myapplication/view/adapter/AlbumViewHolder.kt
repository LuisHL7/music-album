package com.example.myapplication.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.model.Album
import com.example.myapplication.model.IMAGE_NO_AVALIABLE_RESOURCE

class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemListBinding.bind(view)

    fun render(album: Album) {
        binding.imageMusic.setImageResource(album.imageRes ?: IMAGE_NO_AVALIABLE_RESOURCE)
        binding.tvTitle.text = album.titulo
        binding.tvAuthor.text = album.autor
    }
}