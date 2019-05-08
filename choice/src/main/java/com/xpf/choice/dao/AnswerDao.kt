package com.xpf.choice.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.xpf.choice.model.Answer

@Dao
interface AnswerDao {

    @Query("SELECT * FROM answer")
    fun getAnswers(): List<Answer>

    @Insert
    fun insert(answer: Answer)
}