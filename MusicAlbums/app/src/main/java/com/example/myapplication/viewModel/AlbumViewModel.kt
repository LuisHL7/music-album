package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Album
import com.example.myapplication.model.DataSource


class AlbumViewModel : ViewModel() {

    val albumModel = MutableLiveData<Album>()
    val albumList = MutableLiveData<MutableList<Album>>()
    var genre = MutableLiveData<Album.Genre>()
    var id = MutableLiveData(0)

    fun getAlbumList(genre: Album.Genre): MutableLiveData<MutableList<Album>> {
        return when (genre) {
            Album.Genre.Rock -> listByGenre(genre)
            Album.Genre.Jazz -> listByGenre(genre)
            Album.Genre.Blues -> listByGenre(genre)
            else -> throw RuntimeException("Option undefined")
        }
    }

    private fun listByGenre(genre: Album.Genre): MutableLiveData<MutableList<Album>> {
        val list = mutableListOf<Album>()
        for (i in 0 until DataSource.listAlbum.size) {
            if (DataSource.listAlbum[i].genre == genre) {
                list.add(DataSource.listAlbum[i])
            }
        }
        albumList.value = list
        return albumList
    }

    fun detailAlbum(id: Int, list: MutableList<Album>): Album? {
        for (i in 0 until list.size) {
            if (list[i].id == id) {
                return list[i]
            }
        }
        return null
    }

    fun reset(){
        albumList.value = DataSource.listAlbum
    }
}