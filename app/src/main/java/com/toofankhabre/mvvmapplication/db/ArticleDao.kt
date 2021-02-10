package com.toofankhabre.mvvmapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.toofankhabre.mvvmapplication.Response.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upInsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticles(article: Article)
}