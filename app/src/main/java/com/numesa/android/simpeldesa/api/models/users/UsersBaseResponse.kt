/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 11:30 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/18/20 11:30 PM
 ************************************************/

package com.numesa.android.simpeldesa.api.models.users

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String? = null,
    @SerializedName("username") val username : String? = null,
    @SerializedName("email") val email : String? = null,
    @SerializedName("address") val address : Address,
    @SerializedName("phone") val phone : String? = null,
    @SerializedName("website") val website : String? = null,
    @SerializedName("company") val company : Company
)
data class Geo (

    @SerializedName("lat") val lat : Double? = null,
    @SerializedName("lng") val lng : Double? = null
)
data class Company (

    @SerializedName("name") val name : String? = null,
    @SerializedName("catchPhrase") val catchPhrase : String? = null,
    @SerializedName("bs") val bs : String? = null
)
data class Address (

    @SerializedName("street") val street : String? = null,
    @SerializedName("suite") val suite : String? = null,
    @SerializedName("city") val city : String? = null,
    @SerializedName("zipcode") val zipcode : String? = null,
    @SerializedName("geo") val geo : Geo
)