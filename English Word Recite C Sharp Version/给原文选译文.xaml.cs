
using System.Windows;
using System.Windows.Controls;
 

namespace English_Word_Recite_C_Sharp_Version
{
    /// <summary>
    /// 给原文选译文.xaml 的交互逻辑
    /// </summary>
 


    public partial class 给原文选译文 : Window
    {
        private QuizManager quizManager;
        private string 当前原文;

        public 给原文选译文()
        {
            InitializeComponent();

            // 初始化 QuizManager，传入题库数据
            quizManager = new QuizManager(MainWindow.用户打开的原文文件转成的列表, MainWindow.用户打开的译文文件转成的列表);

            // 加载第一个题目
            加载题目();
        }

        // 加载下一题
        private void 加载题目()
        {
            try
            {
                当前原文 = quizManager.GetNextQuestion();
                原文显示框.Text = 当前原文;

                // 获取选项并显示
                List<string> 选项 = quizManager.GetAnswerOptions(当前原文, (int)几个选项.Value);
                译文选择列表.Items.Clear();
                foreach (var 选项内容 in 选项)
                {
                    译文选择列表.Items.Add(选项内容);
                }
            }
            catch (InvalidOperationException)
            {
                MessageBox.Show("题目已答完！");
                this.Close(); // 关闭窗口
            }
        }

        // 当用户选择译文时触发
        private void ListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var selectedItem = (sender as ListBox).SelectedItem;

            if (selectedItem != null)
            {
                bool isCorrect = quizManager.CheckAnswer(当前原文, selectedItem.ToString());
                if (isCorrect)
                {
                    MessageBox.Show($"{当前原文}的翻译是：{selectedItem}", "恭喜答对！");
                    加载题目(); // 加载下一题
                }
                else
                {
                    MessageBox.Show("很遗憾，没答对", "", MessageBoxButton.OK, MessageBoxImage.Stop);
                    译文选择列表.Items.Remove(selectedItem); // 移除错误选项
                }
            }
        }

        private void Slider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {

        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }
    }
    public class QuizManager
    {
        private List<string> 原文列表;
        private List<string> 译文列表;
        private Dictionary<string, string> 原文译文词典;
        private Queue<string> 剩余考题;

        private Random random = new Random();

        public QuizManager(List<string> 原文列表, List<string> 译文列表)
        {
            this.原文列表 = 原文列表;
            this.译文列表 = 译文列表;

            InitializeDictionaries();
        }

        private void InitializeDictionaries()
        {
            原文译文词典 = new Dictionary<string, string>();
            for (int i = 0; i < 原文列表.Count; i++)
            {
                原文译文词典.Add(原文列表[i], 译文列表[i]);
            }

            剩余考题 = new Queue<string>(原文列表);
        }

        // 返回下一题的原文
        public string GetNextQuestion()
        {
            if (剩余考题.Count > 0)
            {
                return 剩余考题.Dequeue();
            }
            else
            {
                throw new InvalidOperationException("没有更多的题目了");
            }
        }

        // 获取随机的译文选项（包含正确答案和若干错误答案）
        public List<string> GetAnswerOptions(string 当前原文, int 选项数量)
        {
            var options = new List<string>();
            options.Add(原文译文词典[当前原文]); // 添加正确答案

            HashSet<string> NotCorrectSelection = new HashSet<string>();

            while (NotCorrectSelection.Count < 选项数量 - 1)
            {
                string 随机译文 = 译文列表[random.Next(译文列表.Count)];
                if (随机译文 != 原文译文词典[当前原文])
                {
                    NotCorrectSelection.Add(随机译文);
                }
            }

            options.AddRange(NotCorrectSelection);

            // 随机打乱顺序
            Shuffle(options);

            return options;
        }

        private void Shuffle(List<string> list)
        {
            for (int i = list.Count - 1; i > 0; i--)
            {
                int swapIndex = random.Next(i + 1);
                var temp = list[i];
                list[i] = list[swapIndex];
                list[swapIndex] = temp;
            }
        }

        public bool CheckAnswer(string 当前原文, string 用户选择的译文)
        {
            return 原文译文词典[当前原文] == 用户选择的译文;
        }
    }
}
