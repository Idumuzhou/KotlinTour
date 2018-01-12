package com.buliangren.kotlin.enumandwhen

/**
 * @priject KotlinTour
 * @author LuoXuLiang
 * @description:  description 
 * @date: 2017/12/21 下午4:52
 */
interface Expr {
    class Num(val value: Int) : Expr
    class Sum(val left:Expr,val right:Expr) : Expr
}