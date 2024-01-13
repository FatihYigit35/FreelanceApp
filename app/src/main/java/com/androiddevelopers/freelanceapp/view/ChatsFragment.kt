package com.androiddevelopers.freelanceapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevelopers.freelanceapp.R
import com.androiddevelopers.freelanceapp.adapters.ChatAdapter
import com.androiddevelopers.freelanceapp.databinding.FragmentChatsBinding
import com.androiddevelopers.freelanceapp.databinding.FragmentMessagesBinding
import com.androiddevelopers.freelanceapp.model.ChatModel
import com.androiddevelopers.freelanceapp.viewmodel.ChatsViewModel
import com.androiddevelopers.freelanceapp.viewmodel.MessagesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatsFragment : Fragment() {


    private lateinit var viewModel: ChatsViewModel
    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!
    private val adapter = ChatAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ChatsViewModel::class.java]
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabCreateChatRoom.setOnClickListener{
            viewModel.createChatRoom(
                "DvWVkwOYkzSU83ae7UaiNXM3Beg1",
                ChatModel(
                    "mychatroom",
                    "ABF1jc1soJS2Q5YDi5J4CLstayy2",
                    "DvWVkwOYkzSU83ae7UaiNXM3Beg1",
                    "gaffar",
                    "asdasd",
                    "asdasd",
                    "123132"
                )
            )
        }
        viewModel.getChatRooms()
        observeLiveData()
    }


    private fun observeLiveData(){
        viewModel.chatRooms.observe(viewLifecycleOwner, Observer {
            binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
            binding.rvChat.adapter = adapter
            adapter.chatsList = it

        })
    }
}