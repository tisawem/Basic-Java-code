import java.util.*
import kotlin.random.Random

class Core(
    val 出题方式: Set<考法>,

    val 中文列表: ArrayList<String>,
    val 英文列表: ArrayList<String>,
    val 中英索引表: HashMap<String, String>,
    val 英中索引表: HashMap<String, String>
) {
    init {
        if (出题方式.isEmpty()){
            throw IllegalArgumentException("没有出题方式")
        }

        if (!checking.Checking.checkingListAndMap(中文列表,英文列表,中英索引表,英中索引表)){
            throw IllegalArgumentException()
        }


    }




    fun start() {
        val 考法 = 出题方式.toList()
while (中文列表.isNotEmpty()&&英文列表.isNotEmpty()){
    val randomNum= Random.Default .nextInt(0,考法.size)
    考法[randomNum].start(中文列表[0],英文列表[0],中英索引表,英中索引表)
    中文列表.removeFirst()
    英文列表.removeFirst()
}

    }


}

fun main() {
    println("科技是人的第一生产力，会写代码，就避免了购买英语单词机的开销\n本程序使用kotlin代码编写\n作者：Tisawem東北項目，许可证： GNU General Public License v3.0\n ")



        println("true:内建单词表，false：自选单词表（一个英文一个汉译）,其他:退出程序")
        val temp = readln()
        val b=Settings
        when (temp.lowercase(Locale.getDefault()).toBooleanStrictOrNull()) {
            true -> {

                val a=Generate考题(b.get可用词库(),b.是否随机题库(),b.是否随机单词())


Core(b.get出题方式(),a.get中文(),a.get英文(),a.get中英索引表(),a.get英中索引表()).start()
            }
            false -> {
val a=基于两个文本文档Generate考题(b.是否随机单词())
Core(b.get出题方式(),a.get中文,a.get英文,a.get中英索引表,a.get英中索引表).start()

            }
            else -> return
        }
    }


