package com.buliangren.kotlin.bean

import java.util.*

/**
 * @priject KotlinTour
 * @author LuoXuLiang
 * @description:  自定义访问器  
 * @date: 2017/12/21 下午3:20
 */
class Rectangle(val height: Int, val width: Int) {
    //判断是否是正方形 固定写法
    val isSquare: Boolean
        get() {
            return height == width
        }

    fun createRandomRectangle() : Rectangle{
        val random = Random()
        return  Rectangle(random.nextInt(),random.nextInt())
    }
}