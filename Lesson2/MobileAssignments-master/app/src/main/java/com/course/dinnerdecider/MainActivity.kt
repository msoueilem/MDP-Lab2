package com.course.dinnerdecider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.stream.Stream


class MainActivity : AppCompatActivity() {

    private var foodList = arrayListOf<String>("Hamburger");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDecide.setOnClickListener {
            tvSelectedFood.text = getRandomFood();
        }

        btnAddNewFood.setOnClickListener {
            if(edAddNewFood.text.isEmpty())
            {
                Toast.makeText(this, "Please enter food name", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }

            if(checkIfExist(edAddNewFood.text.toString()))
            {
                Toast.makeText(this,"\"${edAddNewFood.text.toString().uppercase()}\" is already exist" , Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }
            foodList.add(edAddNewFood.text.toString())
            edAddNewFood.text.clear();
        }
    }

    private fun checkIfExist(food: String): Boolean {
       return foodList.stream().anyMatch { s -> s.equals(food,true) }
    }

    private fun getRandomFood(): String {
        val index = Random().nextInt(foodList.size)
        return foodList.get(index);
    }
}