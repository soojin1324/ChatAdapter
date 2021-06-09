package com.soojin.recyclerviewstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat.view.*

class CharAdapter: RecyclerView.Adapter<CharAdapter.ItemViewHolder>() {
    private val chats = ArrayList<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharAdapter.ItemViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    fun addChat(chat: Chat) {
        chats.add(chat)
        notifyDataSetChanged()
    }

    fun addChats(chats: ArrayList<Chat>) {
        this.chats.addAll(chats)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(chat: Chat) {
            itemView.apply {
                item_tv_chat_name.text = chat.name
                item_tv_caht_massage.text = chat.message
            }
        }
    }
}