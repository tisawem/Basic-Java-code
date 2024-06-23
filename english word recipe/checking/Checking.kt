package checking

import WordsBank
import 出题方式Bank
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.Scanner
import javax.swing.JFileChooser
import javax.swing.JOptionPane
import javax.swing.filechooser.FileNameExtensionFilter

/**
 * 检查wordsBank是否有词库，词库是不是空的
 * 有词库且词库里有单词即可检查通过
 *
 * 单例模式
 *
 * 这个项目目前还都是kotlin代码，非空检查就省略了
 *
 * 未来还有别的验证检查的时候往里面添
 *
 * 未来看情况添加额外的验证
 */
object Checking {




    /**获取有效的词库（即有单词的词库，枚举常量（LinkedHashMap）非空）
     *
     没有有效的词库，那这个词库就是空白*/

    val valuableBank: List<WordsBank>
        get() {
            return WordsBank.entries.filter { it.Bank.isNotEmpty() }
        }




/**配合初始化块使用，只用来在控制台输出词库是空的，还是有无效词库*/
 fun checkWordsBanks() {
        if (WordsBank.entries.isEmpty()){
            println("没有词库")
        }
        WordsBank.entries.forEach { bank ->
            if (bank.Bank.isEmpty()) {
                println("词库：${bank.name}不可用，已移除")
            }
        }
    }



fun checkingListAndMap(  中文列表: ArrayList<String>,
                         英文列表: ArrayList<String>,
                         中英索引表: HashMap<String, String>,
                         英中索引表: HashMap<String, String>):Boolean{

    if (中文列表.size<5){
        println("中文列表太少：至少5个")
        return false
    }
    if (英文列表.size<5){
        println("英文列表太少：至少5个")
        return false
    }
    if (英中索引表.size<5){
        println("英中索引表太少：至少5个")
    return false
    }
    if (中英索引表.size<5){
        println("中英索引表太少：至少5个")
        return false
    }



    中文列表.forEach { if (!中英索引表.containsKey(it)){
        println("“${it}”无法在${中英索引表}中查询到")
        return false
    } }
    英文列表.forEach { if (!英中索引表.containsKey(it)){
        println("“${it}”无法在${英中索引表}中查询到")
        return false
    }

    }
    return true



}
}




