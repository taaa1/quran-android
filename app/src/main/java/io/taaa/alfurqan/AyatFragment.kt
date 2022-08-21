package io.taaa.alfurqan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class AyatJson(val verses: Array<Ayat>)
class Ayat(val verse_key: String, val text_uthmani: String)

class AyatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ayat_item_list, container, false)
        val index = requireArguments().getInt("index")

        val quran = resources.openRawResource(R.raw.quran).bufferedReader().use { it.readText() }
        val parsed = Gson().fromJson(
            quran,
            AyatJson::class.java
        ).verses.filter { it.verse_key.split(":")[0] == (index + 1).toString() }

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = AyatRecyclerViewAdapter(parsed)
            }
        }
        return view
    }
}