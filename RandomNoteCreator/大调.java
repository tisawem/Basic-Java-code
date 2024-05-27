import java.util.ArrayList;
import java.util.Arrays;


/**
 * 里面所有的public方法得到的都是字符串，包含了你想要的大调所需的琴键
 */
public class 大调 implements 根音 {
private final String[]琴键=new String[]{"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};

    /**
     *返回一个字符串数组，数组中的元素为该根音下的所需大调。
     * @param 根音 起始值为0，即C。最大值11，没有对实参进行验证
     */
   private String[] 抠出不需要的琴键(int 根音) {
       int []黑键={根音+1,根音+3,根音+6,根音+8,根音+10};
       for (int i=0;i<黑键.length;i++){
           if (黑键[i]>11){
               黑键[i]-=12;
           }
       }
       ArrayList<String> 琴键list = new ArrayList<>(Arrays.asList(琴键));
       ArrayList<String> 不要的琴键 = new ArrayList<>( );
       for (int i: 黑键){
           不要的琴键.add(琴键list.get(i));

       }
       for (String s:不要的琴键){

           琴键list.remove(s);
       }


        return 琴键list.toArray(new String[0]);
   }





    @Override
    public String[] C() {
        return new 大调().抠出不需要的琴键(0);
    }

    @Override
    public String[] Db() {
        return new 大调().抠出不需要的琴键(1);
    }

    @Override
    public String[] D() {
        return new 大调().抠出不需要的琴键(2);
    }

    @Override
    public String[] Eb() {
        return new 大调().抠出不需要的琴键(3);
    }

    @Override
    public String[] E() {
        return new 大调().抠出不需要的琴键(4);
    }

    @Override
    public String[] F() {
        return new 大调().抠出不需要的琴键(5);
    }

    @Override
    public String[] Gb() {
        return new 大调().抠出不需要的琴键(6);
    }

    @Override
    public String[] G() {
        return new 大调().抠出不需要的琴键(7);
    }

    @Override
    public String[] Ab() {
        return new 大调().抠出不需要的琴键(8);
    }

    @Override
    public String[] A() {
        return new 大调().抠出不需要的琴键(9);
    }

    @Override
    public String[] Bb() {
        return new 大调().抠出不需要的琴键(10);
    }

    @Override
    public String[] B() {
        return new 大调().抠出不需要的琴键(11);
    }
}
