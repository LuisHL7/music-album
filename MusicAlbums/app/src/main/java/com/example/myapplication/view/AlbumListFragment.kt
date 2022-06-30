package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentAlbumListBinding
import com.example.myapplication.view.adapter.AlbumAdapter
import com.example.myapplication.viewModel.AlbumViewModel
import com.google.android.material.snackbar.Snackbar

class AlbumListFragment : Fragment() {

    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!
    private val albumViewModel by activityViewModels<AlbumViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerAlbum
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        albumViewModel.albumList.observe(viewLifecycleOwner) {
            if(it.size == 0){
                showMessageEmptyList()
            } else {
                recyclerView.adapter = AlbumAdapter(it, albumViewModel)
            }
        }
    }

    private fun showMessageEmptyList() = Snackbar.make(binding.root,
        "There are no discs in the current selection", Snackbar.LENGTH_LONG)
        .setAction("Return") {
            findNavController().navigateUp()
        }.show()
}