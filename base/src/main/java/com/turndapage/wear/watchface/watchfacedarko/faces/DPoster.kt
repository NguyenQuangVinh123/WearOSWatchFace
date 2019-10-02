
package com.turndapage.wear.watchface.watchfacedarko.faces

import android.graphics.Color
import android.view.Gravity
import com.turndapage.wear.watchface.watchfacedarko.R
import com.turndapage.wear.watchface.watchfacedarko.model.AnalogWatchFaceStyle
import com.turndapage.wear.watchface.watchfacedarko.service.AbstractKotlinWatchFace
import com.turndapage.wear.watchface.watchfacedarko.provider.DaysToEndProviderService
import com.turndapage.wear.watchface.watchfacedarko.provider.QuoteProviderService
import com.turndapage.wear.watchface.watchfacedarko.service.analogWatchFaceStyle

/**
 * Renders watch face via data object created by DSL.
 */
class DPoster : AbstractKotlinWatchFace() {

    override fun getWatchFaceStyle(): AnalogWatchFaceStyle {

        /**
         * Initializes colors and dimensions of watch face. Review [AnalogWatchFaceStyle] for
         * detailed explanation of each field.
         */
        return analogWatchFaceStyle {
            watchFaceColors {
                main = Color.WHITE
                highlight = Color.parseColor("#008c44")
                background = Color.BLACK
                complication = Color.parseColor("#808080")
                shadow = Color.BLACK
                tickPaint = Color.parseColor("#008c44")
            }
            watchFaceDimensions {
                hourHandRadiusRatio = 0.2f
                minuteHandRadiusRatio = 0.25f
                secondHandRadiusRatio = 0.9f
                innerCircleRadius = 10f
                shadowRadius = 10f
            }
            watchFaceBackgroundImage {
                backgroundImageResource = R.drawable.d_poster_preview
            }
            watchFaceHourHand {
                drawable = R.drawable.gothic_hour_hand
                offset = .27f
            }
            watchFaceMinuteHand {
                drawable = R.drawable.gothic_minute_hand
                offset = .27f
            }
            watchFaceComplication1 {
                widthRatio = 0.25f
                heightRatio = 0.25f
                xPos = 0.9f
                yPos = 0.5f
                titleTypeface = R.font.donnie_darko
            }
            watchFaceComplication2 {
                widthRatio = 0.25f
                heightRatio = 0.25f
                xPos = 0.1f
                yPos = 0.5f
                titleTypeface = R.font.donnie_darko
            }
            watchFaceStyle{
                topNumber = true
                bottomNumber = true
                statusGravity = Gravity.CENTER
            }
        }
    }
}
