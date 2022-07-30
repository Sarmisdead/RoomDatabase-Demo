package com.example.roomdatabasedemo

import android.animation.ValueAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.databinding.ItemsRowBinding

class ItemAdapter(private val items : ArrayList<EmployeeEntity>,
                  private val updateListener : (id : Int) -> Unit,
                  private val deleteListener : (id : Int) -> Unit
                  ) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root) {

        val llMain = binding.llMain
        val tvName = binding.tvName
        val tvEmail = binding.tvEmail
        val ivEdit = binding.ivEdit
        val ivDelete = binding.ivDelete

    } //End of ViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder( ItemsRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

    } //End of onCreateViewHolder

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val context = holder.itemView.context
        val item = items[position]

        holder.tvName.text = item.name
        holder.tvEmail.text = item.email

        if(position % 2 == 0){

            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
            R.color.lightGray))

        } else {

            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.white))

        } //End of IF

        holder.ivEdit.setOnClickListener {

            updateListener.invoke(item.id)

        } //End of setOnClickListener

        holder.ivDelete.setOnClickListener {

            deleteListener.invoke(item.id)

        } //End of setOnClickListener

    } //End of onBindViewHolder

    override fun getItemCount(): Int {

        return items.size

    } //End of getItemCount

} //End of itemAdapter