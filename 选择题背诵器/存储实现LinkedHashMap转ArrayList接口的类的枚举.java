import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public enum 存储实现LinkedHashMap转ArrayList接口的类的枚举 {
    Tisawem(new LinkedHashMap转ArrayList_Tisawem_Method());


    private LinkedHashMap转ArrayList 转换器;


    存储实现LinkedHashMap转ArrayList接口的类的枚举(LinkedHashMap转ArrayList 转换器) {

        this.转换器 = 转换器;

    }

    public LinkedHashMap转ArrayList get转换器() {
        return 转换器;
    }
}

interface LinkedHashMap转ArrayList {
    ArrayList<String> 转换器(LinkedHashMap<String, Boolean> map);

}

class LinkedHashMap转ArrayList_Tisawem_Method implements LinkedHashMap转ArrayList {

    @Override
    public ArrayList<String> 转换器(LinkedHashMap<String, Boolean> map) {

        return new ArrayList<>(new 核验选项类(map).get选项().keySet());
    }

}
