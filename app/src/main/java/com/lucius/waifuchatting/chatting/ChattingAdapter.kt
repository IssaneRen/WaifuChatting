package com.lucius.waifuchatting.chatting

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lucius.waifuchatting.R

class ChattingAdapter() : BaseMultiItemQuickAdapter<ChattingConversationEntity, BaseViewHolder>() {
    init {
        addItemType(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SIMPLE, R.layout.app_item_chatting_conversation_simple)
        addItemType(TYPE_ENTITY_CHATTING_RAW_MESSAGE_SYSTEM, R.layout.app_item_chatting_conversation_simple)
    }

    override fun convert(holder: BaseViewHolder, item: ChattingConversationEntity) {
        // todo 修改内容
    }
}