package com.example.automotivehelloworldapp2

import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template

class Screen1(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val row1 = Row.Builder().setTitle("Screen1").build()

        CarToast.makeText(carContext, "Hello!", CarToast.LENGTH_LONG).show()

        val pane = Pane.Builder().addRow(row1).build()

        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.BACK)
            .build()
    }
}