import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class java枚举常量合成类 {

    public static void main(String[] args) {
        print(new java枚举常量合成类().合成Java代码());
    }

    String 获取文字() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }

    String 获取题目() {
        print("输入题目");
        return this.获取文字();
    }

    ArrayList<String> 获得选项() {
        ArrayList<String> arrayList = new ArrayList<>();
        String temp;
        while (true) {
            print("输入选项：输入2结束");
            String selection = this.获取文字();
            if (selection.equals("2")) {
                if (arrayList.size() <= 1) {
                    print("选项不够");
                    continue;
                } else {
                    return arrayList;
                }
            } else {
                temp = String.format("\"%s\",", selection);
            }


            print("这个选项对吗？\n1、true  其他值、false");

            if (this.获取文字().equals("1")) {
                temp += "true";
            } else {
                temp += "false";
            }
            arrayList.add(temp);

        }


    }

    String 合成Java代码() {
        String java_code = "";
        Random random = new Random();
        for (int i = 0; i < random.nextInt(0, 16); i++) {
            java_code += (char) random.nextInt(19968, 40959);
        }
        java_code += "(\"" + this.获取题目() + "\",new LinkedHashMap<>() {{\n ";

        for (String s : this.获得选项()) {
            java_code += "put(" + s + ");\n";
        }
        return java_code + " } }),";

    }


    static void print(Object... o) {
        for (Object a : o) {
            System.out.print(a);
        }
        System.out.print("\n");
    }

}
