/*
 * Copyright 2020 Namhyun, Gu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.namhyun.geokey.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.namhyun.geokey.data.LocationDataSource
import dev.namhyun.geokey.data.LocationDataSourceImpl
import dev.namhyun.geokey.data.NetworkStateDataSource
import dev.namhyun.geokey.data.NetworkStateDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLocationDataSource(@ApplicationContext context: Context): LocationDataSource {
        return LocationDataSourceImpl(context)
    }

    @Provides
    @Singleton
    fun provideNetworkStateDataSource(@ApplicationContext context: Context): NetworkStateDataSource {
        return NetworkStateDataSourceImpl(context)
    }
}
