package fastcampus.aop.part4.chapter06.screen.main.my

import fastcampus.aop.part4.chapter06.databinding.FragmentMyBinding
import fastcampus.aop.part4.chapter06.screen.base.BaseFragment
import fastcampus.aop.part4.chapter06.screen.main.home.HomeFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MyFragment : BaseFragment<MyViewModel, FragmentMyBinding>() {
    override val viewModel by viewModel<MyViewModel>()

    override fun getViewBinding(): FragmentMyBinding = FragmentMyBinding.inflate(layoutInflater)

    override fun observeData() {}

    companion object {
        fun newInstance() = MyFragment()

        const val TAG = "MyFragment"
    }

}