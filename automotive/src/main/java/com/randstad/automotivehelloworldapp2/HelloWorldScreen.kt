package com.randstad.automotivehelloworldapp2

import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.CarIcon
import androidx.car.app.model.GridItem
import androidx.car.app.model.GridTemplate
import androidx.car.app.model.ItemList
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.automotivehelloworldapp2.R

class HelloWorldScreen(carContext: CarContext) : Screen(carContext) {
    init {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                Log.i("mytag", "HelloWorldScreen onStart() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                Log.i("mytag", "HelloWorldScreen onStop() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                Log.i("mytag", "HelloWorldScreen onDestroy() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume() {
                Log.i("mytag", "HelloWorldScreen onResume() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            fun onPause() {
                Log.i("mytag", "HelloWorldScreen onPause() method")
            }
        })
    }

    override fun onGetTemplate(): Template {

        CarToast.makeText(carContext, "Hello!", CarToast.LENGTH_LONG).show()

        /*// Pane Template
        val row1 = Row.Builder().setTitle("Hello World!").build()
        val pane = Pane.Builder().addRow(row1).build()
        return PaneTemplate.Builder(pane)
           .setHeaderAction(Action.BACK)
           .build()*/

        val imageIcon = IconCompat.createWithResource(carContext, R.drawable.ic_launcher_background)

        val gridItem1 = GridItem.Builder()
            .setTitle("Screen1")
            .setImage(CarIcon.Builder(imageIcon).build())
            .setOnClickListener {
                screenManager.push(Screen1(carContext))
            }
            .build()

        val gridItem2 = GridItem.Builder()
            .setTitle("Screen2")
            .setImage(CarIcon.Builder(imageIcon).build())
            .setOnClickListener {
                screenManager.push(Screen2(carContext))
            }
            .build()

        val gridItemList = ItemList.Builder()
            .addItem(gridItem1)
            .addItem(gridItem2)
            .build()

        return GridTemplate.Builder()
            .setTitle("Car Information App")
            .setSingleList(gridItemList)
            .build()

    }

}
