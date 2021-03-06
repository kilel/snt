/*
 * Copyright 2018 Kislitsyn Ilya
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.github.snt.ui.javafx.controller

import org.github.snt.dao.api.Dao
import org.github.snt.ui.javafx.lib.showError
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

open class AbstractController {
    val log = LoggerFactory.getLogger(javaClass)!!

    @Autowired(required = false)
    lateinit var dao: Dao

    fun onError(error: Throwable) {
        log.error("Unexpected UI error", error)
        showError(error)
    }
}
