package fastcampus.aop.part4.chapter06.data.repository

import fastcampus.aop.part4.chapter06.data.entity.RestaurantEntity
import fastcampus.aop.part4.chapter06.screen.main.home.restaurant.RestaurantCategory

interface RestaurantRepository {
    suspend fun getList(
        restaurantCategory: RestaurantCategory
    ): List<RestaurantEntity>
}