package fastcampus.aop.part4.chapter06.screen.main.home

import fastcampus.aop.part4.chapter06.databinding.FragmentHomeBinding
import fastcampus.aop.part4.chapter06.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel by viewModel<HomeViewModel>()

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun observeData() {}

    companion object {
        fun newInstance() = HomeFragment()

        const val TAG = "HomeFragment"
    }

}