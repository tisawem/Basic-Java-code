import java.util.Arrays;

/**
 * 建议使用“文字集_factortyMethod”，实现封装
 */
enum 存储已实现的语言的枚举 {
    zh_CN(new zh_CN());
    private 文字集 文字集;

    存储已实现的语言的枚举(文字集 文字集) {
        this.文字集 = 文字集;
    }

    public 文字集 获取文字集() {

        return 文字集;
    }

}

interface 文字集 {
      String  你没有选上所有正确选项();
    String linkedhashmap没有元素();

    String linkhashmap为null();

    String 请输入有效数字(int 最小值$包含, int 最大值$不包含);

    String 不接受null值的Arraylist();

    String 不接受没有元素的Arraylist();

    String 数字范围不对(int 最小值$包含, int 最大值$不包含);

    String 传入的泛型非法(Object 泛型);


    String  恭喜答对();

     String  很遗憾答错();
    String 正确答案如下();
    String 选完所有的正确答案();
    String 你是一个都没答对();
    String 还剩下几个答案();
    String 这是单选题();
    String 这是多选题();




}

class zh_CN implements 文字集 {


    @Override
    public String 你没有选上所有正确选项() {
        return "你没有选上所有正确选项";
    }

    @Override
    public String linkedhashmap没有元素() {
        return "linkedhashmap没有元素";
    }

    @Override
    public String linkhashmap为null() {
        return "linkhashmap为null";
    }


    @Override
    public String 请输入有效数字(int 最小值$包含, int 最大值$不包含) {
        return STR."""
请输入不带小数点、半角、阿拉伯数字
而且输入的数字范围是:
从\{最小值$包含}(包含)到\{最大值$不包含}(不包含)
""";
    }

    @Override
    public String 不接受null值的Arraylist() {
        return "不接受null值的Arraylist";
    }

    @Override
    public String 不接受没有元素的Arraylist() {
        return "不接受没有元素的Arraylist";
    }

    @Override
    public String 数字范围不对(int 最小值$包含, int 最大值$不包含) {
        return STR."""
输入数字范围不对
范围是:
从\{最小值$包含}(包含)到\{最大值$不包含}(不包含)
""";
    }

    @Override
    public String 传入的泛型非法(Object 泛型) {
        return STR."传入的泛型:\{泛型}非法";
    }

    @Override
    public String 恭喜答对() {
        return "恭喜你答对了";
    }

    @Override
    public String 很遗憾答错() {
        return "很遗憾，选错了";
    }

    @Override
    public String 正确答案如下() {
        return "正确的答案如下:";
    }

    @Override
    public String 选完所有的正确答案() {
        return "恭喜你，你已经选完所有的正确答案。";
    }

    @Override
    public String 你是一个都没答对() {
        return "很遗憾，你是一个都没答对。\n你把所有的错误选项都选上了，再接再厉";
    }

    @Override
    public String 还剩下几个答案() {
        return "还剩下";
    }

    @Override
    public String 这是单选题() {
        return "这是单选题";
    }

    @Override
    public String 这是多选题() {
        return "这是多选题";
    }
}

public class 文字集_factortyMethod {
    private static String 全局语言 = "zh_CN";

    private 文字集_factortyMethod() {

    }

    public static void set全局语言(String 全局语言) {
        文字集_factortyMethod.全局语言 = new 文字集_factortyMethod().获取正确的语言名字(全局语言);
    }

    public static 文字集 get文字集() {


        return 存储已实现的语言的枚举.valueOf(全局语言).获取文字集();


    }

    private String 获取正确的语言名字(String languageName) {
        if (languageName == null) {
            throw new IllegalArgumentException("语言名不能为null");
        }


        for (存储已实现的语言的枚举 文字集 : 存储已实现的语言的枚举.values()) {
            if (文字集.name().equalsIgnoreCase(languageName)) {
                return 文字集.name();
            }

        }

        throw new IllegalArgumentException(STR."""
未找到对应语言的实现:\{languageName}
可用语言：
\{Arrays.toString(存储已实现的语言的枚举.values())}
""");

    }
}