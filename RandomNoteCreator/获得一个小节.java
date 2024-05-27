import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class 获得一个小节 {

    private double get合理的总拍数(int 一节几个拍, int 一拍是几分音符) throws RuntimeException{

        if (一节几个拍 == 0) {
            throw new RuntimeException("一节几个拍不能为0");
        }
        if (一拍是几分音符 == 0) {
            throw new RuntimeException("一拍是几分音符不能为0");
        }


        double 总时长 = 0;

        for (音符 i : 音符.values()) {
            double 音符时长 = 1.0 / 一拍是几分音符;
            if (i.时长 == 音符时长) {
                总时长 = i.时长 * 一节几个拍;
            }

        }
        if (总时长 == 0) {
            throw new RuntimeException("枚举“音符”没有"+一拍是几分音符+"分音符。");
        } else {
            return 总时长;
        }

    }

    /**
     *此方法会验证拍数和几分音符，在Enum“音符”查看可用音符
     * 验证不过会抛出RuntimeException
     * @param 一节几个拍
     * @param 一拍是几分音符
     * @return 装了不同长度音符的list，能填满1小节
     */
   public ArrayList<String> 一个小节(int 一节几个拍, int 一拍是几分音符) throws RuntimeException{
        double 总拍数 = this.get合理的总拍数(一节几个拍, 一拍是几分音符);


        ArrayList<音符> 可用音符种类 = new ArrayList<>(Arrays.asList(音符.values()));
        ArrayList<String> 一小节音符 = new ArrayList<>();
        while (总拍数 > 0) {
            int randomNumber = new Random().nextInt(0, 可用音符种类.size());
            一小节音符.add(可用音符种类.get(randomNumber).toString());
            总拍数 -= 可用音符种类.get(randomNumber).时长;

//调试用：System.out.println(STR."随机数:\{randomNumber}\n\{可用音符种类.get(randomNumber).toString()}\n总拍数剩余:\{总拍数}");


        }
        return 一小节音符;
    }






}
