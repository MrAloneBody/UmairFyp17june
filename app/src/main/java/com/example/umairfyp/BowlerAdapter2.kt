package com.example.umairfyp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umairfyp.databinding.RowBatsmanBinding
import com.example.umairfyp.databinding.RowBowlerBinding
import com.example.umairfyp.databinding.RowPlayersBinding
import com.example.umairfyp.model.Batsman_data.Scorecard
import com.example.umairfyp.model.players_list.Data


class BowlerAdapter2(private var scorecard: List<Scorecard>) : RecyclerView.Adapter<BowlerAdapter2.ViewHolder>(){

    class ViewHolder (val binding: RowBowlerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBowlerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var player = scorecard[position]
        holder.binding.BowlersName.text = player.bowling[1].bowler.name
        holder.binding.BowlersOvers.text = player.bowling[1].o.toString()
        holder.binding.BowlersScore.text = player.bowling[1].r.toString()
        holder.binding.BowlersRR.text = player.bowling[1].eco.toString()
        holder.binding.wicketsTaken.text = player.bowling[1].w.toString()


//        holder.itemView.setOnClickListener { mListener?.setOnItemClickListener(village) }
    }

    override fun getItemCount(): Int {
        return scorecard.size
    }

    private var mListener: OnItemClick? = null
    interface OnItemClick {
        fun setOnItemClickListener(item: Data)
    }

    fun setOnClickListener(onItemClick: OnItemClick) {
        mListener = onItemClick
    }
}
