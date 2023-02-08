package es.arnaezb.gli.ui.adapters

import android.app.Activity

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import es.arnaezb.gli.Game
import es.arnaezb.gli.R
import es.arnaezb.gli.databinding.ListviewGameCardRowBinding
import kotlin.random.Random

class GameCardAdapter(private val dataSet: MutableList<Game>, private val context: Context, private val _adapterContract: RecyclerAdapterContract):
    RecyclerView.Adapter<GameCardAdapter.ViewHolder>() {

    private var lastPosition = -1

    val adapterContract get() = _adapterContract
    override fun getItemCount() = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listview_game_card_row, parent, false)
        return ViewHolder(view, adapterContract)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = Random.nextInt().toString()
        setAnimation(holder.itemView, position)
    }

    private fun setAnimation(view: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in)
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    class ViewHolder(view: View, contract: RecyclerAdapterContract): RecyclerView.ViewHolder(view) {
        val image: ImageView
        val name: TextView

        init {
            image = view.findViewById(R.id.image)
            name = view.findViewById(R.id.name)
            view.setOnClickListener{
                if(adapterPosition != RecyclerView.NO_POSITION) {
                    contract.onItemClick(adapterPosition)
                }
            }
        }
    }

    class MarginDecorator(private val spaceMargin: Int): RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            with(outRect) {
                if(parent.getChildAdapterPosition(view) == 0) top = spaceMargin
                left = spaceMargin
                right = spaceMargin
                bottom = spaceMargin
            }
        }
    }

    interface RecyclerAdapterContract {
        fun onItemClick(pos: Int)
    }

}