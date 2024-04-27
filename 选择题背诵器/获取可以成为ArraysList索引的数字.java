import java.util.ArrayList;

import java.util.Scanner;





public class 获取可以成为ArraysList索引的数字 <T>   {
    private ArrayList<T> a;
    private String 文字$请输入有效数字;
    private String 文字$数字范围不对;
    private String 文字$不接受null值的Arraylist;
    private String 文字$不接受没有元素的Arraylist;

    /**
     * 这个构造器已经阻拦了没有元素和null值的ArrayList&lt;T&gt;。
     *
     * @param a ArrayList&lt;T&gt;
     */
    获取可以成为ArraysList索引的数字 (ArrayList<T> a) {

        set文字$不接受null值的Arraylist();// 初始化提示语
        set文字$不接受没有元素的Arraylist();


        if (a == null) {
            throw new IllegalArgumentException(文字$不接受null值的Arraylist);
        }
        if (a.size() == 0) {
            throw new IllegalArgumentException(文字$不接受没有元素的Arraylist);
        }

        this.a = a;
        set文字$请输入有效数字(); // 初始化提示语
        set文字$数字范围不对();

    }


    public int 获取可以成为ArraysList索引的数字(ArrayList<T> a) {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(文字$请输入有效数字);
            while (!scanner.hasNextInt()) {
                scanner.nextLine(); // 清除错误的输入
                System.out.println(文字$请输入有效数字);
            }
            int index = scanner.nextInt(); // 存储一次输入
            scanner.nextLine(); // 清除行的剩余部分
            if (index < 0 || index >= a.size()) {
                System.out.println(文字$数字范围不对);
                continue;
            }
            return index;

        }

    }

    public int 获取可以成为ArraysList索引的数字() {
        return 获取可以成为ArraysList索引的数字(this.a);
    }

    public void set文字$请输入有效数字() {
        this.文字$请输入有效数字 = 文字集_factortyMethod.get文字集().请输入有效数字(0, a.size());
    }

    public void set文字$不接受null值的Arraylist() {
        this.文字$请输入有效数字 = 文字集_factortyMethod.get文字集().不接受null值的Arraylist();
    }


    public void set文字$不接受没有元素的Arraylist() {
        this.文字$请输入有效数字 = 文字集_factortyMethod.get文字集().不接受没有元素的Arraylist();
    }

    public void set文字$数字范围不对() {
        this.文字$数字范围不对 = 文字集_factortyMethod.get文字集().数字范围不对(0, a.size());
    }
}


