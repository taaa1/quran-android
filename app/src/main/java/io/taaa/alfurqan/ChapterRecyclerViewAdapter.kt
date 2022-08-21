package io.taaa.alfurqan

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.taaa.alfurqan.databinding.FragmentChapterBinding

class ChapterRecyclerViewAdapter(
    private val values: Array<Chapters>
) : RecyclerView.Adapter<ChapterRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentChapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.name_complex
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
    }

}