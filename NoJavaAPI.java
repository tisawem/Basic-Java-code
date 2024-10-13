import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Tisawem東北項目
 *
 * <p>这个注解仅作为象征意义</p>
 * <p>我更喜欢版本二</p>
 * <p>Bilibili UID:394047428 这个UP主创建了“动站”，远离混乱不堪的兽圈</p>
 * <p>这个注解的诞生，理由类似。</p>
 * <p>添加了这个注解，就宣誓自己是一个高贵的程序员，远离那些智障脑残的初学者，用户和杜振川。</p>
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoJavaAPI {

    String programming_Language();

    String Oath_Of_No_Java_API$Ver_1= """
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
            
            """ ;

    /**
     * 这个版本的誓言，俗称“反 杜振川 誓言”
     * No Java API，我也想翻译成“反 杜振川 API”
     * 这才是我真正想要的誓言
     */
    String Oath_Of_No_Java_API$Ver_2= """
            No Java API
            誓言
            
            我是使用JVM编程语言的开发者，不是各位的出气筒。
            你们全是傻逼，都处在愚钝之巅。
            你们愚昧无知， Java基础完全没有。
            你们只会逼逼赖赖，磨牙放屁。
            和你们交流，你们只会往死里倔，只会抬杠。
            你们忘恩负义，帮助用户只会受一肚子气，出了差错就要挨骂。
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
            You are ungrateful; helping users only brings frustration, and when mistakes happen, we get blamed.
            You are slaves to Java, unaware of Kotlin, Scala, Groovy, or Clojure.
            You are obstinate and stagnant, clinging to JDK 1.8. When new syntax causes errors, you blame us developers.
            You are cheapskates, broke, idiots, and fools. Fuck you.
            So, I swear, as a JVM programmer:
            I don't need to be generous—less is more.
            I refuse to help idiots who only know Java, those who lack basic knowledge, nitpickers, and ingrates.
            We believe in No Java API, to engage in meaningful conversations with knowledgeable people, avoiding the ignorant.
            We believe in No Java API, to humble ourselves and seek knowledge.
            We believe in No Java API, to embrace diversity, take in the good, and discard the bad.
            We believe in No Java API, to have self-awareness, admit mistakes, and correct them.
            """;
}
