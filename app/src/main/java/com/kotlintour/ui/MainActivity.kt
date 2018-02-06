package com.kotlintour.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.buliangren.kotlin.bean.Person
import com.buliangren.kotlin.bean.Rectangle
import com.buliangren.kotlin.enumandwhen.Color
import com.buliangren.kotlin.enumandwhen.Expr
import com.kotlintour.R
import com.orhanobut.logger.Logger
import java.util.*

/**
 * @priject KotlinTour
 * @author LuoXuLiang
 * @description:  MainActivity  
 * @date: 2017/12/21 下午3:20
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.i("MainActivity:result 01-->" + max(1, 3))
        Logger.i("MainActivity:result 02-->" + max02(5, 10))
        Logger.i("MainActivity:result 03-->" + max03(3, 9))

        template()   //字符串模板

        attributes()  //属性

        access() //自定义访问器

        enumAndWhen()  //枚举类

        Logger.i("(1+2)+4 Result:-->" + eval(Expr.Sum(Expr.Num(1), Expr.Num(2))))

        cycle()   //循环
    }
    /**********函数*************/
    /**
     * 基本写法
     */
    private fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    /**
     * 表达式函数体 写法 不需要花括号 以及return
     */
    private fun max02(a: Int, b: Int): Int = if (a < b) a else b

    /**
     * 通过类型推导,进一步简化,不需要定义数据返回类型
     */
    private fun max03(a: Int, b: Int) = if (a < b) a else b


    /**********变量*************/
    /**
     * 可变量和不可变量
     * val (来自value) ----------不可变引用  对应java final
     * var (来自 variable) ------可变引用    非java final
     *
     */
    val question = "The Ultimate Question of Life, the Universe, and Everything"
    val answer = 42
    var answers: Int = 42

    var number = 12
    private fun variable() {
        //number = "String"   这种写法编译器不会通过
    }


    /**********字符串模板*************/
    private fun template() {
        val a = 10
        val name = if (a > 0) a else 5
        Logger.i("Hello,$name!")
        //或者使用更复杂的表达式 ${这里面可以写表达式}
    }

    /**********属性*************/
    private fun attributes() {
        val person = Person("BLR", false)
        Logger.i("attributes-->" + person.name + "," + person.isMarried)

    }

    /************自定义访问器***********/
    private fun access() {
        val rectangle = Rectangle(20, 30)
        Logger.i("isSquare-->" + rectangle.isSquare)
        Logger.i("createRandomRectangle-->" + rectangle.createRandomRectangle().isSquare)
    }

    /**
     * 枚举 和 "when"
     */
    private fun enumAndWhen() {
        Logger.i("RGB-->" + Color.RED.rgb() + "," + getMnemonic(Color.YELLOW))
    }

    /**
     * When 相当于Switch 不需要每个写break结束语句
     */
    private fun getMnemonic(color: Color) {
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "Yellow"

        }
    }

    /**
     * is 检查来判断一个变量是否是某种数据类型
     */
    private fun eval(e: Expr): Int =
            /*if (e is Expr.Num) {
                val n = e as Expr.Num
                return n.value
            }
            if (e is Expr.Sum) {
                return eval(e.right) + eval(e.left)
            }
            throw IllegalArgumentException("Unknow expression")*/

            //使用when代替if层叠
            when (e) {
                is Expr.Num -> e.value
                is Expr.Sum -> eval(e.right) + eval(e.left)
                else -> throw IllegalArgumentException("Unknow expression")
            }


    /**
     * 循环迭代事物 "while" 循环和 "for" 循环
     * for...in
     * Fizz-Buzz游戏
     *     |
     *     |
     *     ↓
     */
    private fun cycle(){
        //1到100累加
        for (i in 1..100){
            Log.e("cycle-->",fizzBuzz(i))
        }

        //从100倒着计数,并且只计偶数
        for (i in 100 downTo 1 step 2){
            Log.e("Fizz-Buzz 倒数-->",fizzBuzz(i))
        }

        mapStudy()
    }

    /**
     * 用When实现 Fizz-Buzz游戏
     */
    private fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "FizzBuzz" //如果一个数字是3和5的公倍数 用FizzBuzz代替
        i % 3 == 0 -> "Fizz"    //能被3整除用fizz代替
        i % 5 == 0 -> "Buzz"    //能被5整除用Buzz代替
        else -> "$i"
    }

    /**
     * 迭代Map
     * 打印出 A~F 二进制
     */
    private fun mapStudy(){
        val binaryReps = TreeMap<Char,String>()   //使用TreeMap 让建排序
        for (c in 'A'..'F'){  //使用字符区间迭代从A到F之间的字符
            val binary  = Integer.toBinaryString(c.toInt())   //把 ASC II码转换成二进制
            binaryReps[c] = binary  //根据键C把值存储到map中
        }
        for ((letter,binary) in binaryReps){  //迭代map,把键和值赋值给两个变量
            Log.e("Map-->","$letter = $binary")
        }
        mapStudy02()
    }

    /**
     * 遍历打印下标  withIndex
     */
    private fun mapStudy02(){
        val list = arrayListOf("123","456","789")
        for ((index,element) in list.withIndex()){   //遍历集合使用下标
            Log.e("Map02-->","$index = $element")
        }

        Log.e("isLetter-->",""+isLetter('c'))
        Log.e("isNotDigit-->",""+isNotDigit('8'))
        Log.e("recognize-->",""+recognize('n'))
        tryCatch()
    }

    /**
     * 使用 "in" 检查集合和区间的成员
     */
    private fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    private fun isNotDigit(c:Char) = c !in '0'..'9'

    private fun recognize(c: Char) = when(c){
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' ->"It's a letter1"
        else -> "I down Know..."
    }

    /**
     * Kotlin 中的异常
     */
    private fun tryCatch(){
//        val percentage =
//                if (number !in 0..100)
//                    number
//                else
//                    throw  IllegalArgumentException(
//                            "A percentage 0 and 100 $number"
//                    )
    }


}
