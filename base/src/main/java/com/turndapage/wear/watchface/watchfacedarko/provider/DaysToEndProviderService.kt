package com.turndapage.wear.watchface.watchfacedarko.provider

import android.support.wearable.complications.ComplicationData
import android.support.wearable.complications.ComplicationManager
import android.support.wearable.complications.ComplicationProviderService
import android.support.wearable.complications.ComplicationText
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DaysToEndProviderService : ComplicationProviderService() {

    private val secondsInDay = 86400

    override fun onComplicationUpdate(complicationId: Int, type: Int, manager: ComplicationManager?) {
        val currentTime = Calendar.getInstance().time
        val localDate = if(Calendar.getInstance().get(Calendar.MONTH) > 9) // use next year if past october
            GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR) + 1, 9, 31)
        else
            GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), 9, 31)
        val halloween = localDate.time

        val diff = halloween.time - currentTime.time
        val diffSec = diff / 1000

        val days = diffSec / secondsInDay
        val secondsDay = diffSec % secondsInDay
        val seconds = secondsDay % 60
        val minutes = (secondsDay / 60) % 60
        val hours = secondsDay / 3600
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        println(days)

        Log.d("Tag", "Updating with $days:$hours:$minutes:$seconds")
        if (ComplicationData.TYPE_SHORT_TEXT == type) {
            val complicationData: ComplicationData = ComplicationData.Builder(ComplicationData.TYPE_SHORT_TEXT)
                    .setShortText(ComplicationText.plainText("$currentDate:$hours"))
                    .setShortTitle(ComplicationText.plainText("$minutes:$seconds"))
                    .build()
            manager?.updateComplicationData(complicationId, complicationData)
        }

    }
}