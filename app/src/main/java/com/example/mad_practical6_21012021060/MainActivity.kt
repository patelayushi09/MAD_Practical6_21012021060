package com.example.mad_practical6_21012021060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var flag=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val playButton:FloatingActionButton =findViewById(R.id.playbtn)
        val stopButton:FloatingActionButton=findViewById(R.id.stopbtn)

        playButton.setOnClickListener {
            playpauseMusic()
        }

        stopButton.setOnClickListener {
            stopMusic()
        }


    }
   fun playpauseMusic(){

       val playButton:FloatingActionButton =findViewById(R.id.playbtn)
       val stopButton:FloatingActionButton=findViewById(R.id.stopbtn)
       if(flag == 1){
           playButton.setImageResource(R.drawable.baseline_pause_24)
       }
       else{
           playButton.setImageResource(R.drawable.baseline_play_arrow_24)
       }
       Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply {
           startService(this)
       }

 }
    fun stopMusic(){
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply {
            stopService(this)
        }
    }
}