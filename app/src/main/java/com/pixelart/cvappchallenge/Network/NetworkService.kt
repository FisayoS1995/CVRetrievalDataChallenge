package com.pixelart.cvappchallenge.Network

import com.pixelart.cvappchallenge.Common.RELATIVE_URL
import com.pixelart.cvappchallenge.Model.CurriculumV
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkService{
    @GET(RELATIVE_URL)
    fun getCV(): Single<CurriculumV>
}