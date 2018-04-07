package enekes.abel.musicevents.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }


    override fun showEvents(artistName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
