package com.lucius.waifuchatting.chatting

import android.widget.TextView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lucius.waifuchatting.R

class ChattingAdapter() : BaseMultiItemQuickAdapter<ChattingConversationEntity, BaseViewHolder>() {
    init {
        addItemType(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SIMPLE, R.layout.app_item_chatting_conversation_simple)
        addItemType(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SYSTEM, R.layout.app_item_chatting_conversation_simple)
    }

    override fun convert(holder: BaseViewHolder, item: ChattingConversationEntity) {
        // todo 修改内容
        // 1. 修改 个人/群 信息相关（头像、姓名、所属地）
        holder.getView<TextView>(R.id.tv_name).text = "镜华"
//        MyApplication.instance?.let {
//            holder.getView<ImageView>(R.id.iv_avatar).setImageDrawable(
//                ContextCompat.getDrawable(it, R.drawable.brvah_sample_footer_loading)
//            )
//        }
        holder.getView<TextView>(R.id.tv_organization_and_title).text = "PCR | xcw"


        // 2. 修改对话相关 基本信息 （未读数、最近消息、最新消息时间）
        holder.getView<TextView>(R.id.tv_msg_count).text = "99+"
        holder.getView<TextView>(R.id.tv_snd_content).text = "如果你这样方便的话，那我们就之后那里见吧~"
        holder.getView<TextView>(R.id.tv_time).text = "6分钟前"
    }
}