package com.example.iceandfire.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterResponse(

    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("culture")
    @Expose
    var culture: String? = null,
    @SerializedName("born")
    @Expose
    var born: String? = null,
    @SerializedName("died")
    @Expose
    var died: String? = null,
    @SerializedName("titles")
    @Expose
    var titles: List<Any>? = null,
    @SerializedName("aliases")
    @Expose
    var aliases: List<String>? = null,
    @SerializedName("father")
    @Expose
    var father: String? = null,
    @SerializedName("mother")
    @Expose
    var mother: String? = null,
    @SerializedName("spouse")
    @Expose
    var spouse: String? = null,
    @SerializedName("allegiances")
    @Expose
    var allegiances: List<String>? = null,
    @SerializedName("books")
    @Expose
    var books: List<String>? = null,
    @SerializedName("povBooks")
    @Expose
    var povBooks: List<Any>? = null,
    @SerializedName("tvSeries")
    @Expose
    var tvSeries: List<String>? = null,
    @SerializedName("playedBy")
    @Expose
    var playedBy: List<String>? = null
)
