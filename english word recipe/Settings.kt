import checking.Checking
import kotlin.collections.ArrayList



object Settings {



    private val 可用词库 : List<WordsBank> by lazy {
        val checking =Checking
        checking.checkWordsBanks()
        if (checking.valuableBank.isEmpty()) {
            throw IllegalStateException("没有可用词库，请你完善词库")
        }
    return@lazy  checking.valuableBank
    }



    @JvmName("getAvailableWordsBank")
    fun get可用词库(): List<WordsBank> {
        if (可用词库.size == 1) {
            println("使用词库：${可用词库[0].name}")
            return 可用词库
        }

        val tempList = ArrayList<WordsBank>()
        val tempList1 = ArrayList(可用词库)

        while (tempList1.isNotEmpty()) {
            println("选择词库，-1全选，0结束选择")
            tempList1.forEachIndexed { index, bank ->
                println("${index + 1}、${bank.name}")
            }

            val input = readlnOrNull()
            val choice = input?.toIntOrNull()

            when {
                input == null || choice == null -> {
                    println("无效输入，请输入数字。")
                    continue
                }
                choice == -1 -> {
                    println("已全选所有词库。")
                    return 可用词库
                }
                choice == 0 -> {
                    if (tempList.isEmpty()) {
                        println("你还没有添加任何词库。")
                    } else {
                        println("你选择了以下词库：")
                        tempList.forEach { println(it.name) }
                        return tempList
                    }
                }
                choice > 0 && choice <= tempList1.size -> {
                    val selectedBank = tempList1[choice - 1]
                    tempList.add(selectedBank)
                    tempList1.removeAt(choice - 1)
                    println("已添加：${selectedBank.name}")
                }
                else -> println("输入数字超出范围，请重新输入。")
            }
        }

        // 如果 tempList1 为空，则返回 tempList
        return 可用词库

    }

    fun 是否随机题库(): Boolean {

       if (可用词库.size==1){
           return  false
       }
        while (true) {
            println(
                """
        选择模式：
        1、按照你选择的题库顺序
        2、随机题库
    """.trimIndent()
            )
            val temp1 = readln()
            when (temp1.toIntOrNull()) {
                1 -> {
                   return false
                }

                2 -> {
                   return true
                }

                else -> {
                    println("${temp1}无效，重新选择")
                }
            }

        }

    }

    fun 是否随机单词(): Boolean? {
        while (true) {
            print(
                """
        
        1、打乱题库里的单词
        2、顺序出词
        
    """.trimIndent()
            )
            if (this.可用词库.size > 1) {
                println("3、所有要考的单词全部打乱")
            }
            val temp1 = readln()
            when (temp1.toIntOrNull()) {
                1 -> {
                    return true
                }

                2 -> {
                   return false
                }

                3 -> {
                    if (this.可用词库.size > 1) {
                        return null
                    }
                    println("${temp1}无效，重新选择")
                }

                else -> {
                    println("${temp1}无效，重新选择")
                }
            }

        }
    }

    fun get出题方式(): Set<考法> {
        val 实现了interface_考法_的实例=HashSet<考法>()
        出题方式Bank.entries.forEach{
            实现了interface_考法_的实例.add(it.出题方式)
        }
        if (实现了interface_考法_的实例.isEmpty()) {
            throw IllegalStateException("没有出题方式，请补充出题方式")
        }
        if (实现了interface_考法_的实例.size == 1) {
            println("出题方式：${出题方式Bank.entries[0].name}")

            return 实现了interface_考法_的实例.toSet()
        }


        val tempList1 = ArrayList(实现了interface_考法_的实例)
        val 出题方式=ArrayList<考法>( )
        while (tempList1.isNotEmpty()) {
            println("选择出题方式,输入-1代表使用所有出题方式，输入0结束")
            for ((index, value) in tempList1.withIndex()) {
                println("${index + 1}、${value}")

            }
            val tempReadln = readln()
            when (tempReadln.toIntOrNull()) {
                null -> {
                    println("“${tempReadln}”输入无效，重新输入")
                    continue
                }

                -1 -> {

                 return 实现了interface_考法_的实例.toSet()
                }

                0 -> {
                    if ( 出题方式.isEmpty()) {
                        println("你还没有选择出题方式")
                        continue
                    } else {
出题方式.forEach { println("已选择：$it") }

                        return 出题方式.toSet()
                    }
                }

                else -> {
                    if (tempReadln.toInt()>=1&&tempReadln.toInt()<=tempList1.size) {
                        println("已选中${tempList1[tempReadln.toInt() - 1]}")
                         出题方式.add(tempList1[tempReadln.toInt() - 1])
                        tempList1.removeAt(tempReadln.toInt() - 1)
                    } else {
                        println(tempReadln+"不在范围内")
                        continue
                    }
                }

            }
        }
        return 实现了interface_考法_的实例.toSet()

    }
}












 


