import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tisawem東北項目
 *
 * <p>这个注解仅作为象征意义</p>
 * <p>我更喜欢版本二</p>
 * <p>Bilibili UID:394047428 这个UP主创建了“动站”，远离鱼目混珠，良莠不齐的兽圈，致力于打造洁净的拟动物的圈子</p>
 * <p>这个注解的诞生，理由类似。</p>
 * <p>添加了这个注解，就宣誓自己是一个高贵的程序员，</p>
 * <p>远离那些自以为是，不听劝，愚钝之巅的初学者，用户和杜振川。</p>
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoJavaAPI {

    String programming_Language();

    String Oath_Of_No_Java_API$Ver_1 = """
            No Java API
            誓言
            
            我是一名使用JVM编程语言的开发者。
            我不是愚钝之巅，具备正确的Java基础，了解自己的编程水平。
            我力求进步，广纳百川，了解其他编程语言，熟悉各种范式。
            我学习其他JVM编程语言，利用更好的语法特性，在JVM平台开发更具水平的程序。
            
            我力求程序健壮性，遵循良好的设计模式，尽量消除编译器警告。
            我不顽固守旧，不畏惧兼容性问题。
            我使用最新长期支持版本，摒弃过时API，接纳新特性。
            
            我遇到问题不会埋怨，既要自己解决问题，也要积极寻求帮助。
            我以友好，谦虚的态度与程序员交流，我不倔强到底，我不盲目服从。
            我意识到自己可能有错误，会采纳各位建议，纠正自己的错误。
            我对别人的观点产生怀疑，会查阅各种资料，坚定自己的立场。
            
            我有操守，遵循代码的许可证，尊重代码开发者的意向。
            
            
            No Java API
            Oath
            
            I am a developer using a JVM programming language.
            I am not at the peak of ignorance; I have a solid foundation in Java and understand my own programming abilities.
            I strive for improvement, learn from a wide variety of sources, understand other programming languages, and become familiar with different paradigms. \s
            I study other JVM languages and leverage better syntax features to develop more advanced programs on the JVM platform.
            
            I pursue robustness in my programs, follow good design patterns, and aim to eliminate compiler warnings.
            I am not stubbornly attached to the past, nor do I fear compatibility issues.
            I use the latest long-term support versions, abandon outdated APIs, and embrace new features.
            
            When facing problems, I do not complain; I solve issues myself and actively seek help when needed.
            I interact with other programmers in a friendly, humble manner. I am neither obstinate nor blindly submissive.
            I acknowledge that I may be wrong and am willing to accept suggestions to correct my mistakes.
            I question others' opinions, research thoroughly, and solidify my own stance.
            
            I am principled, follow code licenses, and respect the intentions of code developers.
            
            """;

    /**
     * 这个版本的誓言，俗称“反 杜振川 誓言”
     * <p>
     * No Java API，我也想翻译成“反 杜振川 API”
     * <p>
     * 这才是我真正想要的誓言
     */
    String Oath_Of_No_Java_API$Ver_2 = """
            No Java API
            誓言
            
            我是使用JVM编程语言的开发者，不是各位的出气筒。
            你们全是傻逼，都处在愚钝之巅。
            你们愚昧无知， Java基础完全没有。
            你们只会逼逼赖赖，磨牙放屁。
            和你们交流，你们只会往死里倔，只会抬杠。
            你们忘恩负义，帮助你们只会受一肚子气，出了差错就要挨骂。
            你们是Java的奴隶，不知道Kotlin，Scala，Groovy，Clojure。
            你们顽固不灵，固步自封，死守JDK 1.8，新的语法会报错，只会怪罪我们程序员。
            你们就是抠逼，穷逼，傻逼，二逼，操你妈了个逼。
            所以，我宣誓，身为JVM程序员。
            我不需要慷慨解囊，多一事不如少一事。
            拒绝帮助只会Java的傻逼，不懂基础的傻逼，杠精，白眼狼。
            我们信仰No Java API，就要谈笑有鸿儒，往来无白丁。
            我们信仰No Java API，就要放低姿态，虚心求教。
            我们信仰No Java API，就要广纳百川，取其精华，去其糟粕。
            我们信仰No Java API，就应有自知之明，承认错误，改过自新。
            
            No Java API
            Oath
            
            I am a developer using JVM programming languages, not your punching bag.
            You are all idiots, stuck in the Dunning-Kruger peak.
            You are ignorant and clueless, with no understanding of basic Java.
            All you do is complain and talk nonsense.
            When I talk to you, all you do is stubbornly argue and nitpick.
            You are ungrateful; helping you only brings frustration, and when mistakes happen, we get blamed.
            You are slaves to Java, unaware of Kotlin, Scala, Groovy, or Clojure.
            You are obstinate and stagnant, clinging to JDK 1.8. When new syntax causes errors, you blame us developers.
            You are cheapskates, broke, idiots, douchebags, dumbasses, and dipshits. Fuck you.
            So, I swear, as a JVM programmer:
            I don't need to be generous—less is more.
            I refuse to help idiots who only know Java, those who lack basic knowledge, nitpickers, and ingrates.
            We believe in No Java API, to engage in meaningful conversations with knowledgeable people, avoiding the ignorant.
            We believe in No Java API, to humble ourselves and seek knowledge.
            We believe in No Java API, to embrace diversity, take in the good, and discard the bad.
            We believe in No Java API, to have self-awareness, admit mistakes, and correct them.
            """;



    /**
     *我和杜振川急眼后，杜振川终于不来烦我了
     *我终于消停了
     * <p>
     *
     * 我身边还好大多数都是正常人，虽然不如杜振川知道的多，但是这些人不倔强，他们信任我，我也在能解决的前提下解决
     * <p>
     * 我也在班里碰到一个高手，他进过工坊，了解的比我还多，最起码他知道Scala，他也做过游戏，这可能就是真正的高手，而不是知道的多，但全是错误的杜振川。
     * */
    String 杜振川圣经_Java_Home篇 = """
            杜振川认为，安装JDK必须手动配置环境变量
            我告诉他不用，Oracle JDK，Eclipse Adoptium的安装包，会自动帮你设置Java Home，直接安装即可。
            杜振川想试试，顺利的安装了Oracle JDK。
            我让他在命令提示符内，输入java -version
            
            得到了：
            ```
            java version "21.0.5" 2024-10-15 LTS
            Java(TM) SE Runtime Environment (build 21.0.5+9-LTS-239)
            Java HotSpot(TM) 64-Bit Server VM (build 21.0.5+9-LTS-239, mixed mode, sharing)
            ```
            多么完美的结果，太OK了
            
            杜振川不干了，问我：我的JDK 11呢，你给我安装3个JDK干什么（java -version得到的三行输出）
            那好，你既然要JDK 11，那我卸了Oracle JDK，给你安装eclipse adoptium
            杜振川也不干，不让我再安装了
            他直接删了JDK 21的安装文件，导致再次输入java -version什么都得不到
            杜振川得出了：安装JDK必须手动配置环境变量
            
            杜振川还问过我，JDK 21是否包含JDK 8？
            我的回答就是JDK 21就是JDK 21，他不包含JDK 8，它兼容JDK 1.8
            
            杜振川最期待的java -version会得到什么呢？
            既要有JDK 21，又要有JDK 11的结果
            Java的环境变量也只能指定一个JDK，输出的结果是只有21，没有11。他不干
            
            他把我气急眼的是，他安装的破解版的intellij idea ultimate启动不了，具体什么报错我也不知道，他赖我，我安装的Oracle JDK把他的idea搞坏了，他一直苦恼着，埋怨
            
            杜振川还有一点，跟谭浩强的C语言程序设计那样，叭叭叭的，算法最重要，算法天下第一
            杜振川始终认为Minecraft的存在，就意味着Java擅长做游戏
            杜振川始终认为自己作为初学者，唯唯诺诺，总是说：毕竟我们是初学者嘛
            杜振川不知道，也瞧不起Kotlin和Scala，他只知道Java
            
            """;
    String 杜振川圣经_充电篇 = """
            1、手机充电器，67W，在5V电压下，最高3A电流。所以，不能使用该充电器给蓝牙耳机这样低功率设备充电，3A电流会让设备受不了。
            2、手机充电，到80%的电量就该停止充电，不能一直插着充电线充电，否则损伤电池
            """;

    String 杜振川圣经_MSWindows篇 = """
            3、永远不要装Windows 11，Windows 7是最好的，这个我不反驳。但是，他居然想给12代core处理器装Windows 7
            他不知道12代core处理器有大小核设计，注定系统最低是Windows 11
            也不知道Windows 10以下的操作系统对现代硬件的兼容性问题，有没有驱动都是问题
            也不知道UEFI，只知道BIOS，如果他想，他能认为电脑能安装Windows XP
            4、他想换电脑，但不接受在全新的操作系统安装一堆软件，他就考虑把旧电脑硬盘拆掉，安装在新的电脑上，祝愿他碰到BitLocker锁的问题。
            5、硬盘只有一个C盘，是愚蠢的决定，反正他骂我蠢
            为什么呢？重新安装系统，C盘的数据就全抹了，其他盘的数据不会抹除。
            我最有反驳的权利
            1、即使应用程序都安装在其他盘符，也不意味着重装完系统后就完全不用重新安装应用程序，也不意味着应用的用户数据不会丢。他不知道注册表，也不知道AppData
            2、你可以不格式化C盘，使用Windows安装程序，Windows安装程序会把以前的Windows放在Windows.old文件夹下，C盘的其他文件夹和文件不会动
            3、最好依赖文件夹分开存放不同的数据，而不是分许多的分区，去归放不同的文件
            
            
            有一次，杜振川的电脑，不识别拓展坞的网卡模块，网卡自己变成了CD驱动器，里面刚好有一个安装程序，吸引着你去点击它
            但杜振川，就不点它，理由是Realtek是造声卡的，它是声卡驱动
            他就在网上，B站上搜索电脑不识别拓展坞的网卡的原因
            他也不会搜，也不会提炼关键字
            这些教程，无一例外，前提是在 控制面板/网络和 Internet/网络和共享中心，点击更改适配器设置，找到该适配器，去整乱七八糟的设置
            电脑找不到这个适配器诶，电脑就认为它是CD驱动器诶，适配器乖乖的给你驱动了，你不点。
            别赖自己的电脑是垃圾，你才是垃圾
            到最后，电脑可能自己找到驱动了，或者驱动突然好了，识别到了这个网卡适配器
            这件事，他赖Windows Update
            """;



}
