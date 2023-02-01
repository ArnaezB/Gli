package es.arnaezb.gli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.arnaezb.gli.Game
import es.arnaezb.gli.R
import es.arnaezb.gli.ui.adapters.GameCardAdapter

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GameCardAdapter
    var data = ArrayList<Game>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.game_list)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // this adds margins between the cards
        recyclerview.addItemDecoration(GameCardAdapter.MarginDecorator(resources.getDimensionPixelOffset(R.dimen.margin_card)))

        // This will pass the ArrayList to our Adapter
        val adapter = GameCardAdapter(data, applicationContext)

        findViewById<Button>(R.id.button).setOnClickListener {
            data.add(Game(""))
            adapter.notifyDataSetChanged()
        }

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}