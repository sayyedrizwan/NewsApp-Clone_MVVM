package com.toofankhabre.mvvmapplication.db

import androidx.room.TypeConverter
import com.toofankhabre.mvvmapplication.Response.Source

class Convertors {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}