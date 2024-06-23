package toolkit

import javax.swing.JFileChooser

/**
 * 单例模式
 * 注意线程的问题，这个超出我的能力解决范围了
 * 这个类的功能就是通过JFileChooser获取绝对路径(String类型)
 * 只有 getAbsolutePath() 公共方法
 */
object GetUserChosenAbsolutePath {
    private var absolutePath: String = "nothing"

    fun getAbsolutePath(): String {
        this.getSavingAbsolutePath()
        return this.absolutePath
    }


    private fun getSavingAbsolutePath() {
        // 创建 JFileChooser 并设置为只选择目录
        val chooser = JFileChooser()
        chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY


        // 显示文件选择对话框，当成功选择时跳出循环
        while (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {


            println("你必须选择文件夹后才能继续。")
        }
        // 将用户选择的文件夹赋值给成员变量absolutePath
        this.absolutePath = chooser.selectedFile.absolutePath


    }
}


