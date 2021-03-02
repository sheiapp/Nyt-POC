package com.example.nytpoc.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.nytpoc.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
@Module
@InstallIn(ApplicationComponent::class)
object ViewModule {
    @Singleton
    @Provides
    fun initGlide(@ApplicationContext appContext: Context): RequestManager = Glide.with(appContext)
        .setDefaultRequestOptions(
            RequestOptions()
                .error(R.drawable.ic_launcher_foreground)
        )
}