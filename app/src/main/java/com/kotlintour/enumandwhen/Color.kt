package com.buliangren.kotlin.enumandwhen

/**
 * @priject KotlinTour
 * @author LuoXuLiang
 * @description:  颜色 简单枚举类 
 * @date: 2017/12/21 下午4:19
 */
enum class Color(var r: Int, var g: Int, var b: Int) {
    //这是唯一必须使用分号的地方
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}