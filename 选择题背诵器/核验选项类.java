import java.util.LinkedHashMap;

/**
 * 如果我的Java知识只有大学的那点东西，就不会有这个类了
 * 我直接在别的类里写核验选项的逻辑，就不单独拿出来了
 */
public class 核验选项类 {
    private LinkedHashMap<String, Boolean> 选项;

    /**
     * 我的设计就是逼着你传一个LinkedHashMap
     * 要不然使用这个类的意义何在
     * @param 选项  LinkedHashMap<String key, Boolean Value>
     *           鸭子有几只脚？
     *           键：值
     *           没有脚：false
     *           1只：false
     *           2只：true
     *           3只：false
     *
     */
    public 核验选项类(LinkedHashMap<String, Boolean> 选项) {
        set选项(选项);

        set文字$linkhashmap为null值linkhashmap();
    }

    /**
     * 在使用这个类时，就已经通过实参传入了一个LinkedHashMap
     * 核验不过关会抛出错误，所以该方法一定返回核验好的LinkedHashMap
     * @return 已经核验过的LinkedHashMap
     */
    public LinkedHashMap<String, Boolean> get选项() {
        return  new LinkedHashMap<>(this.选项);
    }

    /**
     * 我希望你使用构造器，谢谢。
     * @param 选项 返回非空且有键值的LinkedHashMap
     */
    private void set选项(LinkedHashMap<String, Boolean> 选项) {
        if (选项 == null ) {
            throw new IllegalArgumentException(文字$linkhashmap为null值);
        }
        if ( 选项.isEmpty()){
            throw new IllegalArgumentException(文字$linkedhashmap没有元素);
        }
        this.选项 = new LinkedHashMap<>(选项); // 创建副本以保护内部状态
    }

private String 文字$linkhashmap为null值;
    private String 文字$linkedhashmap没有元素;

    public void set文字$linkhashmap为null值linkhashmap(){
       this.文字$linkhashmap为null值 =文字集_factortyMethod.get文字集().linkhashmap为null();
    }

    public void set文字$linkedhashmap没有元素( ) {
        this.文字$linkedhashmap没有元素 =文字集_factortyMethod.get文字集().linkedhashmap没有元素()  ;
    }
}
