package com.pixelart.cvappchallenge.Model

import com.google.gson.annotations.SerializedName

data class WorkHistory(
    @SerializedName("company_name")
    val companyName: String,
    val logo: String,
    val from: String,
    @SerializedName("main_responsibilities")
    val mainResponsibilities: List<String>,
    val role: String,
    val to: String,
    @SerializedName("app_description")
    val appDescription: String

)