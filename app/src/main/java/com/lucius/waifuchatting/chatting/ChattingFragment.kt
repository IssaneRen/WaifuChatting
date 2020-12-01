package com.lucius.waifuchatting.chatting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucius.comm.base.BaseFragment
import com.lucius.waifuchatting.R

/**
 *
 */
class ChattingFragment : BaseFragment() {
    private val adapter = ChattingAdapter()
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_fragment_main_chatting, container, false)
        recyclerView = view?.findViewById<RecyclerView?>(R.id.recycler_view)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        adapter.addData(ChattingConversationEntity(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SIMPLE))
        adapter.addData(ChattingConversationEntity(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SIMPLE))
        adapter.addData(ChattingConversationEntity(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SIMPLE))
        adapter.addData(ChattingConversationEntity(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SYSTEM))
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChattingFragment()
    }
}