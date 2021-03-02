package com.example.nytpoc.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.RequestManager
import com.example.nytpoc.R
import com.example.nytpoc.databinding.FragmentListBinding
import com.example.nytpoc.model.Results
import com.example.nytpoc.utils.adapter.RecyclerViewAdapter
import com.example.nytpoc.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {
    @Inject
    lateinit var glideRequestManager: RequestManager
    private val viewModel by activityViewModels<ViewModel>()
    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter(glideRequestManager) { clickedItem ->
            clickEvent(
                clickedItem
            )
        }
    }
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)
        viewModel.getApiData()
        setupRecyclerView()
        observeData()
    }

    private fun observeData() {
        viewModel.nytResultData.observe(viewLifecycleOwner) {
            it?.getContentIfNotHandled()?.let { listOfData ->
                adapter.submitList(listOfData)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun clickEvent(results: Results) {
        viewModel.userClickedData(results)
        gotoDetailPage()
    }

    private fun gotoDetailPage() {
        val gotoDetailPage = ListFragmentDirections.actionListFragmentToDetailFragment()
        findNavController().navigate(gotoDetailPage)
    }


}