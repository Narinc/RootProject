package com.narinc.rootproject.di

import android.content.Context
import com.narinc.rootproject.core.analytics.AppAnalytics
import com.narinc.rootproject.core.initializer.InitializerDispatcher
import com.narinc.rootproject.core.initializer.InitializerDispatcherImp
import com.narinc.rootproject.mobileservices.MobileServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerInitializerDispatcher(): InitializerDispatcher = InitializerDispatcherImp()

    @Singleton
    @Provides
    fun provideMobileService(@ApplicationContext context: Context): MobileServices =
        MobileServices(context)

    @Provides
    @Singleton
    fun provideAppAnalytics(
        @ApplicationContext context: Context,
        mobileServices: MobileServices
    ): AppAnalytics = AppAnalytics(mobileServices.getAnalyticDispatchers(context))
}
