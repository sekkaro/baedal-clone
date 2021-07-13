package fastcampus.aop.part4.chapter06.screen.main.home

import com.google.android.material.tabs.TabLayoutMediator
import fastcampus.aop.part4.chapter06.databinding.FragmentHomeBinding
import fastcampus.aop.part4.chapter06.screen.base.BaseFragment
import fastcampus.aop.part4.chapter06.screen.main.home.restaurant.RestaurantCategory
import fastcampus.aop.part4.chapter06.screen.main.home.restaurant.RestaurantListFragment
import fastcampus.aop.part4.chapter06.widget.adapter.RestaurantListFragmentPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel by viewModel<HomeViewModel>()

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    private lateinit var viewPagerAdapter: RestaurantListFragmentPagerAdapter

    override fun initViews() {
        super.initViews()
        initViewPager()
    }

    private fun initViewPager() = with(binding) {
        val restaurantCategories = RestaurantCategory.values()
        if (::viewPagerAdapter.isInitialized.not()) {
            val restaurantListFragmentList = restaurantCategories.map {
                RestaurantListFragment.newInstance(it)
            }
            viewPagerAdapter = RestaurantListFragmentPagerAdapter(
                this@HomeFragment,
                restaurantListFragmentList
            )
            viewPager.adapter = viewPagerAdapter
        }
        viewPager.offscreenPageLimit = restaurantCategories.size
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(restaurantCategories[position].categoryNameId)
        }.attach()
    }

    override fun observeData() {}

    companion object {
        fun newInstance() = HomeFragment()

        const val TAG = "HomeFragment"
    }

}