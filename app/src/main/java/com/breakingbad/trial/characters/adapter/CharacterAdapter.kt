package com.breakingbad.trial.characters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.breakingbad.trial.characters.model.Character
import com.breakingbad.trial.databinding.ItemCharacterBinding

class CharacterAdapter(private val items: List<Character>)  : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(val itemViewBinding: ItemCharacterBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(character: Character){
            itemViewBinding.character  = character
            itemViewBinding.ivCharacter.load(character.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val characterAdapterBinding =  ItemCharacterBinding.inflate(inflater)
        return ViewHolder(characterAdapterBinding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  = holder.bind(items[position])

    override fun getItemCount(): Int  = items.size
}