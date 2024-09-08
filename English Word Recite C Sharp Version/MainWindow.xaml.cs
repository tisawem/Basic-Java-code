using Microsoft.Win32;
using System.IO;
 
using System.Windows;
using System.Windows.Controls;
 

namespace English_Word_Recite_C_Sharp_Version
{

    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {


        private static Random rng = new Random();
        void 列表同步()
        {
            原文列表项.Items.Clear();
            译文列表项.Items.Clear();

            foreach (string i in 用户打开的原文文件转成的列表)
            {
                原文列表项.Items.Add(i);
            }
            foreach (string i in 用户打开的译文文件转成的列表)
            {
                译文列表项.Items.Add(i);
            }

        }
 public    static   List<String> 用户打开的原文文件转成的列表=[];
    public static     List<String> 用户打开的译文文件转成的列表 = [];

        List<String> 原文列表备份 = [];
        List<String> 译文列表备份 = [];

        public MainWindow()
        {
            InitializeComponent();
        }

        //配置-选择原文按钮
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // 创建一个OpenFileDialog实例
            OpenFileDialog openFileDialog = new()
            {
                // 设置文件过滤器，例如只显示文本文件
                Filter = "原文 (*.txt)|*.txt|任意文件 (*.*)|*.*",

                // 允许用户选择多个文件
                Multiselect = false
            };

            // 显示对话框并检查用户是否选择了文件
            if (openFileDialog.ShowDialog() == true)
            {
                // 获取选中的文件路径
                SelectedOriginalFiles.Text = openFileDialog.FileNames[0];

            }
        }


        //配置-原文文本框更改，打开文件
        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                用户打开的原文文件转成的列表 = new(File.ReadAllLines(SelectedOriginalFiles.Text));
                列表同步();

                原文列表备份.Clear();



                foreach (string i in 用户打开的原文文件转成的列表)
                {
                    原文列表备份.Add(i);

                }
            }
            catch
            {
                MessageBox.Show($"打不开文件\n {SelectedOriginalFiles.Text}", "内容打不开", MessageBoxButton.OK, MessageBoxImage.Error);
            }
            
         
        }

        private void TextBox_TextChanged_1(object sender, TextChangedEventArgs e)
        {
            try
            {
                用户打开的译文文件转成的列表 = new(File.ReadAllLines(SelectedTranslationFiles.Text));
                列表同步();


                译文列表备份.Clear();

                foreach (string i in 用户打开的译文文件转成的列表)
                {
                    译文列表备份.Add(i);
                }


            }
            catch
            {
                MessageBox.Show($"打不开文件\n {SelectedTranslationFiles.Text}", "内容打不开", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void ListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void TabControl_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            
            
        }


        //配置-选择译文按钮
        private void 选择译文_Click(object sender, RoutedEventArgs e)
        {
            // 创建一个OpenFileDialog实例
            OpenFileDialog openFileDialog = new()
            {
                // 设置文件过滤器，例如只显示文本文件
                Filter = "译文 (*.txt)|*.txt|任意文件 (*.*)|*.*",

                // 允许用户选择多个文件
                Multiselect = false
            };

            // 显示对话框并检查用户是否选择了文件
            if (openFileDialog.ShowDialog() == true)
            {
                // 获取选中的文件路径
                SelectedTranslationFiles.Text = openFileDialog.FileNames[0];

            }
        }

        private void ListBox_SelectionChanged_1(object sender, SelectionChangedEventArgs e)
        {

        }

        private void ListBox_SelectionChanged_2(object sender, SelectionChangedEventArgs e)
        {

        }


        //打乱按钮
        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            if (用户打开的原文文件转成的列表.Count != 用户打开的译文文件转成的列表.Count)
            {
                MessageBox.Show("您的原文和译文的数量不匹配。\n请您一一匹配原文和译文");
                return;
            }
           

            HashSet<int> randomNumberSet = [];

            while (randomNumberSet.Count< 用户打开的原文文件转成的列表.Count)
            {
                randomNumberSet.Add(rng.Next(0, 用户打开的原文文件转成的列表.Count));
            }
            用户打开的原文文件转成的列表.Clear();
            用户打开的译文文件转成的列表.Clear();

            foreach(int i in randomNumberSet)
            {
                用户打开的原文文件转成的列表.Add(原文列表备份[i]);

                 
                    用户打开的译文文件转成的列表.Add(译文列表备份[i]);
                 
                 
            }

            列表同步();
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            if (原文列表备份.Count == 0 || 译文列表备份.Count == 0)
            {
                return;
            }


            用户打开的原文文件转成的列表 .Clear();
            用户打开的译文文件转成的列表 .Clear();

            列表同步();

            foreach(string i in 原文列表备份)
            {
                用户打开的原文文件转成的列表.Add(i);
            }
            foreach(string i in 译文列表备份)
            {
                用户打开的译文文件转成的列表.Add(i);
            }
            列表同步();

        }


        //开始测试的按钮
        private void Button_Click_3(object sender, RoutedEventArgs e)
        {

            if (MainWindow.用户打开的原文文件转成的列表.Count != MainWindow.用户打开的译文文件转成的列表.Count)
            {


                MessageBox.Show("原文和译文对不上！", "警告", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }
            if (MainWindow.用户打开的原文文件转成的列表.Count == 0)
            {
                MessageBox.Show("还没有添加单词", "警告", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }


            给原文选译文 test = new();
            test.Show();
            
        }
    }
}