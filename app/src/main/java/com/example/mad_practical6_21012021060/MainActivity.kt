package com.example.mad_practical6_21012021060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var flag=1
    lateinit var  playButton:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        playButton =findViewById(R.id.playbtn)
        val stopButton:FloatingActionButton=findViewById(R.id.stopbtn)

        playButton.setOnClickListener {
            playpauseMusic()
        }

        stopButton.setOnClickListener {
            stopMusic()
        }


    }
   fun playpauseMusic(){

       playButton=findViewById(R.id.playbtn)

       if(flag == 1){
           playButton.setImageResource(R.drawable.baseline_pause_24)
           flag=0
       }
       else{
           playButton.setImageResource(R.drawable.baseline_play_arrow_24)
           flag=1
       }
       Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply {
           startService(this)
       }

 }
    fun stopMusic(){
        playButton.setImageResource(R.drawable.baseline_play_arrow_24)
        flag=1

        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply {
            stopService(this)
        }
    }
}