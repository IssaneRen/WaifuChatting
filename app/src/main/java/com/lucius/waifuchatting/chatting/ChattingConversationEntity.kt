package com.lucius.waifuchatting.chatting

import com.chad.library.adapter.base.entity.MultiItemEntity

const val TYPE_ENTITY_CHATTING_RAW_MESSAGE_SIMPLE = 0x01  // 基础对话框
const val TYPE_ENTITY_CHATTING_RAW_MESSAGE_SYSTEM = 0x02  // 一般性 系统消息

/**
 * 原始的 conversation 实体类。 有不同的type来决定不同的显示。每一个实例对应一个对话。
 */
class ChattingConversationEntity(override val itemType: Int) : MultiItemEntity {
    var name: String? = null
    var recentMsg: String? = null
    var sessionId: Long = 0
}