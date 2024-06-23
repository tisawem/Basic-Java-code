package toolkit

import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.*

/**

 * 得到绝对路径，在该目录创建文本文件，问询用户单词和汉译，写入文本，最终得到一个枚举常量
 */
open class CreateEnumconstance {


//全局文件，以免再次创建新的txt文件
protected val txtfile=this.createFile()
    /**
     * 创建一个txt文件，从GetUserChosenAbsolutePath类得到用户选择的文件夹
     * 然后问询用户，得到文件名字，创建一个空txt文件
     * 返回值为该txt文件
     */
    protected fun createFile():File{
        println("选择保存路径")
        val path=GetUserChosenAbsolutePath.getAbsolutePath()

        println("给文件起个名字")
        val filename= readln() +".txt"




        try {
            FileWriter("$path/$filename")
            return File("$path/$filename")
        } catch (e: IOException) {
            println("写入文件时发生错误: " + e.message)
     throw e
        }
    }

    /**
     * 问询用户输入，往文件里写内容
     * 直到用户输入no more content，写入停止
     */
    open fun create(){
        println("给枚举常量起个名字")

        val enumName= Scanner(readln()).next()
        writeContent("$enumName(LinkedHashMap<String, String>().apply {\n"+System.lineSeparator())

        var input: String
        while (true){
            println("输入单词,输入no more content结束")
            input= readln()
            if (java.lang.String(input).equalsIgnoreCase("no more content") ){

                writeContent(System.lineSeparator()+"}),")
                return
            }else{

                writeContent("put(\"${input}\",\"")
                println("输入汉译")
              writeContent("${readln()}\")\n"+System.lineSeparator())
            }

        }

    }

    /**
     * 第一个形参content的内容将在文件的末尾写入
     *  file的默认值为本类的createFile()方法
     *
     */
    protected fun writeContent(content:String, file: File=this.txtfile):File{



        val fileWriterInstance=FileWriter(file,true)
        try {
           fileWriterInstance.use { fileWriter ->
                fileWriter.write(content)

 return file
            }
        } catch (e: IOException) {
            println("写入文件时发生错误: " + e.message)
            throw e
        }


    }
}

/**
 * 这一回是创建两个文本文件
 * 相较于CreateEnumconstance，
 * 就是把key和value掰开
 * 分别放在两个文本文件
 */
class CreateTwoTxtOneIs单词AndAnotherIs汉译Contents : CreateEnumconstance() {
    private val txtfile1=this.createFile()

    override fun create(){
        println("输入英文")
        var temp1: String
        while (true){
            println("输入单词,输入no more content结束")
            temp1= readln()
            if (java.lang.String(temp1).equalsIgnoreCase("no more content") ){
                return
            }else{

                writeContent(temp1+System.lineSeparator())
                println("输入汉译")
                writeContent(readln() +System.lineSeparator(),txtfile1)
            }

        }


    }
}

fun main(){
  println("1、枚举 2、两个txt文件 其他、结束程序")
    when(readln().toIntOrNull()){
        1->CreateEnumconstance().create()
        2->CreateTwoTxtOneIs单词AndAnotherIs汉译Contents().create()
        else-> return
    }
}
