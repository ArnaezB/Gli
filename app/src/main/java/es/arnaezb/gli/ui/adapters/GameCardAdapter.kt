package es.arnaezb.gli.ui.adapters

import android.app.Activity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import es.arnaezb.gli.Game

class GameCardAdapter(private val mContext: Context, private val layoutResource: Int, games: List<Game>):
    ArrayAdapter<Game>(mContext, layoutResource, games){

    private var games: MutableList<Game> = ArrayList(games)

    override fun getCount(): Int {
        return games.size
    }

    override fun getItem(position: Int): Game {
        return games[position]
    }

    override fun getItemId(position: Int): Long {
        return games[position].id.toLong()
    }

    override fun add(game: Game?) {
        super.add(game!!)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater = (mContext as Activity).layoutInflater
            convertView = inflater.inflate(layoutResource, parent, false)
        }
        return convertView!!
    }



}