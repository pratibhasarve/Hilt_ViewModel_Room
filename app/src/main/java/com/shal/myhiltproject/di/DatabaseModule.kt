package com.shal.myhiltproject.di

import android.content.Context
import androidx.room.Room
import com.shal.myhiltproject.db.Note
import com.shal.myhiltproject.db.NoteDao
import com.shal.myhiltproject.db.NoteDatabase
import com.shal.myhiltproject.db.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context.applicationContext, NoteDatabase::class.java, "notes_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(database: NoteDatabase): NoteDao {
        return database.noteDao()
    }

}