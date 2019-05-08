package com.xpf.choice.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.xpf.choice.model.Question

@Dao
interface QuestionDao {

    @Query("SELECT * FROM question")
    fun getQuestions(): List<Question>

    @Insert
    fun insert(question: Question)
}