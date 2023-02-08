package es.arnaezb.gli.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.arnaezb.gli.databinding.GameDetailsFragmentBinding

class GameDetailsFragment: Fragment() {

    lateinit var binding: GameDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GameDetailsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        const val TAG = "GameDetails"
    }
}