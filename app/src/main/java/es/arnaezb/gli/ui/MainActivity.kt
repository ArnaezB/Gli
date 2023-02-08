package es.arnaezb.gli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import es.arnaezb.gli.databinding.MainActivityBinding
import es.arnaezb.gli.ui.fragments.GameDetailsFragment
import es.arnaezb.gli.ui.fragments.GameListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = GameListFragment() {
            id:Int -> toGameDetails(id)
        }
        supportFragmentManager.beginTransaction()
            .add(binding.mainContent.id, fragment, GameListFragment.TAG)
            .commit()
    }

    fun toGameDetails(gameId: Int) {
        Log.i("MAIN_ACTIVITY", "chango to fragment details with id: $gameId")
        val fragment = GameDetailsFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.mainContent.id, fragment, GameDetailsFragment.TAG)
            .commit()
    }
}