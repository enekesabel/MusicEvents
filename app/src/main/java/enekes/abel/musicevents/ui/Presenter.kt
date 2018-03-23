package enekes.abel.musicevents.ui

/**
 * Created by mobsoft on 2018. 03. 23..
 */
abstract class Presenter<S> {
    protected var screen: S? = null

    fun attachScreen(screen: S) {
        this.screen = screen
    }

    fun detachScreen() {
        this.screen = null
    }
}