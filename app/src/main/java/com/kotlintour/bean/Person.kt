package com.buliangren.kotlin.bean

/**
 * @priject KotlinTour
 * @author LuoXuLiang
 * @description:  定义一个Person类  
 * @date: 2017/12/21 下午2:48
 */
class Person(val name:String, var isMarried: Boolean)

//这里使用不需要写getter setter方法
//Person.name = "LXL" 就相当于Set方法
//Person.name 直接使用就相当于Get方法
