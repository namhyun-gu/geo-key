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
package dev.namhyun.geokey.util

import com.naver.maps.geometry.LatLng
import dev.namhyun.geokey.model.Document
import dev.namhyun.geokey.model.Key

object KeyUtil {

    fun collectNearKeys(keys: List<Document<Key>>): Map<LatLng, List<Document<Key>>> {
        val nearKeys: MutableMap<LatLng, MutableList<Document<Key>>> = mutableMapOf()
        for (key in keys.iterator()) {
            val latLngs = nearKeys.keys
            if (latLngs.isEmpty()) {
                nearKeys[key.value.latLng] = mutableListOf(key)
            } else {
                var hasNearKey = false
                var nearKey: LatLng? = null
                for (latLng in latLngs.iterator()) {
                    if (latLng.nearBounds(30.0).contains(key.value.latLng)) {
                        hasNearKey = true
                        nearKey = latLng
                        break
                    }
                }
                if (hasNearKey) {
                    nearKeys[nearKey!!]!!.add(key)
                } else {
                    nearKeys[key.value.latLng] = mutableListOf(key)
                }
            }
        }
        return nearKeys
    }
}
