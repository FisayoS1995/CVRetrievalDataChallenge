package com.pixelart.cvappchallenge.Model

import com.google.gson.annotations.SerializedName

data class CurriculumV(
    val email: String,
    val education: List<String>,
    @SerializedName("experience_summary")
    val interests: List<String>,
    val name: String,
    val experienceSummary: List<String>,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("work_history")
    val workHistory: List<WorkHistory>,
    @SerializedName("technical_skills")
    val technicalSkills: List<String>

)