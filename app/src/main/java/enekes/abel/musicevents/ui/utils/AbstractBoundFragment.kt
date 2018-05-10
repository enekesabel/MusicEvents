package enekes.abel.musicevents.ui.utils

import android.app.Fragment
import android.content.Context
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import enekes.abel.musicevents.ui.Presenter

abstract class AbstractBoundFragment<S: Any, B: ViewDataBinding> : Fragment() {

    protected abstract val presenter: Presenter<S>
    protected lateinit var binding: B

    init {
        injectDependency()
    }

    protected abstract fun injectDependency()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getBinding(inflater, container)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.attachScreen(this as S)
    }

    override fun onDetach() {
        presenter.detachScreen()
        super.onDetach()
    }

    protected abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): B
}