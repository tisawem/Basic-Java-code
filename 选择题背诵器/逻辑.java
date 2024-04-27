import java.util.*;

public class 逻辑 {

    /**
     * 比如：鸭子几只脚
     */
    private String 题目;
    /**
     * 比如:
     * key:value
     * 一只:false
     * 两只:true
     * 没有:false
     */
    private LinkedHashMap<String, Boolean> 选项;
    /**
     * 用于存打乱前的“选项”,以备不时之需
     */
    private LinkedHashMap<String, Boolean> 选项$备份$;
    /**
     * 如果是true，会在执行“核心逻辑”方法时，打乱“选项”的key顺序，
     * 所以我想存一个打乱前的“选项”，即“选项$备份$”，不时之需时使用
     */
    private boolean 是否打乱选项;
    private String 文字$很遗憾答错;
    private String 文字$恭喜答对;
    private String 文字$正确答案如下;
    private String 文字$选完所有的正确答案;
    private String 文字$你是一个都没答对;
    private String 文字$还剩下几个答案;
    private String 文字$这是单选题;
    private String 文字$这是多选题;
    private String 文字$你没有选上所有正确选项;

    /**
     * 用于选择题，可以单选和多选。
     * 示例：
     * 题目: 鸭子有几只脚?
     * 选项：key:value
     * 一只:false
     * 两只:true
     * 没有:false
     * 是否打乱选项：true
     * 打乱后的选项，比如：
     * 两只:true
     * 没有:false
     * 一只:false
     *
     * @param 题目     String
     * @param 选项     LinkedHashMap 键：String，值：boolean
     * @param 是否打乱选项 boolean
     */
    逻辑(String language, String 题目, LinkedHashMap<String, Boolean> 选项, Boolean 是否打乱选项) {
        文字集_factortyMethod.set全局语言(language);
        this.题目 = 题目;


        this.选项 = new 核验选项类(选项).get选项();
        this.选项$备份$ = new LinkedHashMap<>(选项);
        this.是否打乱选项 = 是否打乱选项;
        set文字$恭喜答对();
        set文字$很遗憾答错();
        set文字$正确答案如下();
        set文字$选完所有的正确答案();
        set文字$你是一个都没答对();
        set文字$还剩下几个答案();
        set文字$这是单选题();
        set文字$这是多选题();
        set文字$你没有选上所有正确选项();

    }

    public void set文字$你没有选上所有正确选项() {
        this.文字$你没有选上所有正确选项 = 文字集_factortyMethod.get文字集().你没有选上所有正确选项();
    }

    public void 启动背诵器() {
        if (是否打乱选项) {//如果需要打乱先打乱选项顺序
            选项 = 存储了实现打乱Map_key顺序类的枚举.Tisawem.获取已经实现的类().打乱Map_key顺序(选项);
        }
        System.out.println(题目);//输出题目
        ArrayList<String> 选项的keymap = 存储实现LinkedHashMap转ArrayList接口的类的枚举.Tisawem.get转换器().转换器(选项);//将map的键转为Arraylist
        ArrayList<String> 正确答案 = new linkedhashmap按值选key存为arraylist<>(选项, true).转换器();
        int 剩余的正确答案数量 = 正确答案.size();

        if (正确答案.size() > 1) {
            System.out.println(文字$这是多选题);
        } else {
            System.out.println(文字$这是单选题);
        }


        while (正确答案.size() == 1) {
            for (int i = 0; i < 选项的keymap.size(); i++) {
                System.out.println(STR."\{i}、\{选项的keymap.get(i)}");
            }
            int availableArraylist索引Number = new 获取可以成为ArraysList索引的数字(选项的keymap).获取可以成为ArraysList索引的数字();
            if (选项.get(选项的keymap.get(availableArraylist索引Number))) {
                System.out.println(STR."""
\{文字$恭喜答对}
\{文字$正确答案如下}
\{题目}
\{选项的keymap.get(availableArraylist索引Number)}""");
                break;
            } else {
                System.out.println(文字$很遗憾答错);
                选项的keymap.remove(availableArraylist索引Number);
                if (选项的keymap.size() == 1) {
                    System.out.println(STR."""
\{文字$你是一个都没答对}
\{文字$正确答案如下}
\{题目}
\{正确答案}

""");
                    break;
                }
            }

        }

        while (正确答案.size() > 1) {
            for (int i = 0; i < 选项的keymap.size(); i++) {
                System.out.println(STR."\{i}、\{选项的keymap.get(i)}");
            }
            int availableArraylist索引Number = new 获取可以成为ArraysList索引的数字(选项的keymap).获取可以成为ArraysList索引的数字();


            if (选项.get(选项的keymap.get(availableArraylist索引Number))) {
                System.out.println(文字$恭喜答对);
                选项的keymap.remove(availableArraylist索引Number);
                剩余的正确答案数量 -= 1;

                if (剩余的正确答案数量 < 1) {
                    System.out.println(STR."""
\{文字$选完所有的正确答案}
\{文字$正确答案如下}
\{题目}
 """);
                    for (String a : 正确答案) {

                        System.out.println(a);
                    }
                    break;


                }
                System.out.println(文字$还剩下几个答案);

            } else {
                System.out.println(文字$很遗憾答错);
                选项的keymap.remove(availableArraylist索引Number);
                if (剩余的正确答案数量 == 正确答案.size() && 选项的keymap.size() == 剩余的正确答案数量) {
                    System.out.println(STR."""
\{文字$你是一个都没答对}
\{文字$正确答案如下}
\{题目}
""");

                    for (String a : 正确答案) {

                        System.out.println(a);
                    }
                    break;
                }if (剩余的正确答案数量<  正确答案.size() && 选项的keymap.size() == 剩余的正确答案数量){
                    System.out.println(STR."""
\{文字$你没有选上所有正确选项}
\{文字$正确答案如下}
\{题目}
""");

                    for (String a : 正确答案) {

                        System.out.println(a);
                    }
                    break;
                }


            }
        }


    }

    public void set文字$恭喜答对() {
        this.文字$恭喜答对 = 文字集_factortyMethod.get文字集().恭喜答对();
    }

    public void set文字$很遗憾答错() {
        this.文字$很遗憾答错 = 文字集_factortyMethod.get文字集().很遗憾答错();
    }


    public void set文字$正确答案如下() {
        this.文字$正确答案如下 = 文字集_factortyMethod.get文字集().正确答案如下();
    }

    public void set文字$选完所有的正确答案() {
        this.文字$选完所有的正确答案 = 文字集_factortyMethod.get文字集().选完所有的正确答案();
    }

    public void set文字$你是一个都没答对() {
        this.文字$你是一个都没答对 = 文字集_factortyMethod.get文字集().你是一个都没答对();
    }

    public void set文字$还剩下几个答案() {
        this.文字$还剩下几个答案 = 文字集_factortyMethod.get文字集().还剩下几个答案();
    }

    public void set文字$这是单选题() {
        this.文字$这是单选题 = 文字集_factortyMethod.get文字集().这是单选题();
    }

    public void set文字$这是多选题() {
        this.文字$这是多选题 = 文字集_factortyMethod.get文字集().这是多选题();
    }


}
