package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Album
import com.example.myapplication.model.DataSource
import com.example.myapplication.model.getList


class AlbumViewModel : ViewModel() {


    val albumModel = MutableLiveData<Album>()
    val albumList = MutableLiveData<MutableList<Album>>()

    private fun loadList() {
        albumList.value = DataSource.listAlbum
    }

    fun listByGenre(genre: Album.Genre): MutableList<Album> {
        loadList()
        val list = mutableListOf<Album>()
        for (i in 0 until albumList.value!!.size) {
            if (albumList.value!![i].genre == genre) {
                list.add(albumList.value!![i])
            }
        }
        albumList.value = list
        return albumList.value!!
    }

    fun removeAlbum(album: Album) {
        albumList.value!!
            .apply {
                remove(album)
                DataSource.listAlbum.remove(album)
            }
    }

    fun reset() {
        DataSource.listAlbum = getList()
    }
}