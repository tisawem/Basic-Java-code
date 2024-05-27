import java.util.ArrayList;
import java.util.Random;

public class generateOne小节 {

    private int 最低八度, 最高八度;
    private String[] 调式;
    private ArrayList<String> 一小节没音高的音符;


    public generateOne小节() {
        让用户设置根音八度和节拍 r = new 让用户设置根音八度和节拍();
        this.调式 = r.get调式();
        this.最高八度 = r.get最高八度();
        this.最低八度 = r.get最低八度();
        this.一小节没音高的音符 = r.get一小节没音高的音符();
        r = null;


    }


    public ArrayList<String> get一小节随机音符() {
        ArrayList<String> backup = new ArrayList<>();
        Random random = new Random();

        int 上一个音符琴键编号 = 0;
        for (String s : 一小节没音高的音符) {
            int random八度, random音高;
            int tempNum;
            do {
                random八度 = random.nextInt(最低八度, 最高八度 + 1);
                random音高 = random.nextInt(0, 调式.length);
                tempNum = (random八度 - 最低八度) * 12 + random音高 - 上一个音符琴键编号;
            } while (tempNum > 11 || tempNum < -11);//生成一个音高不会差出超过1个八度的随机值

            if (最低八度 == 最高八度) {
                backup.add(调式[random音高]+"，"+s+"\n");
            } else {
                backup.add( 调式[random音高]+random八度+"，"+s+"\n");
                上一个音符琴键编号 = (random八度 - 最低八度) * 12 + random音高;
            }
        }
        return backup;
    }



}
