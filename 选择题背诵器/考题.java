
import java.util.LinkedHashMap;


public enum 考题 {
     一只鸭子有几只脚("一只鸭子有几只脚?", new LinkedHashMap<>() {
        {
            put("1只脚", false);
            put("2只脚", true);
            put("3只脚", false);
            put("4只脚", false);
            put("two legs", true);

        }
    }
    );
    String 题目;
    LinkedHashMap<String, Boolean> 选项;



    考题(String 题目, LinkedHashMap<String, Boolean> 选项 ) {

        this.题目 = 题目;
        this.选项 = 选项;



    }

}