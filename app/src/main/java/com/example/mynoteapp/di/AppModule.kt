package com.example.mynoteapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// we need to add module is add binding to hilt -> to create a room database
// Add all the bindings here to create

@InstallIn(SingletonComponent::class)
@Module
object AppModule
