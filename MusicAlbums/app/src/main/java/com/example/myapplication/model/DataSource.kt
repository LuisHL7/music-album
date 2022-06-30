package com.example.myapplication.model

import com.example.myapplication.R

const val IMAGE_NO_AVAILABLE_RESOURCE = R.drawable.disco


class Album(val id: Int, val title: String, val author: String, val genre: Genre, val imageRes: Int?, val descRes: Int) {
    enum class Genre { Rock, Blues, Jazz }

    override fun toString(): String {
        return "$title - $author"
    }
}

object DataSource { var listAlbum = getList() }

private var idIndex = 1

fun newAlbumIndexing(title: String, author: String, genre: Album.Genre, image: Int?, description: Int) =
    Album(++idIndex, title, author, genre, image, description)


fun getList() = mutableListOf(
    //Rock
    newAlbumIndexing("Abbey Road", "The Beatles", Album.Genre.Rock, R.drawable.abbeyroad, R.string.abbeyroad),
    newAlbumIndexing("Exile on Main Street", "The Rolling Stones", Album.Genre.Rock, R.drawable.exileonmainst, R.string.exilesonmainstreet),
    newAlbumIndexing("The Velvet Underground", "The Velvet Underground and Nico", Album.Genre.Rock, R.drawable.velvetunderground, R.string.velvetunderground),
    newAlbumIndexing("Are You Experienced", "Jimi Hendrix", Album.Genre.Rock, R.drawable.areyouexperienced, R.string.areyouexperienced),
    newAlbumIndexing("Back in Black", "AC/DC", Album.Genre.Rock, R.drawable.backinblack, R.string.backinblack),
    newAlbumIndexing("Appetite for Destruction", "Guns N’ Roses", Album.Genre.Rock, R.drawable.appetitefordestruction, R.string.appetitefordestruction),
    newAlbumIndexing("Led Zeppelin IV", "Led Zeppelin", Album.Genre.Rock, R.drawable.ledzeppeliniv, R.string.ledzeppeliniv),
    //Blues
    newAlbumIndexing("Lady Soul", "Aretha Franklin", Album.Genre.Blues, R.drawable.ladysoul, R.string.ladysoul),
    newAlbumIndexing("I Never Loved a Man the Way I Love You", "Aretha Franklin", Album.Genre.Blues, R.drawable.neverloved, R.string.ineverloveda),
    newAlbumIndexing("What's Going On", "Marvin Gaye", Album.Genre.Blues, R.drawable.whatsgoingon, R.string.whatsgoingon),
    //Jazz
    newAlbumIndexing("Kind of Blue", "Miles Davis", Album.Genre.Jazz, R.drawable.kindofblue, R.string.kindofblue),
    newAlbumIndexing("Bitches Brew", "Miles Davis", Album.Genre.Jazz, R.drawable.bitchesbrew, R.string.bitchesbrew),
    newAlbumIndexing("A Love Supreme", "John Coltrane", Album.Genre.Jazz, R.drawable.alovesupreme, R.string.alovesupreme)
)
