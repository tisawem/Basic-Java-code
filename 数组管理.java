import java.util.Scanner;

public class 数组管理 {
    public static void main(String[] args) {
        Scanner userinput=new Scanner(System.in);
        System.out.println("输入行和列创建数组");



        u:while (true) {
            if (userinput.hasNextInt()) {//检查用户输入
                int q= userinput.nextInt(),w= userinput.nextInt();//设置2个变量，q为行，w为列
                if(q>0&w>0) {

                    String a[][] = new String[q][w];
                    System.out.println("输入完成");
                    userinput.nextLine();

                    for (int e=0;e<q;e++){//将用户数据存入数组
                        for (int r=0;r<w;r++){
                            System.out.println("输入"+e+"行"+r+"列");
                            a[e][r]= userinput.nextLine();
                        }


                    }
                    userinput.nextLine();

                    System.out.println("访问哪行？");
                    i:while (true){

                        if (userinput.hasNextInt()){
                            int t= userinput.nextInt();
                            if (t<q){
                                System.out.println("访问哪列？");
                                userinput.nextLine();
                                int y= userinput.nextInt();
                                if (y<w){
                                    System.out.println("第"+t+"行，第"+y+"列数据为"+a[t][y]);

                                }
                                else {
                                    System.out.println("访问哪列？");
                                    userinput.nextLine();//初始化
                                }
                            }
                            else{
                                System.out.println("访问哪行？");
                                userinput.nextLine();
                            }

                        } else if (userinput.hasNext("结束")) {
                            userinput.close();
                            break u;



                        }
                        else {
                            System.out.println("访问哪行？");
                            userinput.nextLine();
                        }
                    }
                }
                else {
                    System.out.println("输入行和列创建数组");
                    userinput.next();//清空数据

                }

            } else {
                System.out.println("输入行和列创建数组");
                userinput.next();//清空数据

            }
        }


    }
}


