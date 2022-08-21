package io.taaa.alfurqan

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import io.taaa.alfurqan.placeholder.PlaceholderContent.PlaceholderItem
import io.taaa.alfurqan.databinding.FragmentChapterBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
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