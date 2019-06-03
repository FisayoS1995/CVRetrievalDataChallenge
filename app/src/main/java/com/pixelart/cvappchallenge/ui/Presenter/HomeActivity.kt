package com.pixelart.cvappchallenge.ui.Presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pixelart.cvappchallenge.AppController
import com.pixelart.cvappchallenge.R
import com.pixelart.cvappchallenge.Adapter.WorkHistoryAdapter
import com.pixelart.cvappchallenge.DI.ActivityComponent
import com.pixelart.cvappchallenge.DI.ActivityModule
import com.pixelart.cvappchallenge.Model.WorkHistory
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.View {
    private lateinit var activityComponent: ActivityComponent
    private lateinit var adapter: WorkHistoryAdapter

    @Inject lateinit var presenter: HomeContract.Presenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        injectDependencies()

        presenter.getCV()
        adapter = WorkHistoryAdapter()

        rvWorkHistory.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            addItemDecoration(DividerItemDecoration(this@HomeActivity, LinearLayoutManager.VERTICAL))
            adapter = this@HomeActivity.adapter
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
    
    override fun showCVDetail(name: String, Email: String, experienceSummary: String,
                              techSkills: String, education: String, interest: String) {

        tvName.text = name
        tvEmail.text = Email
        tvExperience.text = experienceSummary
        tvTechSkills.text = techSkills
        tvEducation.text = education
        tvInterest.text = interest
    }

    override fun showWorkHistory(workHistory: List<WorkHistory>) {
        adapter.submitList(workHistory)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
    
    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun injectDependencies(){
        activityComponent = (application as AppController).applicationComponent
            .newActivityComponent(ActivityModule(this))

        activityComponent.injectHomeScreen(this)
    }
}
