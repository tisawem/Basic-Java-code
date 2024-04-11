package 灭掉7乘7数组里的所有元素;

import java.util.*;

public class 重构版本 {

    private static final Scanner scanner = new Scanner(System.in);
    private static byte 棋盘长;
    private static byte 棋盘宽;
    private static String 公司姓名[];

    private static String language ="zh_cn";//调整默认语言

    /**
     * 规则：
     * 棋盘最小3*3
     * 传递一个数组、不允许传递null数组，数组里面不允许有null元素
     *
     * @param 棋盘长  最小3，最大127
     * @param 棋盘宽  最小3，最大127
     * @param 公司姓名 String[]
     */
    public 重构版本(String 游戏, String 语言, byte 棋盘长, byte 棋盘宽, String[] 公司姓名) throws Exception {

        language = new 合法性检查().语言合法性检查(语言);

        Exception 棋盘大小合法性检查 = new 合法性检查().棋盘大小合法性检查(棋盘长, 棋盘宽);
        Exception 公司数组合法性检查 = new 合法性检查().公司数组合法性检查(棋盘长, 棋盘宽, 公司姓名);
        if (棋盘大小合法性检查 != null) {
            throw 棋盘大小合法性检查;
        } else if (公司数组合法性检查 != null) {
            throw 公司数组合法性检查;
        }
        this.棋盘长 = 棋盘长;
        this.棋盘宽 = 棋盘宽;
        this.公司姓名 = 公司姓名;

        启动器(游戏);


    }

    private void 启动器(String name) throws Exception {
        for (枚举合集.已有游戏 game : 枚举合集.已有游戏.values()) {
            if (game.name().equalsIgnoreCase(name)) {
                switch (name) {
                    case "游戏1": {
                        new 游戏1().游戏逻辑();
                        return;
                    }
                    default:
                        throw new 报错合集().new 找不到游戏("需要程序员检查枚举里面的语言命名");
                }
            }
        }
        throw new 报错合集().new 找不到游戏(name);

    }

    interface 游戏逻辑 {
        void 游戏逻辑() throws Exception;
    }

    /**
     * 存放所有向控制台输出的String字符串
     */
    private static class 文本合集 {
        public static 文本内容 工厂方法(String 语言编码) throws Exception {

            switch (语言编码) {

                case "zh_cn" -> {
                    return new 文本合集().new zh_cn();
                }
                case "en_us" -> {
                    return new 文本合集().new en_us();
                }
                case "ja_jp"->{
                    return new 文本合集().new ja_jp();
                }
                case "ko_kr"->{
                    return new 文本合集().new ko_kr();
                }
                case null, default -> {
                    language = "zh_cn";
                    /*
                    请勿去除，构造器的language被赋予一个错误的值时，任何使用language变量的语句都会执行下面的抛出，
                    报错合集里的语言问题构造器又有个调用language的语句，然后又返回到这了，
                    然后又要调用报错合集里的语言问题构造器...导致栈溢出

                    */
                    throw new 报错合集().new 语言问题("严重错误，需要程序员检查构造器里language设置");
                }

            }

        }

        private interface 文本内容 {
            String 棋盘长度太短(int 棋盘长);

            String 棋盘宽度太短(int 棋盘宽);

            String 棋盘太小(int 棋盘长, int 棋盘宽);

            String 公司数组是null值();

            String 公司数组里面的元素个数不对(int 元素个数, int 棋盘容量);

            String 公司数组里面含有null元素();

            String 下面是一个棋盘里面是坐标();

            String 有几个公司在这个棋盘里输入坐标看看有没有命中一个公司你有几次机会看看能命中多好个公司();

            String 输入的不是数字请重新输入(String s);

            String 输入第一个坐标();

            String 输入第二个坐标();

            String 输入的数字不在范围内(int 起始值_包含起始值, int 末值_不包含末值本身, int 值);

            String 没有该语言使用默认语言(String 语言);

            String null值无效使用默认语言();

            String 很遗憾没命中剩余几次机会(int 机会次数);

            String 恭喜命中(int 机会次数, String 中奖内容);

            String 很遗憾没有命中任何东西();

            String 恭喜您命中了以下内容(String 内容);

            String 棋盘数据如下();


            String 没有该游戏(String 可用游戏, String 设置错误的语言);

            String 没有该语言(String 可用语言, String 设置错误的游戏);


        }

        private class zh_cn implements 文本内容 {


            @Override
            public String 棋盘长度太短(int 棋盘长) {
                return STR."棋盘长度太短:\{棋盘长}<3\n棋盘长度至少为3";
            }

            @Override
            public String 棋盘宽度太短(int 棋盘宽) {
                return STR."\n棋盘宽度太短:\{棋盘宽}<3\n棋盘宽度至少为3";
            }

            @Override
            public String 棋盘太小(int 棋盘长, int 棋盘宽) {
                return STR."\n棋盘太小:\{棋盘长}<3、\{棋盘宽}<3\n棋盘大小至少为3*3";
            }

            @Override
            public String 公司数组是null值() {
                return "\n实参传递的数组不允许等于null";
            }

            @Override
            public String 公司数组里面的元素个数不对(int 元素个数, int 棋盘容量) {
                return STR."\n公司数组里面的元素个数不对：\{元素个数}\n里面至少有一个元素，最多不能超过棋盘容量:\{棋盘容量}，所有元素不允许是null";
            }

            @Override
            public String 公司数组里面含有null元素() {
                return "\n实参传递的数组不允许含有null元素";
            }

            @Override
            public String 下面是一个棋盘里面是坐标() {
                return "\n下面是一个棋盘，里面是坐标";
            }

            @Override
            public String 有几个公司在这个棋盘里输入坐标看看有没有命中一个公司你有几次机会看看能命中多好个公司() {
                return STR."\n有\{公司姓名.length}在这个棋盘里\n输入坐标，看看有没有命中一个公司\n你有\{公司姓名.length}次机会\n看看能命中多少个公司";
            }

            @Override
            public String 输入的不是数字请重新输入(String s) {
                return STR."\n输入的\"\{s}\"不是数字，请重新输入";
            }

            @Override
            public String 输入第一个坐标() {
                return "\n输入第一个坐标";
            }

            @Override
            public String 输入第二个坐标() {
                return "\n输入第二个坐标";
            }

            @Override
            public String 输入的数字不在范围内(int 起始值_包含起始值, int 末值_不包含末值本身, int 值) {
                return STR."\n输入的数字“\{值}”不在范围内\n范围是：\{起始值_包含起始值}≤x<\{末值_不包含末值本身}";
            }

            @Override
            public String 没有该语言使用默认语言(String 语言) {
                return STR."\n没有“\{语言}”语言，使用简体中文";
            }

            @Override
            public String null值无效使用默认语言() {
                return "\nnull值无效,使用简体中文";
            }

            @Override
            public String 很遗憾没命中剩余几次机会(int 机会次数) {
                return STR."\n很遗憾,没命中\n剩余\{机会次数}次机会\n";
            }

            @Override
            public String 恭喜命中(int 机会次数, String 中奖内容) {
                return STR."\n恭喜命中“\{中奖内容}”\n剩余\{机会次数}次机会\n";
            }

            @Override
            public String 很遗憾没有命中任何东西() {
                return "\n很遗憾,你没有命中任何东西,继续努力";
            }

            @Override
            public String 恭喜您命中了以下内容(String 内容) {
                return STR."\n恭喜您,您命中了\n\{内容}，\n你真幸运";
            }

            @Override
            public String 棋盘数据如下() {
                return "\n棋盘数据如下：\n";
            }

            @Override
            public String 没有该游戏(String 可用游戏, String 设置错误的游戏) {
                return STR."""

没有实参所设置的“\{设置错误的游戏}”游戏，可用游戏如下：
\{可用游戏}""";
            }


            @Override
            public String 没有该语言(String 可用语言, String 设置错误的语言) {
                return STR."""
实参设置的语言“\{设置错误的语言}”，“文本合集”没有内置
可用语言如下：
\{可用语言}""";
            }


        }

        public class en_us implements 文本内容 {

            @Override
            public String 棋盘长度太短(int 棋盘长) {
                return "The board length is too short: " + 棋盘长 + ". The minimum length is 3.";
            }

            @Override
            public String 棋盘宽度太短(int 棋盘宽) {
                return "The board width is too short: " + 棋盘宽 + ". The minimum width is 3.";
            }

            @Override
            public String 棋盘太小(int 棋盘长, int 棋盘宽) {
                return "The board is too small: " + 棋盘长 + "x" + 棋盘宽 + ". The minimum size is 3x3.";
            }

            @Override
            public String 公司数组是null值() {
                return "The company array cannot be null.";
            }

            @Override
            public String 公司数组里面的元素个数不对(int 元素个数, int 棋盘容量) {
                return "The number of elements in the company array is incorrect: " + 元素个数 + ". It should have at least one element and not exceed the board capacity of " + 棋盘容量 + ", and all elements must not be null.";
            }

            @Override
            public String 公司数组里面含有null元素() {
                return "The company array cannot contain null elements.";
            }

            @Override
            public String 下面是一个棋盘里面是坐标() {
                return "Below is a board with coordinates.";
            }

            @Override
            public String 有几个公司在这个棋盘里输入坐标看看有没有命中一个公司你有几次机会看看能命中多好个公司() {
                // Assuming there's a way to get the number of companies, represented here as "numberOfCompanies"
                int numberOfCompanies = 公司姓名.length; // This needs to be replaced with actual logic to get the number of companies
                return "There are " + numberOfCompanies + " companies on this board.\nEnter coordinates to see if you hit a company. You have " + numberOfCompanies + " chances to see how well you can hit the companies.";
            }

            @Override
            public String 输入的不是数字请重新输入(String s) {
                return "The input \"" + s + "\" is not a number, please re-enter.";
            }

            @Override
            public String 输入第一个坐标() {
                return "Enter the first coordinate:";
            }

            @Override
            public String 输入第二个坐标() {
                return "Enter the second coordinate:";
            }

            @Override
            public String 输入的数字不在范围内(int 起始值_包含起始值, int 末值_不包含末值本身, int 值) {
                return "The number \"" + 值 + "\" is out of range. The range is from " + 起始值_包含起始值 + " to " + (末值_不包含末值本身 - 1) + ".";
            }

            @Override
            public String 没有该语言使用默认语言(String 语言) {
                return "The language \"" + 语言 + "\" is not supported, using English as the default language.";
            }

            @Override
            public String null值无效使用默认语言() {
                return "Null value is not valid, using English as the default language.";
            }

            @Override
            public String 很遗憾没命中剩余几次机会(int 机会次数) {
                return "Unfortunately, you didn't hit. " + 机会次数 + " chances left.";
            }

            @Override
            public String 恭喜命中(int 机会次数, String 中奖内容) {
                return "Congratulations on hitting " + 中奖内容 + "\n " + 机会次数 + " chances left.";
            }

            @Override
            public String 很遗憾没有命中任何东西() {
                return "Unfortunately, you didn't hit anything. Better luck next time!";
            }

            @Override
            public String 恭喜您命中了以下内容(String 内容) {
                return "Congratulations, you have hit the following: " + 内容 + ". You are very lucky!";
            }

            @Override
            public String 棋盘数据如下() {
                return "The board data is as follows:";
            }

            @Override
            public String 没有该游戏(String 可用游戏, String 设置错误的游戏) {
                return "The game \"" + 设置错误的游戏 + "\" is not available. Available games are: " + 可用游戏;
            }

            @Override
            public String 没有该语言(String 可用语言, String 设置错误的语言) {
                return "The language \"" + 设置错误的语言 + "\" is not supported. Supported languages are: " + 可用语言;
            }
        }

        public class ja_jp implements 文本内容 {

            @Override
            public String 棋盘长度太短(int 棋盘长) {
                return "ボードの長さが短すぎます：" + 棋盘长 + "。最小長さは3です。";
            }

            @Override
            public String 棋盘宽度太短(int 棋盘宽) {
                return "ボードの幅が短すぎます：" + 棋盘宽 + "。最小幅は3です。";
            }

            @Override
            public String 棋盘太小(int 棋盘长, int 棋盘宽) {
                return "ボードが小さすぎます：" + 棋盘长 + "x" + 棋盘宽 + "。最小サイズは3x3です。";
            }

            @Override
            public String 公司数组是null值() {
                return "会社の配列はnullにできません。";
            }

            @Override
            public String 公司数组里面的元素个数不对(int 元素个数, int 棋盘容量) {
                return "会社の配列の要素数が正しくありません：" + 元素个数 + "。要素は少なくとも1つ必要で、ボードの容量" + 棋盘容量 + "を超えてはいけません。すべての要素がnullであってはなりません。";
            }

            @Override
            public String 公司数组里面含有null元素() {
                return "会社の配列にnull要素が含まれています。";
            }

            @Override
            public String 下面是一个棋盘里面是坐标() {
                return "以下はボードで、中には座標があります。";
            }

            @Override
            public String 有几个公司在这个棋盘里输入坐标看看有没有命中一个公司你有几次机会看看能命中多好个公司() {
                return "このボードにはいくつかの会社があります。座標を入力して、会社にヒットするかどうかを確認してください。何回のチャンスがあり、どれだけ多くの会社にヒットできるかを確認してください。";
            }

            @Override
            public String 输入的不是数字请重新输入(String s) {
                return "入力された\"" + s + "\"は数字ではありません。再入力してください。";
            }

            @Override
            public String 输入第一个坐标() {
                return "最初の座標を入力してください。";
            }

            @Override
            public String 输入第二个坐标() {
                return "2番目の座標を入力してください。";
            }

            @Override
            public String 输入的数字不在范围内(int 起始值_包含起始值, int 末值_不包含末值本身, int 值) {
                return "入力された数字\"" + 值 + "\"は範囲外です。範囲は" + 起始值_包含起始值 + "から" + (末值_不包含末值本身 - 1) + "までです。";
            }

            @Override
            public String 没有该语言使用默认语言(String 语言) {
                return "\"" + 语言 + "\"言語はサポートされていません、デフォルト言語を使用します。";
            }

            @Override
            public String null值无效使用默认语言() {
                return "null値は無効です、デフォルト言語を使用します。";
            }

            @Override
            public String 很遗憾没命中剩余几次机会(int 机会次数) {
                return "残念ながらヒットしませんでした。残りのチャンスは" + 机会次数 + "回です。";
            }

            @Override
            public String 恭喜命中(int 机会次数, String 中奖内容) {
                return "おめでとうございます、" + 中奖内容 + "にヒットしました。残りのチャンスは" + 机会次数 + "回です。";
            }

            @Override
            public String 很遗憾没有命中任何东西() {
                return "残念ながら何もヒットしませんでした。次回のチャンスに期待しましょう。";
            }

            @Override
            public String 恭喜您命中了以下内容(String 内容) {
                return "おめでとうございます、以下の内容にヒットしました：" + 内容 + "。あなたはとても幸運です！";
            }

            @Override
            public String 棋盘数据如下() {
                return "ボードのデータは以下の通りです：";
            }

            @Override
            public String 没有该游戏(String 可用游戏, String 设置错误的游戏) {
                return "設定されたゲーム\"" + 设置错误的游戏 + "\"は存在しません。利用可能なゲームは以下の通りです：" + 可用游戏;
            }

            @Override
            public String 没有该语言(String 可用语言, String 设置错误的语言) {
                return "設定された言語\"" + 设置错误的语言 + "\"はサポートされていません。サポートされている言語は以下の通りです：" + 可用语言 + "。";
            }
        }
        public class ko_kr implements 文本内容 {

            @Override
            public String 棋盘长度太短(int 棋盘长) {
                return "보드 길이가 너무 짧습니다: " + 棋盘长 + ". 최소 길이는 3입니다.";
            }

            @Override
            public String 棋盘宽度太短(int 棋盘宽) {
                return "보드 너비가 너무 짧습니다: " + 棋盘宽 + ". 최소 너비는 3입니다.";
            }

            @Override
            public String 棋盘太小(int 棋盘长, int 棋盘宽) {
                return "보드가 너무 작습니다: " + 棋盘长 + "x" + 棋盘宽 + ". 최소 크기는 3x3입니다.";
            }

            @Override
            public String 公司数组是null值() {
                return "회사 배열은 null일 수 없습니다.";
            }

            @Override
            public String 公司数组里面的元素个数不对(int 元素个数, int 棋盘容量) {
                return "회사 배열의 요소 수가 올바르지 않습니다: " + 元素个数 + ". 요소는 최소 하나 있어야 하며 보드 용량 " + 棋盘容量 + "을 초과할 수 없습니다. 모든 요소는 null이어서는 안 됩니다.";
            }

            @Override
            public String 公司数组里面含有null元素() {
                return "회사 배열에 null 요소가 포함될 수 없습니다.";
            }

            @Override
            public String 下面是一个棋盘里面是坐标() {
                return "아래는 좌표가 있는 보드입니다.";
            }

            @Override
            public String 有几个公司在这个棋盘里输入坐标看看有没有命中一个公司你有几次机会看看能命中多好个公司() {
                return "이 보드에는 여러 회사가 있습니다. 좌표를 입력하여 회사를 명중시킬 수 있는지 확인하십시오. 몇 번의 기회가 있으며 얼마나 많은 회사를 명중시킬 수 있는지 확인하십시오.";
            }

            @Override
            public String 输入的不是数字请重新输入(String s) {
                return "입력한 \"" + s + "\"는 숫자가 아닙니다. 다시 입력해 주세요.";
            }

            @Override
            public String 输入第一个坐标() {
                return "첫 번째 좌표를 입력하세요.";
            }

            @Override
            public String 输入第二个坐标() {
                return "두 번째 좌표를 입력하세요.";
            }

            @Override
            public String 输入的数字不在范围内(int 起始值_包含起始值, int 末值_不包含末值本身, int 值) {
                return "입력한 숫자 \"" + 值 + "\"는 범위를 벗어났습니다. 범위는 " + 起始值_包含起始值 + "에서 " + (末值_不包含末值本身 - 1) + "입니다.";
            }

            @Override
            public String 没有该语言使用默认语言(String 语言) {
                return "\"" + 语言 + "\" 언어는 지원되지 않습니다. 기본 언어를 사용합니다.";
            }

            @Override
            public String null值无效使用默认语言() {
                return "null 값은 유효하지 않습니다. 기본 언어를 사용합니다.";
            }

            @Override
            public String 很遗憾没命中剩余几次机会(int 机会次数) {
                return "안타깝게도 명중하지 못했습니다. 남은 기회 " + 机会次数 + "번.";
            }

            @Override
            public String 恭喜命中(int 机会次数, String 中奖内容) {
                return "축하합니다, \"" + 中奖内容 + "\"을(를) 명중했습니다. 남은 기회 " + 机会次数 + "번.";
            }

            @Override
            public String 很遗憾没有命中任何东西() {
                return "안타깝게도 아무것도 명중하지 못했습니다. 다음 기회에!";
            }

            @Override
            public String 恭喜您命中了以下内容(String 内容) {
                return "축하합니다, 다음 내용을 명중했습니다: " + 内容 + ". 당신은 정말 운이 좋습니다!";
            }

            @Override
            public String 棋盘数据如下() {
                return "보드 데이터는 다음과 같습니다:";
            }

            @Override
            public String 没有该游戏(String 可用游戏, String 设置错误的游戏) {
                return "설정된 게임 \"" + 设置错误的游戏 + "\"은(는) 존재하지 않습니다. 사용 가능한 게임은 다음과 같습니다: " + 可用游戏;
            }

            @Override
            public String 没有该语言(String 可用语言, String 设置错误的语言) {
                return "설정된 언어 \"" + 设置错误的语言 + "\"는 지원되지 않습니다. 지원되는 언어는 다음과 같습니다: " + 可用语言 + ".";
            }
        }




    }

    /**
     * 存放代码里面所有的自定义报错
     */
    private static class 报错合集 {
        class 棋盘太小 extends Exception {


            public 棋盘太小(byte 棋盘长, byte 棋盘宽) throws Exception {
                super(得到错误消息(棋盘长, 棋盘宽));
            }

            private static String 得到错误消息(byte 棋盘长, byte 棋盘宽) throws Exception {

                if (棋盘长 < 3) {
                    return 文本合集.工厂方法(language).棋盘长度太短(棋盘长);
                } else if (棋盘宽 < 3) {
                    return 文本合集.工厂方法(language).棋盘宽度太短(棋盘宽);
                } else {
                    return 文本合集.工厂方法(language).棋盘太小(棋盘长, 棋盘宽);
                }
            }

        }

        class 公司数组的null情况 {
            class 公司数组等于null extends Exception {
                公司数组等于null() throws Exception {
                    super(得到错误消息());

                }

                private static String 得到错误消息() throws Exception {
                    return 文本合集.工厂方法(language).公司数组是null值();

                }
            }

            class 公司数组元素个数不对 extends Exception {
                公司数组元素个数不对(int 元素个数, int 棋盘容量) throws Exception {
                    super(得到错误消息(元素个数, 棋盘容量));
                }

                private static String 得到错误消息(int 元素个数, int 棋盘容量) throws Exception {
                    return 文本合集.工厂方法(language).公司数组里面的元素个数不对(元素个数, 棋盘容量);

                }
            }

            class 公司数组里面含有null元素 extends Exception {
                公司数组里面含有null元素() throws Exception {
                    super(得到错误消息());

                }

                private static String 得到错误消息() throws Exception {
                    return 文本合集.工厂方法(language).公司数组里面含有null元素();

                }
            }

        }

        class 语言问题 extends Exception {
            语言问题(String 设置错误的语言) throws Exception {
                super(文本合集.工厂方法(language).没有该语言(Arrays.toString(枚举合集.语言合集.values()), 设置错误的语言));
            }
        }

        class 找不到游戏 extends Exception {
            找不到游戏(String 设置错误的游戏) throws Exception {
                super(文本合集.工厂方法(language).没有该游戏(Arrays.toString(枚举合集.已有游戏.values()), 设置错误的游戏));
            }
        }
    }

    /**
     * 所有涉及检查的都在此处
     */
    private class 合法性检查 {
        Exception 棋盘大小合法性检查(byte 棋盘长, byte 棋盘宽) throws Exception {
            if (棋盘宽 < 3 || 棋盘长 < 3) {
                return new 报错合集().new 棋盘太小(棋盘长, 棋盘宽);
            } else {
                return null;
            }
        }

        Exception 公司数组合法性检查(byte 棋盘长, byte 棋盘宽, String[] 公司姓名) throws Exception {
            if (公司姓名 == null) {
                return new 报错合集().new 公司数组的null情况().new 公司数组等于null();
            } else if (公司姓名.length == 0 || 公司姓名.length > 棋盘长 * 棋盘宽) {//公司姓名不允许超过棋盘大小
                return new 报错合集().new 公司数组的null情况().new 公司数组元素个数不对(公司姓名.length, 棋盘长 * 棋盘宽);
            } else {
                for (String s : 公司姓名) {
                    if (s == null) {
                        return new 报错合集().new 公司数组的null情况().new 公司数组里面含有null元素();

                    }
                }
            }
            return null;
        }

        String 语言合法性检查(String 语言) throws Exception {
            for (枚举合集.语言合集 lang : 枚举合集.语言合集.values()) {
                if (lang.name().equalsIgnoreCase(语言)) {
                    return lang.get语言();
                    // return lang.name(); 曾因为这个语句引发了一个bug，导致栈溢出
                }
            }
            throw new 报错合集().new 语言问题(语言);
        }

        int 获得合法数字输入(int 起始值_包含起始值, int 末值_不包含末值本身, String 标题文字) throws Exception {
            int number = 0;
            while (true) {
                System.out.println(标题文字);
                try {
                    number = scanner.nextInt();
                } catch (InputMismatchException _) {
                    System.out.println(文本合集.工厂方法(language).输入的不是数字请重新输入(scanner.next()));
                    scanner.nextLine();
                }
                if (number >= 起始值_包含起始值 & number < 末值_不包含末值本身) {
                    break;

                } else {
                    System.out.println(文本合集.工厂方法(language).输入的数字不在范围内(起始值_包含起始值, 末值_不包含末值本身, number));
                }
            }
            return number;
        }


    }

    /**
     * 提供创建棋盘，创建坐标棋盘，拷贝棋盘功能
     * 请使用get方法创建棋盘
     */
    private class 创建棋盘 {
        private String[][] 棋盘;
        private String[][] 坐标棋盘;

        private void 创建棋盘(int 棋盘长, int 棋盘宽, String[] 公司姓名) {
            String[][] 棋盘 = new String[棋盘长][棋盘宽];
            Random random = new Random();


            for (String s : 公司姓名) {
                while (true) {
                    int r1 = random.nextInt(0, 棋盘长);
                    int r2 = random.nextInt(0, 棋盘宽);
                    if (棋盘[r1][r2] == null) {
                        棋盘[r1][r2] = s;
                        break;
                    }
                }
            }

            this.棋盘 = 棋盘;


        }

        private void 创建坐标棋盘(int 棋盘长, int 棋盘宽) {
            String[][] 棋盘 = new String[棋盘长][棋盘宽];
            for (int i = 0; i < 棋盘长; i++) {
                for (int j = 0; j < 棋盘宽; j++) {
                    棋盘[i][j] = STR." \{i},\{j} ";
                }

            }
            this.坐标棋盘 = 棋盘;

        }

        public String[][] get坐标棋盘(int 棋盘长, int 棋盘宽) {
            创建坐标棋盘(棋盘长, 棋盘宽);
            return this.坐标棋盘;
        }

        public String[][] get棋盘(int 棋盘长, int 棋盘宽, String[] 公司姓名) {
            创建棋盘(棋盘长, 棋盘宽, 公司姓名);
            return this.棋盘;
        }

        public String[][] 棋盘拷贝(String[][] 棋盘源) {
            String[][] Temp = new String[棋盘源.length][];
            for (int i = 0; i < 棋盘源.length; i++) {
                Temp[i] = Arrays.copyOf(棋盘源[i], 棋盘源[i].length);
            }


            return Temp;
        }

        public void 列举棋盘(String[][] 棋盘) {
            for (String[] strings : 棋盘) {
                for (String s : strings) {
                    System.out.print(STR."[\{s}]");
                }
                System.out.println("\n");
            }
        }


    }

    private class 游戏1 implements 游戏逻辑 {

        @Override
        public void 游戏逻辑() throws Exception {
            创建棋盘 创建棋盘 = new 创建棋盘();
            String[][] 棋盘 = 创建棋盘.get棋盘(棋盘长, 棋盘宽, 公司姓名);
            String[][] 备份棋盘 = new 创建棋盘().棋盘拷贝(棋盘);
            ArrayList<String> 中标公司 = new ArrayList<>();

            System.out.println(文本合集.工厂方法(language).下面是一个棋盘里面是坐标());

            创建棋盘.列举棋盘(创建棋盘.get坐标棋盘(棋盘长, 棋盘宽));

            System.out.println(文本合集.工厂方法(language).有几个公司在这个棋盘里输入坐标看看有没有命中一个公司你有几次机会看看能命中多好个公司());


            for (int i = 公司姓名.length - 1; i >= 0; i--) {
                int 长的值 = new 合法性检查().获得合法数字输入(0, 棋盘长, 文本合集.工厂方法(language).输入第一个坐标());
                int 宽的值 = new 合法性检查().获得合法数字输入(0, 棋盘宽, 文本合集.工厂方法(language).输入第二个坐标());
                if (棋盘[长的值][宽的值] == null) {
                    System.out.println(文本合集.工厂方法(language).很遗憾没命中剩余几次机会(i));
                } else {
                    System.out.println(文本合集.工厂方法(language).恭喜命中(i, 棋盘[长的值][宽的值]));
                    中标公司.add(棋盘[长的值][宽的值]);
                    棋盘[长的值][宽的值] = null;
                }
            }

            if (中标公司.size() == 0) {
                System.out.println(STR."""
\{文本合集.工厂方法(language).很遗憾没有命中任何东西()}
\{文本合集.工厂方法(language).棋盘数据如下()}""");

            } else {
                System.out.println(STR."""
\{文本合集.工厂方法(language).恭喜您命中了以下内容(中标公司.toString())}
\{文本合集.工厂方法(language).棋盘数据如下()}""");
            }

            创建棋盘.列举棋盘(备份棋盘);

        }
    }

    private class 枚举合集 {
        enum 语言合集 {
            English("en_us"),
            简体中文("zh_cn"),
            日本語("ja_jp"),
            한국어("ko_kr");
            String 语言;

            语言合集(String 语言) {
                this.语言 = 语言;
            }

            public String get语言() {
                return this.语言;
            }
        }


        enum 已有游戏 {
            游戏1("游戏1");

            String 游戏;

            已有游戏(String 游戏) {
                this.游戏 = 游戏;
            }

            public String get游戏() {
                return this.游戏;
            }

        }


    }


}
