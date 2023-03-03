package com.example.interesting_fact_about_numbers.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interesting_fact_about_numbers.AppDB
import com.example.interesting_fact_about_numbers.Contance
import com.example.interesting_fact_about_numbers.activity.adapters.MyAdapter
import com.example.interesting_fact_about_numbers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        LiveListener()
        updateAdapter()
    }

    fun LiveListener() {
        AppDB.instance.getDatabase()!!.getDao().getAllItem().asLiveData().observe(this){
            updateAdapter()
        }
    }

    fun onClickGetRandomFact(view: View){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(Contance.GET_FACT, Contance.GET_RANDOM_FACT)
        startActivity(intent)
    }

    fun onClickGetNumberFact(view : View){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(Contance.GET_FACT, Contance.GET_FACT_NUMBER)
        startActivity(intent)
    }

    fun updateAdapter() {
        val adapterNamePattrn = MyAdapter(AppDB.instance.getDatabase()!!.getDao().getAllItemNotLive())
        val llm = LinearLayoutManager(this@MainActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        bindingClass.rcView.setLayoutManager(llm)
        bindingClass.rcView.setAdapter(adapterNamePattrn)
    }
}