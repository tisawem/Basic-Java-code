import java.io.File
import java.io.FileReader
import javax.swing.JFileChooser
import javax.swing.JOptionPane
import javax.swing.filechooser.FileNameExtensionFilter

 class Generate考题(val 可用词库: List<WordsBank>, val 随机题库: Boolean, val 随机单词: Boolean?) {
    init {
        if (可用词库.isEmpty()) {
            throw IllegalArgumentException("词库为空")
        }
    }

    /**

    执行顺序

    假如词库是： 商务英语，基本英语，日常英语，高级词汇

 内部方法：可复用的代码

     遍历可用词库，提取词库的键（英文单词），保存为临时列表
    如果打乱单词==true，那么先把临时列表打乱，再添加进准备的list
     如果是false或null，直接把词库里的单词添加进准备的list

如果打乱单词是null，那么“准备的list”全部打乱再当返回值
     */

    private fun set英文(): ArrayList<String> {
        val 可用词库备份 = ArrayList(this.可用词库)
        val 准备的list = ArrayList<String>()
        // 封装复用的代码逻辑为内部方法
        fun 可复用的代码() {
            for (v in 可用词库备份) {
                val temp1 = ArrayList(v.Bank.keys)  // 使用 ArrayList 以便使用 shuffle 方法
                随机单词?.let {
                    if (it){
                        temp1.shuffle()
                    }
                }
                准备的list.addAll(temp1)
            }
        }
        // 根据随机题库标志位选择执行路径
        when (this.随机题库) {

            true -> {
                可用词库备份.shuffle()  // 随机词库顺序
                可复用的代码()
            }
            false -> {
                可复用的代码()
            }
        }
        if (随机单词==null){
            准备的list.shuffle()
        }

        return 准备的list
    }

     /**
      * 必须先初始化“英文”list
      *
      * 把所有的题库里面的键值对都放在一个临时的Map上
      *
      * 再把所有英文，上临时的map上查找汉译，按顺序存放临时的list
      *
      */
     private fun set中文(): ArrayList<String> {
         val tempMap = HashMap<String, String>()  //所有词库的键值对
         val tempList = ArrayList<String>()
         可用词库.forEach { it.Bank.forEach { (t, u) -> tempMap[t] = u } }
         this.英文.forEach {
             tempMap[it]?.let { it1 -> tempList.add(it1) }
         }
         return tempList
     }

    private var 英文: ArrayList<String> = set英文()
    private var 中文: ArrayList<String> = set中文()



    fun get中文() = 中文
    fun get英文() = 英文

    fun get中英索引表():HashMap<String,String>{
     val tempMap= HashMap<String, String>()
      for ((index,value) in 中文.withIndex()){
          tempMap[value] = 英文[index]
      }
        return tempMap
    }

    fun get英中索引表():HashMap<String,String>{
        val tempMap= HashMap<String, String>()
        for ((index,value) in 英文.withIndex()){
            tempMap[value] = 中文[index]
        }
        return tempMap
    }
}

/**
 * 假如存储英文和汉译用的map
 * 让用户打开的两个文件，一个是key，一个是value
 * 这个类提防了key和value有重复值
 */
class 基于两个文本文档Generate考题(private val 是否随机单词:Boolean?){
    private fun getFile(): File {

        val chooser = JFileChooser()
        chooser.fileSelectionMode = JFileChooser.FILES_ONLY
        val filter = FileNameExtensionFilter("文本文件", "txt")
        chooser.addChoosableFileFilter(filter)
        chooser.isAcceptAllFileFilterUsed = false

        while (true) {
            val result = chooser.showOpenDialog(null)
            if (result == JFileChooser.APPROVE_OPTION) {
                val selectedFile = chooser.selectedFile
                if (selectedFile.canRead()) {
                    return selectedFile
                } else {
                    JOptionPane.showMessageDialog(null, "文件不可读，请选择其他文件。")
                }
            } else if (result == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "操作已取消，必须选择文件。")
            }
        }
    }



    val get英中索引表 by lazy {
        getMap()
    }

    val get中英索引表 by lazy {
        LinkedHashMap<String, String>().apply {
            get英中索引表.forEach { (t, u) -> this[u] = t }
        }
    }

    val get中文 by lazy {
        ArrayList(get中英索引表.keys).also { list ->
            if (是否随机单词!=false) list.shuffle()
        }
    }

    val get英文 by lazy {
        ArrayList(get英中索引表.keys).also { list ->
            if (是否随机单词!=false) list.shuffle()
        }
    }

    private fun getMap(): LinkedHashMap<String, String> {
        val tempMap = LinkedHashMap<String, String>()
        println("选择单词的文本文档")
        val key = FileReader(getFile()).readLines()
        println("选择汉译的文本文档")
        val value = FileReader(getFile()).readLines()

        if (key.size != value.size) {
            throw Exception("两个txt文件的单词和汉译对不上")
        }
        if (key.size != key.toSet().size) {
            throw Exception("有重复英文单词")
        }
        if (value.size != value.toSet().size) {
            throw Exception("有重复的汉译")
        }

        key.zip(value).forEach { (k, v) ->
            tempMap[k] = v
        }
        return tempMap
    }
}