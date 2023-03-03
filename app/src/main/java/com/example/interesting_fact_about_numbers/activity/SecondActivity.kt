package com.example.interesting_fact_about_numbers.activity


import android.os.Bundle

import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.interesting_fact_about_numbers.AppDB
import com.example.interesting_fact_about_numbers.Contance
import com.example.interesting_fact_about_numbers.R
import com.example.interesting_fact_about_numbers.databinding.ActivitySecondBinding
import com.example.interesting_fact_about_numbers.db.NumbersFact
import com.example.interesting_fact_about_numbers.net.UrlReader
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivitySecondBinding

    private  var signState = "empty"
    private var fact = ""
    private var number = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        ButterKnife.bind(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        signState = intent.getStringExtra(Contance.GET_FACT)!!
        if (signState == Contance.GET_RANDOM_FACT) {
            bindingClass.edNumber.visibility = View.GONE
            bindingClass.btStart.visibility = View.GONE
            number = Random.nextInt(0, 4000).toString()
            fact = runBlocking {
                UrlReader().getTextFromUrl(
                    "http://numbersapi.com/" + number
                )
            }
            /*AppDB.instance.getDatabase()!!.getDao().insert( NumbersFact(
                null,
                number,
                fact
            ))*/
            AppDB.instance.getDatabase()!!.getDao().insert( NumbersFact(
                null,
                number,
                fact
            ))
            bindingClass.textView2.text = fact
        }
    }

    @OnClick(R.id.btStart)
    fun btsTART(){
        number = bindingClass.edNumber.text.toString()
        if(!number.toString().trim().equals("")) {
            fact = runBlocking { UrlReader().getTextFromUrl("http://numbersapi.com/" + number) }
            bindingClass.textView2.text = fact
            AppDB.instance.getDatabase()!!.getDao().insert( NumbersFact(
                null,
                number,
                fact
            ))
        }else{
            Toast.makeText(this,"Поле пустое",Toast.LENGTH_LONG).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return true
    }
}