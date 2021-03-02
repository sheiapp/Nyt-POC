package com.example.nytpoc.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.nytpoc.R
import com.example.nytpoc.databinding.FragmentDetailBinding
import com.example.nytpoc.model.Results
import com.example.nytpoc.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    @Inject
    lateinit var glideRequestManager: RequestManager
    private val viewModel by activityViewModels<ViewModel>()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
        showDetail()
        binding.topAppBar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showDetail() {
        viewModel.userClickedData.observe(viewLifecycleOwner, {
            it?.getContentIfNotHandled()?.let { result ->
                setUpView(result)
            }

        })
    }

    private fun setUpView(it: Results) {
        if (!it.media.isNullOrEmpty()) {
            val ordered = it.media[0].media.sortedByDescending { it.height }
            setImage(ordered[0].url)
        }
        binding.title.text = it.title
        binding.abstractData.text = it.abstract
        binding.source.text = it.source
        val url = it.url
        binding.MoreDetailLayout.setOnClickListener {
            openUrl(url)
        }
    }

    private fun setImage(url: String) {
        glideRequestManager
            .load(url)
            .transition(
                DrawableTransitionOptions.withCrossFade(
                    DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
                )
            )
            .into(binding.img)
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        val title = "Select a browser"
        val chooser = Intent.createChooser(intent, title)
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(chooser)
        }
    }
}