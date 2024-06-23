import java.util.LinkedHashMap

enum class WordsBank(val Bank: LinkedHashMap<String, String>) {
    高职国际英语2(LinkedHashMap<String, String>().apply {

        put("rough","高低不平的，粗糙的")

        put("severe","严峻的，剧烈的")

        put("manufacture","制造，加工")

        put("well-known","著名的")

        put("producer","生产者")

        put("vehicle","车辆")

        put("construction","建筑")

        put("machinery","机器，器械")

        put("motor","汽车，发动机")

        put("profit","利润")

        put("deal","交易")

        put("manufacturer","制造商，厂商")

        put("essential","必要的")

        put("global","全球的")

        put("regulation","规章制度")

        put("jointly","联合地，共同地")

        put("thus","因此")

        put("base","基础")

        put("invest","投资")

        put("million","百万")

        put("production","生产")

        put("know-how","实际知识，技能")

        put("turnover","营业额")

        put("whereas","然而，但是")

        put("export","出口")

        put("development country","发展中国家")

        put("thirdly","第三")

        put("automobile","汽车")

        put("plan","计划")

        put("optimistic","乐观的，乐观主义的")


    }),
    基础英语(LinkedHashMap<String, String>().apply {
        put("simple", "简单的")
    }),
    高级英语(LinkedHashMap<String, String>().apply {
        put("complex", "复杂的")
    }),
    商务英语(LinkedHashMap<String, String>().apply {
        put("negotiate", "谈判")
    }),
    日常英语(LinkedHashMap<String, String>().apply {
        put("hello", "你好")
    }),
    技术英语(LinkedHashMap<String, String>().apply {
        put("algorithm", "算法")
    }),;

}


enum class 出题方式Bank(val 出题方式:考法){
    给汉译选英文(给汉译选英文()),
    给英文选汉译(给英文选汉译()),
    先给英文再给汉译(先给英文再给汉译()),
    先给汉译再给英文(先给汉译再给英文()),;
}