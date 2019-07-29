package com.dhcc.csr.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @Author: wlsh
 * @Date: 2019/7/24 15:24
 * @Description: 数据类(模拟数据时可给不必要参数默认值避免构造太长)
 */
@Parcelize
data class Item(
    val id: Long,// 主键
    val orderCode: String,// 单号
    val title: String,// 标题 限制50字
    val type: String,// 单据类型 1事项审批
    val status: String,// 状态
    val content: String,// 单据内容
    val processid: String,// 流程ID
    val createTime: String,// 创建时间
    val submitTime: String,// 提交时间
    val closeTime: String,// 关闭时间
    val writePcode: String,// 填写人账号
    val writePname: String,// 填写人姓名
    val traPcode: String,// 出差人工号
    val traPname: String,// 出差人姓名
    val tralevelCode: String,// 差旅级别编码
    val traleveldesc: String,// 差旅级别描述
    val tradeptCode: String,// 出差部门编码
    val tradeptname: String,// 出差部门名称
    val lastProname: String,// 最后出差人姓名
    val lastProtime: String,// 最后审批日期
    val destinationName: String,//出差目的地名称
    val destinationCode: String,//出差目的地编码
    val traStartTime: String,//出差开始日期
    val traEndTime: String,//出差结束日期
    val vehicleId: String,//交通工具编号
    val vehicleName: String,//交通工具名称
    val companyName: String,//公司名称
    val companyCode: String //公司编码
) : Parcelable