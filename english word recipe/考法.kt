import kotlin.random.Random
@FunctionalInterface
interface 考法 {

fun start(   中文: String,
             英文:  String,
             中英索引表: HashMap<String, String>,
             英中索引表: HashMap<String, String>)

}

/**
 * Finished by Tisawem
 */

class 给汉译选英文 : 考法 {
    override fun start(
        中文: String,
        英文:  String,
        中英索引表: HashMap<String, String>,
        英中索引表: HashMap<String, String>
    ) {

        val tempSet=HashSet<String?>()//用于存储4个英文选项
        var tempList=ArrayList(中英索引表.values)//用于抽取其他三个错误选项
        tempSet.add(中英索引表[中文])
      while (tempSet.size!=4){
          val tNum= Random.Default.nextInt(0,tempList.size)
          tempSet.add(tempList[tNum])
      }
        tempList= ArrayList(tempSet)//这回tempList变成4个英文选项，而不是索引表的所有英文单词

        while (tempList.size>1){
            println("\n${中文}")
            tempList.withIndex().forEach { (i,v)->
                println("${i+1}、${v}")
            }
            val tempRead= readlnOrNull()
            if (tempRead==null){
                println("重新输入选项")
                continue
            }
            val tempNum=tempRead.toIntOrNull()
            if (tempNum==null){
                println("重新输入选项")
                continue
            }
            if (tempNum<1||tempNum>tempList.size){
                println("重新输入选项")
                continue
            }
if (英中索引表[tempList[tempNum-1]] !=中文){
    println("回答错误")
    tempList.removeAt(tempNum-1)
    continue
}else{
    println("回答正确：“${中文}->${中英索引表[中文]}”\n")
    return
}


        }

println("正确答案：${中英索引表[中文]}")



    }



}

class 给英文选汉译 : 考法 {
    override fun start(
        中文: String,
        英文:  String,
        中英索引表: HashMap<String, String>,
        英中索引表: HashMap<String, String>
    ) {
       给汉译选英文().start(英文,中文,英中索引表,中英索引表)
    }

}

class 先给英文再给汉译 : 考法 {
    override fun start(
        中文: String,
        英文:  String,
        中英索引表: HashMap<String, String>,
        英中索引表: HashMap<String, String>
    ) {
      println("输入任意字符查看翻译\n$英文")
        readlnOrNull()
        println("“"+英文+" ”的翻译是“ "+英中索引表[英文]+"”\n")

    }

}

class 先给汉译再给英文 : 考法 {
    override fun start(
        中文: String,
        英文:  String,
        中英索引表: HashMap<String, String>,
        英中索引表: HashMap<String, String>
    ) {
先给英文再给汉译().start(英文,中文,英中索引表,中英索引表)
    }

}

/**
 * Finished by ChatGPT 4
 */
class 中译英 :考法{
    override fun start(
        中文: String,
        英文: String,
        中英索引表: HashMap<String, String>,
        英中索引表: HashMap<String, String>
    ) {
        println("请翻译：$英文\n")
        val userAnswer = readln()
        if (userAnswer.trim().equals(英中索引表[英文], ignoreCase = true)) {
            println("正确！${英文}的正确答案是：${英中索引表[英文]}")
        } else {
            println("错误！${英文}的正确答案是：${英中索引表[英文]}\n")
        }
    }

}

class 英译中:考法{
    override fun start(
        中文: String,
        英文: String,
        中英索引表: HashMap<String, String>,
        英中索引表: HashMap<String, String>
    ) {
      中译英().start(英文,中文,英中索引表,中英索引表)
    }

}