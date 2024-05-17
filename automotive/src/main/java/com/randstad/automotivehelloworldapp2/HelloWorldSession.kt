package com.randstad.automotivehelloworldapp2
import android.content.Intent
import android.util.Log
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class HelloWorldSession : Session() {
    init {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                Log.i("mytag", "Session onStart() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                Log.i("mytag", "Session onStop() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                Log.i("mytag", "Session onDestroy() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume() {
                Log.i("mytag", "Session onResume() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            fun onPause() {
                Log.i("mytag", "Session onPause() method")
            }
        })
    }

    override fun onCreateScreen(intent: Intent): Screen {
        return HelloWorldScreen(carContext)
    }

}
