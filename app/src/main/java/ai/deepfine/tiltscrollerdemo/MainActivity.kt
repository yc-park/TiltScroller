package ai.deepfine.tiltscrollerdemo

import ai.deepfine.ycpark.OnTiltListener
import ai.deepfine.ycpark.TiltScroller
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ycpark.tiltscrollerdemo.R

class MainActivity : AppCompatActivity(), OnTiltListener {
    private val textView: TextView by lazy {
        findViewById<TextView>(R.id.test)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TiltScroller.init(this)

//        TiltScroller.registerSensor(this)
    }

    override fun onResume() {
        super.onResume()
        TiltScroller.registerSensor { horizontal, vertical ->
            onTilt(horizontal, vertical)
        }
    }

    override fun onPause() {
        super.onPause()
        TiltScroller.unregisterSensor()
    }

    @SuppressLint("SetTextI18n")
    override fun onTilt(horizontal: Float, vertical: Float) {
        textView.text = "horizontal : $horizontal\nvertical : $vertical"
    }

}