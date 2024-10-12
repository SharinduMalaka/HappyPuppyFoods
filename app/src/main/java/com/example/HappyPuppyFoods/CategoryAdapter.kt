package com.example.HappyPuppyFoods

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.racipeapp.databinding.CategoryRvBinding

class CategoryAdapter(var dataList: ArrayList<Recipe>, var context: Context): RecyclerView.Adapter<CategoryAdapter.Viewholder>() {

      inner class Viewholder(var binding: CategoryRvBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent:  ViewGroup, viewType: Int): Viewholder {
        var binding = CategoryRvBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)

    }

    override fun getItemCount(): Int {
        return dataList.size

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        Glide.with(context).load(dataList.get(position).img).into(holder.binding.img)
        holder.binding.tittle.text = dataList.get(position).tittle

        var temp = dataList.get(position).ing.split("\n").dropLastWhile { it.isEmpty() }.toTypedArray()
        holder.binding.time.text = temp[0]

        holder.binding.next.setOnClickListener {
            var intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("img",dataList.get(position).img)
            intent.putExtra("tittle",dataList.get(position).tittle)
            intent.putExtra("des",dataList.get(position).des)
            intent.putExtra("ing",dataList.get(position).ing)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

    }

}