package com.lucius.waifuchatting.chatting

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.lucius.comm.base.BaseFragment
import com.lucius.waifuchatting.MyApplication
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
        val decoration = object : ItemDecoration() {
            private var marginLeft = 0
            private var marginRight = 0
            private var mDecorationHeight = 0
            private var mPaint: Paint? = null

            init {
                this.marginLeft = marginLeft
                this.marginRight = marginRight
                mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
                mPaint?.color = Color.parseColor("#E9E9E9")
                mPaint?.style = Paint.Style.FILL
                mDecorationHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.5f, MyApplication.instance?.resources?.displayMetrics).toInt()
            }


            override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDrawOver(c, parent, state)
                val childCount = parent.childCount
                for (i in 0 until childCount - 1) {
                    val child = parent.getChildAt(i)
                    val left: Int = child.left + marginLeft
                    val right: Int = child.right - marginRight
                    val top = child.bottom
                    val bottom: Int = top + mDecorationHeight
                    mPaint?.let { c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), it) }
                }
            }
        }

        recyclerView?.addItemDecoration(decoration)

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