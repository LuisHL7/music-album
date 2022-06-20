package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Album
import com.example.myapplication.model.dataSource

class AlbumViewModel:ViewModel() {

    val albumModel = MutableLiveData<Album>()
    var genre = MutableLiveData("")
    var listadoRock =MutableLiveData(dataSource.listaRock)

    fun listAlbum(genre: String): MutableList<Album> {
        return when (genre) {
                "Rock" ->  dataSource.listaRock
                "Jazz" ->  dataSource.listaJazz
                "Blues" -> dataSource.listaBlues
            else -> throw RuntimeException("Option undefined")
        }
    }

//    fun genre(){
//        when(Album.Genero.){
//
//        }
//        val currentGenres = dataSource.
//    }




}