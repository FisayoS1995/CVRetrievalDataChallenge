package com.pixelart.cvappchallenge.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pixelart.cvappchallenge.R
import com.pixelart.cvappchallenge.Common.GlideApp
import com.pixelart.cvappchallenge.Model.WorkHistory

class WorkHistoryAdapter: ListAdapter<WorkHistory, WorkHistoryAdapter.ViewHolder>(diffUtil) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.workhistory_rv_layout, parent, false)
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workHistory = getItem(position)
        holder.setContent(workHistory)
    }
    
    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val companyName: TextView = view.findViewById(R.id.tvComapanyName)
        private val role: TextView = view.findViewById(R.id.tvRole)
        private val fromTo:TextView = view.findViewById(R.id.tvFromTo)
        private val appDescription: TextView = view.findViewById(R.id.tvAppDescription)
        private val responsibilities: TextView = view.findViewById(R.id.tvResponsibilities)
        private val icon: ImageView = view.findViewById(R.id.ivLogo)

        @SuppressLint("SetTextI18n")
        fun setContent(workHistory: WorkHistory){
            companyName.text = workHistory.companyName
            role.text = workHistory.role
            fromTo.text = "${workHistory.from} - ${workHistory.to}"
            appDescription.text = workHistory.appDescription
            responsibilities.text = workHistory.mainResponsibilities.joinToString("\n\u2022", "\u2022", "",-1, "")

            GlideApp.with(view.context)
                .load(workHistory.logo)
                .into(icon)
        }
    }
    
    companion object{
        val diffUtil: DiffUtil.ItemCallback<WorkHistory> = object: DiffUtil.ItemCallback<WorkHistory>(){
            override fun areItemsTheSame(oldItem: WorkHistory, newItem: WorkHistory): Boolean {
                return oldItem == newItem
            }
    
            override fun areContentsTheSame(oldItem: WorkHistory, newItem: WorkHistory): Boolean {
                return oldItem == newItem
            }
        }
    }
}