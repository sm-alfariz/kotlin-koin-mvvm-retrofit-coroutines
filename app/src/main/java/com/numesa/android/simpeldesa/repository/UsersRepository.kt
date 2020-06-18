/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 11:40 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/18/20 11:40 PM
 ************************************************/

package com.numesa.android.simpeldesa.repository

import com.numesa.android.simpeldesa.api.requests.UserServices

class UsersRepository(private val userServices: UserServices) {
    suspend fun repoGetListUsers() = userServices.listUsers()
}