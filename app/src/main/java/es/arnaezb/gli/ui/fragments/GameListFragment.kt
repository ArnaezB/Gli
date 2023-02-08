package es.arnaezb.gli.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.arnaezb.gli.Game
import es.arnaezb.gli.R
import es.arnaezb.gli.databinding.GameListFragmentBinding
import es.arnaezb.gli.ui.adapters.GameCardAdapter
import kotlin.reflect.KFunction1

class GameListFragment(private val callback: (Int) -> Unit): Fragment(), GameCardAdapter.RecyclerAdapterContract {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GameCardAdapter
    var data = ArrayList<Game>()

    private lateinit var binding: GameListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GameListFragmentBinding.inflate(inflater, container, false)

        // getting the recyclerview by its id
        val recyclerview = binding.gameList
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(context)
        // this adds margins between the cards
        recyclerview.addItemDecoration(GameCardAdapter.MarginDecorator(resources.getDimensionPixelOffset(
            R.dimen.margin_card)))

        val adapter = GameCardAdapter(data, requireContext(), this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        binding.button.setOnClickListener {
            data.add(Game("game"))
            adapter.notifyDataSetChanged()
        }

        return binding.root
    }

    override fun onItemClick(pos: Int) {
        callback(pos)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        const val TAG = "GameList"
    }

}