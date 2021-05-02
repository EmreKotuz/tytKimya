package com.example.tytkimya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_kisa_notlar.*
import kotlinx.android.synthetic.main.activity_kisa_notlar.imageee
import java.util.*


const val GAME_LENeGTH_MeILLISECONDSae = 3000L
const val AD_UeNIT_eIDae = "ca-app-pub-6537190103014639/6993907352"

class kisaNotlarActivity : AppCompatActivity() {

    private var mAdView: AdView? = null

    var sayi:Int=0
    var sayiIki=3
    val randommmm= arrayListOf(R.mipmap.asit,R.mipmap.ayirt,R.mipmap.bile,R.mipmap.biles,R.mipmap.elekt,R.mipmap.element,R.mipmap.ga,R.mipmap.gaz,R.mipmap.gazbas
        ,R.mipmap.gy,R.mipmap.iyo,R.mipmap.kaba,R.mipmap.karisim,R.mipmap.ktk,R.mipmap.mad,R.mipmap.molk
        ,R.mipmap.ozkutle,R.mipmap.pg,R.mipmap.sim)

    //reklam kodu

    private lateinit var mInterstitialAd: InterstitialAd
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameIsInProgress = false
    private var mTimerMilliseconds = 0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kisa_notlar)

        buttonBas.setOnClickListener{
            val random = Random()
            val button = random.nextInt(randommmm.count())
            imageee.setImageResource(randommmm[button])

            sayi++

            if (sayi==10){
                sayi=0
                showInterstitial()

            }
        }

        val random = Random()
        val button = random.nextInt(randommmm.count())
        imageee.setImageResource  (randommmm[button])


        mesajButton.setOnClickListener {
            var intent=Intent(this,mesaj::class.java)
            startActivity(intent)
        }

        yorum2.setOnClickListener {
            var intent=Intent(this, kullaniciYorum::class.java)
            startActivity(intent)
        }



        MobileAds.initialize(this, "\n" + "ca-app-pub-6537190103014639~1527626552")
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)


        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/8017013282"

        mAdView!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        }



        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this)

        // Create the InterstitialAd and set it up.
        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = AD_UeNIT_eIDae
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                }

                override fun onAdFailedToLoad(errorCode: Int) {

                }

                override fun onAdClosed() {

                    startGame()

                }
            })
        }

        // Create the "retry" button, which triggers an interstitial between game plays.



        // Kick off the first play of the "game."
        startGame()
    }


    // Create the game timer, which counts down to the end of the level
// and shows the "retry" button.
    private fun createTimer(milliseconds: Long) {
        mCountDownTimer?.cancel()

        mCountDownTimer = object : CountDownTimer(milliseconds, 50) {
            override fun onTick(millisUntilFinished: Long) {
                mTimerMilliseconds = millisUntilFinished
            }

            override fun onFinish() {
                mGameIsInProgress = false
            }
        }
    }

    // Show the ad if it's ready. Otherwise toast and restart the game.
    private fun showInterstitial() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()


        } else {
            startGame()

        }
    }

    // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
    private fun startGame() {
        if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
            // Create an ad request. If you're running this on a physical device, check your logcat
            // to learn how to enable test ads for it. Look for a line like this one:
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            val adRequest = AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build()

            mInterstitialAd.loadAd(adRequest)


        }

        resumeGame(GAME_LENeGTH_MeILLISECONDSae)
    }

    private fun resumeGame(milliseconds: Long) {
        // Create a new timer for the correct length and start it.
        mGameIsInProgress = true
        mTimerMilliseconds = milliseconds
        createTimer(milliseconds)
        mCountDownTimer?.start()
    }

    // Resume the game if it's in progress.
    public override fun onResume() {
        super.onResume()

        if (mGameIsInProgress) {
            resumeGame(mTimerMilliseconds)
        }
    }

    // Cancel the timer if the game is paused.
    public override fun onPause() {
        mCountDownTimer?.cancel()
        super.onPause()
    }

}