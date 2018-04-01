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

package org.github.snt.api.dao.repo

import org.github.snt.api.User
import org.github.snt.api.dao.DaoRepo
import org.github.snt.api.dao.repo.crud.UserCrudRepo
import org.github.snt.api.dao.filter.BaseFilter

interface UserRepo : DaoRepo<User, BaseFilter> {
    override fun getCrudRepo(): UserCrudRepo

    /**
     * Load user by code.
     */
    fun loadByCode(code: String) = loadOne(BaseFilter(code.trim()))

    /**
     * Creates new user with predefined password
     */
    fun createNewUser(user: User, password: String)

}