import java.util.*;





class 打乱Map_key顺序_Tisawem_Method implements 打乱Map_key顺序 {

    @Override
    public LinkedHashMap<String, Boolean> 打乱Map_key顺序(LinkedHashMap<String, Boolean> 选项) {
        // 创建一个HashSet来存储随机数字
        LinkedHashSet<Integer> 存储随机数字的HashSet = new LinkedHashSet<>();

        //存入"选项.size"个数的随机数字，并且Set本身的特性，存储随机数字的HashSet不会有重复的数字
        while (存储随机数字的HashSet.size() != 选项.size()) {


            存储随机数字的HashSet.add(new Random().nextInt(0, 选项.size()));// 随机生成一个数字，并将其添加到HashSet中
        }
        Integer[] ints = 存储随机数字的HashSet.toArray(new Integer[0]);//将hashset转为Integer数组方便后续处理
        //将linkedHashMap的key转为String数组，string2用来存放
        String[] string1 = 选项.keySet().toArray(new String[0]), string2 = new String[选项.size()];

        for (int i = 0; i < 选项.size(); i++) {
            string2[i] = string1[ints[i]];
        }


        LinkedHashMap<String, Boolean> 临时LinkedHashMap = new LinkedHashMap<>();

        for (String s : string2) {
            临时LinkedHashMap.put(s, 选项.get(s));
        }

        return 临时LinkedHashMap;

    }
}

class 打乱Map_key顺序_ChatGPT4_Method implements 打乱Map_key顺序 {

    @Override
    public LinkedHashMap<String, Boolean> 打乱Map_key顺序(LinkedHashMap<String, Boolean> 选项) {
        List<String> keys = new ArrayList<>(选项.keySet());  // 获取键的列表
        Collections.shuffle(keys);  // 使用Collections.shuffle直接打乱

        LinkedHashMap<String, Boolean> 临时LinkedHashMap = new LinkedHashMap<>();
        for (String key : keys) {
            临时LinkedHashMap.put(key, 选项.get(key));  // 重新按照打乱后的顺序构建LinkedHashMap
        }
        return 临时LinkedHashMap;
    }
}


interface 打乱Map_key顺序 {


    LinkedHashMap<String, Boolean> 打乱Map_key顺序(LinkedHashMap<String, Boolean> Map);

}

public enum 存储了实现打乱Map_key顺序类的枚举 {

    Tisawem(new 打乱Map_key顺序_Tisawem_Method()),ChatGPT4(new 打乱Map_key顺序_ChatGPT4_Method());

    private 打乱Map_key顺序 打乱Map_key顺序;

    存储了实现打乱Map_key顺序类的枚举(打乱Map_key顺序 打乱Map_key顺序){
        this.打乱Map_key顺序 = 打乱Map_key顺序;
    }
    public 打乱Map_key顺序 获取已经实现的类() {
        return 打乱Map_key顺序;
    }

}