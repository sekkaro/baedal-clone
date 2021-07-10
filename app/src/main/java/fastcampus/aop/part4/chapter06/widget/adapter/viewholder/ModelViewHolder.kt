package fastcampus.aop.part4.chapter06.widget.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import fastcampus.aop.part4.chapter06.model.Model
import fastcampus.aop.part4.chapter06.screen.base.BaseViewModel
import fastcampus.aop.part4.chapter06.util.provider.ResourcesProvider
import fastcampus.aop.part4.chapter06.widget.adapter.listener.AdapterListener

abstract class ModelViewHolder<M : Model>(
    binding: ViewBinding,
    protected val viewModel: BaseViewModel,
    protected val resourcesProvider: ResourcesProvider
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindViews(model: M, adapterListener: AdapterListener)
}