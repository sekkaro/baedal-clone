package fastcampus.aop.part4.chapter06.widget.adapter.viewholder

import fastcampus.aop.part4.chapter06.databinding.ViewholderEmptyBinding
import fastcampus.aop.part4.chapter06.model.Model
import fastcampus.aop.part4.chapter06.screen.base.BaseViewModel
import fastcampus.aop.part4.chapter06.util.provider.ResourcesProvider
import fastcampus.aop.part4.chapter06.widget.adapter.listener.AdapterListener

class EmptyViewHolder(
    private val binding: ViewholderEmptyBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
) : ModelViewHolder<Model>(binding, viewModel, resourcesProvider) {
    override fun reset() = Unit

    override fun bindViews(model: Model, adapterListener: AdapterListener) = Unit

}