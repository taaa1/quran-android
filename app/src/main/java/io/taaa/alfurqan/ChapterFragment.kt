package io.taaa.alfurqan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ChapterJson(val chapters: Array<Chapters>)
class Chapters(val name_complex: String)

class ChapterFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chapter_list, container, false)

        val chapters = resources.openRawResource(R.raw.chapters).bufferedReader().use { it.readText() }
        val parsed = Gson().fromJson(chapters,ChapterJson::class.java).chapters

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = ChapterRecyclerViewAdapter(parsed, context)
            }
        }
        return view
    }
}