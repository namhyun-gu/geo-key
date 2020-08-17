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
package dev.namhyun.geokey.data.remote

import dev.namhyun.geokey.model.GeocodingResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GeocodingService {

    @GET("map-reversegeocode/v2/gc")
    suspend fun reverseGeocode(
      @Header("X-NCP-APIGW-API-KEY-ID") clientId: String,
      @Header("X-NCP-APIGW-API-KEY") clientSecret: String,
      @Query("coords") coords: String,
      @Query("orders") orders: String = "roadaddr,legalcode,admcode",
      @Query("output") output: String = "json"
    ): GeocodingResponse
}