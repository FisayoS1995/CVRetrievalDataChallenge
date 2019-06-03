package com.pixelart.cvappchallenge.ui.Presenter

import com.pixelart.cvappchallenge.Model.WorkHistory


interface HomeContract {
    interface View{
        fun showCVDetail(name:String, Email:String, experienceSummary:String, techSkills:String,
                         education:String, interest:String)
        fun showWorkHistory(workHistory: List<WorkHistory>)
        fun showError(error: String)
        fun showMessage(message: String)
    }
    
    interface Presenter{
        fun getCV()
        fun onStop()
    }
}