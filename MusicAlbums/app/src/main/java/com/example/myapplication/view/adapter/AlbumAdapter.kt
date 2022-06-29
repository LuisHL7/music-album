package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.model.Album
import com.example.myapplication.viewModel.AlbumViewModel

class AlbumAdapter(private val albumList: MutableLiveData<MutableList<Album>>, private val albumViewModel: AlbumViewModel) : RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) = holder.render(albumList.value!![position], albumViewModel)


    override fun getItemCount(): Int = albumList.value!!.size

}