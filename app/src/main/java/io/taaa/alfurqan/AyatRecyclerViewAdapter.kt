package io.taaa.alfurqan

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.taaa.alfurqan.databinding.AyatItemBinding

class AyatRecyclerViewAdapter(
    private val values: List<Ayat>
) : RecyclerView.Adapter<AyatRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            AyatItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.text.text = item.text_uthmani
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: AyatItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val text: TextView = binding.text
    }

}