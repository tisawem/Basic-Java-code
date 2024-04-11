package 灭掉7乘7数组里的所有元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 启动游戏 {
    private byte 棋盘长;
    private byte 棋盘宽;
    private String 公司姓名[];
    private static final Scanner scanner = new Scanner(System.in);



    //唯一构造器
    public 启动游戏(byte 棋盘长, byte 棋盘宽, String[] 公司姓名) throws Exception {


        //检查棋盘长宽合法性
        if (棋盘宽 < 3 || 棋盘长 < 3) {
            throw new Exception("棋盘设置无效,最小3*3");
        } else {
            this.棋盘长 = 棋盘长;
            this.棋盘宽 = 棋盘宽;
        }


        //检查公司姓名数组的合法性
        if (公司姓名 == null) {//传递的不能是null
            throw new Exception("不允许null值");
        } else if (公司姓名.length == 0 || 公司姓名.length > 棋盘长 * 棋盘宽) {//公司姓名不允许超过棋盘大小
            throw new Exception(STR."请设立≥1,≤\{棋盘长 * 棋盘宽}个公司");
        }

        //传递的集合里面不能有null
        else {
            for (String s : 公司姓名) {
                if (s == null) {
                    throw new Exception("集合内禁止有null元素");
                }
            }
            this.公司姓名 = 公司姓名;
            游戏逻辑();
        }//else结束，数组检查完毕

    }//含参构造器结束


    private void 游戏逻辑() {

        class 一些验证用的类 {
            int 合理的第一个坐标() {

                System.out.print("请输入坐标第一个值");
                while (true) {
                    if (scanner.hasNextInt()) {
                        int i = scanner.nextInt();
                        if (i < 棋盘长 && i >= 0) {
                            return i;
                        } else {
                            System.out.print(STR."\{i}无效,重新输入第一个坐标");
                        }

                    } else {
                        System.out.print(STR."\{scanner.next()}无效,重新输入第一个坐标");
                    }
                }
            }

            int 合理的第二个坐标() {

                System.out.print("请输入坐标第二个值");
                while (true) {
                    if (scanner.hasNextInt()) {
                        int i = scanner.nextInt();
                        if (i < 棋盘宽 && i >= 0) {
                            return i;
                        } else {
                            System.out.print(STR."\{i}无效,重新输入第一个坐标");
                        }

                    } else {
                        System.out.print(STR."\{scanner.next()}无效,重新输入第一个坐标");
                    }
                }
            }
        }
        class 设定棋盘类 {
            String[][] 罗列棋盘() {
                String[][] 棋盘 = new String[棋盘长][棋盘宽];//创建一个棋盘


                Random 随机数 = new Random();//创建一个随机数的实例


                棋盘[随机数.nextInt(0, 棋盘长)][随机数.nextInt(0, 棋盘宽)] = 公司姓名[0];//将第一个公司姓名落在棋盘

                //设置第二到最后一个公司名字落在棋盘的位置
                for (byte i = 1; i < 公司姓名.length; i++) {

                    while (true) {
                        //不放在while外面的原因是保证每次循环都会重设一个随机数
                        int 随机长 = 随机数.nextInt(0, 棋盘长), 随机宽 = 随机数.nextInt(0, 棋盘宽);

//如果该位置是null，公司名称就设定在这个位置，如果有名字了，就接着循环，直到找到null位置，跳出这次while循环
                        if (棋盘[随机长][随机宽] == null) {
                            棋盘[随机长][随机宽] = 公司姓名[i];
                            break;
                        }
                    }
                }

                //可以删除
                for (String[] 测试 : 棋盘) {
                    for (String 测试1 : 测试) {
                        //System.out.print(STR."[\{测试1}]");
                    }
                    //System.out.print("\n");

                }


                return 棋盘;


            }
        }

        String 棋盘[][] = new 设定棋盘类().罗列棋盘();
        String 备份棋盘[][] = new String[棋盘长][棋盘宽];
        ArrayList<String> 选中的公司 = new ArrayList<>();//可变数组，累计命中的公司


        System.out.print("棋盘长这个样子");
        for (int i = 0; i < 棋盘长; i++) {
            for (int j = 0; j < 棋盘宽; j++) {
                System.out.print(STR."[\{i}，\{j}]");//列举棋盘
                备份棋盘[i][j] = 棋盘[i][j];//往备份棋盘写入数据
            }
            System.out.print("\n");
        }
        System.out.print(STR."""
                游戏规则：你有\{公司姓名.length}机会，
                敲坐标第一个和第二个值，看看是否命中一个公司
                命中一个，剩余公司就少一个
                机会完毕后，列举所有命中的公司。
                """);


        for (String _ : 公司姓名) {
            int x = new 一些验证用的类().合理的第一个坐标(), y = new 一些验证用的类().合理的第二个坐标();//获得合理数值的坐标

            if (棋盘[x][y] != null) {
                System.out.print(STR."恭喜你成为\{棋盘[x][y]}的CEO\n");

                选中的公司.add(棋盘[x][y]);
                棋盘[x][y] = null;

            } else {
                System.out.print("很遗憾，未选中公司\n");
            }
        }//记录命中了几个公司
        if (选中的公司.isEmpty()) {
            System.out.print("很遗憾，你没有选中任何公司\n棋盘数据:\n");
        } else {
            System.out.print(STR."恭喜命中了\{Arrays.toString(选中的公司.toArray())}\n棋盘数据:\n");
        }
        for (String[] strings : 备份棋盘) {
            for (String s : strings) {
                System.out.print(STR."[\{s}]");
            }
            System.out.print("\n");

        }
scanner.close();
    }



}//启动游戏类结束


