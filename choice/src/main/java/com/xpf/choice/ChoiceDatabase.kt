package com.xpf.choice

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.xpf.choice.dao.AnswerDao
import com.xpf.choice.dao.QuestionDao
import com.xpf.choice.model.Answer
import com.xpf.choice.model.Question

@Database(entities = arrayOf(
        Question::class,
        Answer::class),
        version = 3)
abstract class ChoiceDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao
}