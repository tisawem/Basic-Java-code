import java.util.ArrayList;
import java.util.Scanner;

public class 让用户设置根音八度和节拍 {

    public 让用户设置根音八度和节拍() {
        this.获取用户设置();
    }

    public int get最高八度() {
        return 最高八度;
    }

    public int get最低八度() {
        return 最低八度;
    }

    public String[] get调式() {
        return 调式;
    }

    public ArrayList<String> get一小节没音高的音符() {
        return 一小节没音高的音符;
    }

    private int 最低八度, 最高八度;
    private String[] 调式;
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<String> 一小节没音高的音符;

    private void 设置八度范围(int 最低八度, int 最高八度) {
        if (最高八度 - 最低八度 < 0) {
            this.最低八度 = 最高八度;
            this.最高八度 = 最低八度;
            print(String.format("\n最高八度：%d\n最低八度：%d\n最低八度将作为最高八度处理，反之亦然。\n", 最高八度, 最低八度));
        } else {
            this.最低八度 = 最低八度;
            this.最高八度 = 最高八度;
        }
    }

    private <T extends 根音> void 设置根音(String 根音, T 调式类) throws IllegalArgumentException {
        if (调式类 == null) {
            throw new NullPointerException("调式类为null");
        }

        switch (根音.toUpperCase()) {
            case "C": this.调式 = 调式类.C(); break;
            case "D": this.调式 = 调式类.D(); break;
            case "E": this.调式 = 调式类.E(); break;
            case "F": this.调式 = 调式类.F(); break;
            case "G": this.调式 = 调式类.G(); break;
            case "A": this.调式 = 调式类.A(); break;
            case "B": this.调式 = 调式类.B(); break;
            case "C#", "DB": this.调式 = 调式类.Db(); break;
            case "D#", "EB": this.调式 = 调式类.Eb(); break;
            case "F#", "GB": this.调式 = 调式类.Gb(); break;
            case "G#", "AB": this.调式 = 调式类.Ab(); break;
            case "A#", "BB": this.调式 = 调式类.Bb(); break;
            default: throw new IllegalArgumentException(String.format("错误实参：%s\n有效根音如下：\n（不分大小写，不分升降调）\nC、D、E、F、G、A、B\nC#、D#、F#、G#、A#\nDb、Eb、Gb、Ab、Bb\n", 根音));
        }
    }


    /**
     * 可用调式 是一个枚举类
     * @return 一个枚举类型“可用调式”里面的一个实例
     */
    private 可用调式 获取用户选择的调式() {
        while (true) {
            print("请输入调式\n可用调式：");
            for (可用调式 调式 : 可用调式.values()) {
                print(调式.name());
            }
            String userInput调式Word = scanner.next();
            for (可用调式 调 : 可用调式.values()) {
                if (调.name().equals(userInput调式Word)) {
                    return 调;
                }
            }
            print("没有你想要的调式");
            scanner.nextLine();
        }
    }

    private void 获取用户设置() {
        根音 根音实例 = this.获取用户选择的调式().get实例;//获取某个调式的代码被剥离到单独的方法上

        while (true) {
            print("请输入根音：\n仅限以下字符串： C、D、E、F、G、A、B、C#、D#、F#、G#、A#、 Db、Eb、Gb、Ab、Bb\n");
            String 根音 = scanner.next();
            try {
                this.设置根音(根音, 根音实例);
                scanner.nextLine();
                break;
            } catch (Throwable t) {
                print(t);
                print("根音错误，");
                scanner.nextLine();
            }
        }
//从用户输入获得一个整数的代码也被剥离到单独的一个方法
        int number1 =this.获取用户输入整数("请输入最低八度\n(仅接受阿拉伯数字): ");
        int number2 = this.获取用户输入整数("请输入最高八度\n(仅接受阿拉伯数字): ");
        this.设置八度范围(number1, number2);

        while (true) {
            number1 = this.获取用户输入整数("一节几个拍？\n(仅接受阿拉伯数字): ");
            number2 = this.获取用户输入整数("一拍是几分音符？\n(仅接受阿拉伯数字): ");
            try {
                //new 获得一个小节()里面有一个private方法验证输入的数字，public方法：一个小节会使用该private方法。
                //在这里只需获得一个int数字即可，不需要在这里对int具体数字进行验证
                this.一小节没音高的音符 = new 获得一个小节().一个小节(number1, number2);
                break;
            } catch (RuntimeException r) {
                //r包含了用户提示信息
                print("\n", r, "\n");
                scanner.nextLine();
            }
        }
    }

    /**
     * 从用户输入中获取一个整数。
     * <p>
     * 此方法将不断提示用户输入，直到用户输入一个有效的整数为止。
     * 如果用户输入的不是整数，系统会提示输入无效，并要求重新输入。
     * </p>
     *
     * @param 提示信息 用于提示用户输入整数的字符串信息。
     * @return 返回用户输入的整数值。
     */
    private int 获取用户输入整数(String 提示信息) {
        while (true) {
            System.out.print(提示信息);
            if (scanner.hasNextInt()) {
                return scanner.nextInt(); // 用户输入了有效的整数，返回这个整数
            } else {
                System.out.println("无效输入，请输入一个整数.");
                scanner.next(); // 清除当前的无效输入，准备下一次循环
            }
        }
    }

    /**
     *
     * 静享简便print方法，犹如python那样优雅。
     * <p></p>
     * 打印传入的对象数组。
     * 该方法会遍历对象数组，并将每个对象转换为字符串后打印出来。
     *
     * @param words 可变参数，代表要打印的对象数组。每个对象都会被调用toString()方法后打印。
     */
    private void print(Object... words) {
        // 遍历传入的对象数组，并打印每个对象的字符串表示
        for (Object word : words) {
            System.out.print(word);
        }
    }

}
