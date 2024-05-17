package com.randstad.automotivehelloworldapp2

import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Screen2(carContext: CarContext) : Screen(carContext) {
    init {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                Log.i("mytag", "Screen2 onStart() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                Log.i("mytag", "Screen2 onStop() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                Log.i("mytag", "Screen2 onDestroy() method")
            }
        })
    }

    override fun onGetTemplate(): Template {
        val row1 = Row.Builder().setTitle("Screen2").build()

        CarToast.makeText(carContext, "Hello!", CarToast.LENGTH_LONG).show()

        val pane = Pane.Builder().addRow(row1).build()

        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.BACK)
            .build()
    }
}