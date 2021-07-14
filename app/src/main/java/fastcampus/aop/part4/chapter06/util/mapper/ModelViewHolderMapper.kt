package fastcampus.aop.part4.chapter06.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import fastcampus.aop.part4.chapter06.databinding.ViewholderEmptyBinding
import fastcampus.aop.part4.chapter06.databinding.ViewholderRestaurantBinding
import fastcampus.aop.part4.chapter06.model.CellType
import fastcampus.aop.part4.chapter06.model.Model
import fastcampus.aop.part4.chapter06.screen.base.BaseViewModel
import fastcampus.aop.part4.chapter06.util.provider.ResourcesProvider
import fastcampus.aop.part4.chapter06.widget.adapter.viewholder.EmptyViewHolder
import fastcampus.aop.part4.chapter06.widget.adapter.viewholder.ModelViewHolder
import fastcampus.aop.part4.chapter06.widget.adapter.viewholder.restaurant.RestaurantViewHolder

object ModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun <M : Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
    ): ModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            CellType.EMPTY_CELL -> EmptyViewHolder(
                ViewholderEmptyBinding.inflate(inflater, parent, false),
                viewModel,
                resourcesProvider
            )
            CellType.RESTAURANT_CELL -> RestaurantViewHolder(
                ViewholderRestaurantBinding.inflate(inflater, parent, false),
                viewModel,
                resourcesProvider
            )
        }
        return viewHolder as ModelViewHolder<M>
    }
}