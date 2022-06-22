package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Album
import com.example.myapplication.model.dataSource

class AlbumViewModel : ViewModel() {

    val albumModel = MutableLiveData<Album>()
    var genre = MutableLiveData<Album.Genero>()
    var id = MutableLiveData(0)

    fun listAlbum(genre: Album.Genero): MutableList<Album> {
        return when (genre) {
            Album.Genero.Rock -> dataSource.listaRock
            Album.Genero.Jazz -> dataSource.listaJazz
            Album.Genero.Blues -> dataSource.listaBlues
            else -> throw RuntimeException("Option undefined")
        }
    }


    fun detailAlbum(id: Int, list: MutableList<Album>): Album? {
        for (i in 0 until list.size) {
            if (list[i].id == id) {
                return list[i]
            }
        }
        return null
    }
}