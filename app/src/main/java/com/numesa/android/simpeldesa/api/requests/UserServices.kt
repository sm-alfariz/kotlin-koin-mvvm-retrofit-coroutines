/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 11:20 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/18/20 11:20 PM
 ************************************************/

package com.numesa.android.simpeldesa.api.requests

import com.numesa.android.simpeldesa.api.models.users.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserServices {
    @Headers("Accept: application/json")
    @GET("users")
    suspend fun listUsers(): List<UsersResponse>
}