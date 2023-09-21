package com.example.homeworksavestatewithsaveinstancestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var numberOfClicks:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        if (savedInstanceState != null) {
            numberOfClicks = savedInstanceState.getInt(ITEMS_KEY)
            textView.text = numberOfClicks.toString()
        }

        fab.setOnClickListener {
            numberOfClicks += 1
            textView.text = numberOfClicks.toString()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ITEMS_KEY, numberOfClicks)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val  ITEMS_KEY = "my_items_key"
    }
}