package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Album
import com.example.myapplication.model.dataSource

class AlbumViewModel() : ViewModel() {

    var genre = MutableLiveData("")
    var id = MutableLiveData(0)
    private var listRock = dataSource.listRock

    fun listAlbum(genre: String): MutableList<Album> {
        return when (genre) {
            "Rock" -> listRock
            "Jazz" -> dataSource.listJazz
            "Blues" -> dataSource.listBlues
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