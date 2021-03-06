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

package org.github.snt.dao.api.repo

import org.github.snt.dao.api.DaoRepo
import org.github.snt.dao.api.entity.AuthResource
import org.github.snt.dao.api.entity.User
import org.github.snt.dao.api.filter.AuthResourceFilter
import org.github.snt.dao.api.repo.spring.AuthResourceSpringDataRepo
import org.github.snt.lib.util.AesEncryptor

interface AuthResourceRepo : DaoRepo<AuthResource, AuthResourceFilter> {
    override fun getSpringDataRepo(): AuthResourceSpringDataRepo

    /**
     * Saves main password for user.
     */
    fun saveUserPassword(user: User, password: String)

    /**
     * Tries to authenticate user by password.
     * @return Master key
     */
    fun checkPassword(user: User, password: String): ByteArray

    /**
     * Builds encryptor for defined password.
     */
    fun buildEncryptor(password: String): AesEncryptor

    /**
     * Builds encryptor for defined master key.
     */
    fun buildEncryptor(masterKey: ByteArray): AesEncryptor
}