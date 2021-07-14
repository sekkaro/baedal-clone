package fastcampus.aop.part4.chapter06.screen.main.home.restaurant

import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import fastcampus.aop.part4.chapter06.databinding.FragmentRestaurantListBinding
import fastcampus.aop.part4.chapter06.model.Model
import fastcampus.aop.part4.chapter06.model.restaurant.RestaurantModel
import fastcampus.aop.part4.chapter06.screen.base.BaseFragment
import fastcampus.aop.part4.chapter06.util.provider.ResourcesProvider
import fastcampus.aop.part4.chapter06.widget.adapter.ModelRecyclerAdapter
import fastcampus.aop.part4.chapter06.widget.adapter.listener.restaurant.RestaurantListListener
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RestaurantListFragment :
    BaseFragment<RestaurantListViewModel, FragmentRestaurantListBinding>() {

    private val restaurantCategory by lazy { arguments?.getSerializable(RESTAURANT_CATEGORY_KEY) as RestaurantCategory }

    override val viewModel by viewModel<RestaurantListViewModel> { parametersOf(restaurantCategory) }

    override fun getViewBinding(): FragmentRestaurantListBinding =
        FragmentRestaurantListBinding.inflate(layoutInflater)

    val resourcesProvider by inject<ResourcesProvider>()

    private val adapter by lazy {
        ModelRecyclerAdapter<RestaurantModel, RestaurantListViewModel>(
            listOf(),
            viewModel,
            resourcesProvider,
            adapterListener = object : RestaurantListListener {
                override fun onClickItem(model: RestaurantModel) {
                    Toast.makeText(requireContext(), "$model", Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun initViews() = with(binding) {
        recyclerView.adapter = adapter
    }

    override fun observeData() = viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
        Log.d("restaurantList", it.toString())
        adapter.submitList(it)
    }

    companion object {
        const val RESTAURANT_CATEGORY_KEY = "restaurantCategory"

        fun newInstance(restaurantCategory: RestaurantCategory): RestaurantListFragment {
            return RestaurantListFragment().apply {
                arguments = bundleOf(
                    RESTAURANT_CATEGORY_KEY to restaurantCategory
                )
            }
        }
    }

}