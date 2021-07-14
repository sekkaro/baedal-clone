package fastcampus.aop.part4.chapter06.widget.adapter.listener.restaurant

import fastcampus.aop.part4.chapter06.model.restaurant.RestaurantModel
import fastcampus.aop.part4.chapter06.widget.adapter.listener.AdapterListener

interface RestaurantListListener : AdapterListener {
    fun onClickItem(model: RestaurantModel)
}