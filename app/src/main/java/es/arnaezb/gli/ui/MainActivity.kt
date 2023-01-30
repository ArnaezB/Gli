package es.arnaezb.gli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import es.arnaezb.gli.Game
import es.arnaezb.gli.R
import es.arnaezb.gli.ui.adapters.GameCardAdapter

class MainActivity : AppCompatActivity() {

    lateinit var gamesLV: ListView
    lateinit var adapter: GameCardAdapter
    var gamesAL = ArrayList<Game>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gamesLV = findViewById(R.id.game_list)
        adapter = GameCardAdapter(this, R.layout.listview_game_card_row ,gamesAL)
        gamesLV.adapter = adapter
    }
}