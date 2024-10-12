package com.example.HappyPuppyFoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.racipeapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var rvAdapter: CategoryAdapter
    private lateinit var dataList: ArrayList<Recipe>

    private val binding by lazy {
        ActivityCategoryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.tittle.text = intent.getStringExtra("TITTLE")
        binding.goBackHome.setOnClickListener {
            finish()
        }

        setUpRecyclerView()


    }
    private fun setUpRecyclerView() {
        // Initialize an empty ArrayList to hold the data
        var dataList = ArrayList<Recipe>()

        // Set up the RecyclerView and adapter
        rvAdapter = CategoryAdapter(dataList, this)
        binding.rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var db = Room.databaseBuilder(this@CategoryActivity,AppDatabase::class.java,"db_name")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()

        var daoObject = db.getDao()
        var recipes = daoObject.getAll()

        for(i in recipes!!.indices){
            if(recipes[i]!!.category.contains(intent.getStringExtra("CATEGORY")!!)){
                dataList.add(recipes[i]!!)
            }

            rvAdapter = CategoryAdapter(dataList,this)

            binding.rvCategory.adapter = rvAdapter
        }



    }
}