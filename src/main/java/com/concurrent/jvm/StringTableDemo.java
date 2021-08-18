package com.concurrent.jvm;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/8 15:46
 */
public class StringTableDemo {
    //常量池中的信息，都会被加载倒运行吃常量池中，这时，a b ab 都是常量池中的符号，还没变为 java字符串对象
    //ldc #2 会把 a符号变为 a字符串对象，放入StringTable[]中
    //ldc #3 会把 b符号变为 b字符串对象，放入StringTable[]中
    //ldc #4 会把 ab符号变为 ab字符串对象，放入StringTable[]中
    //最后StringTable中保存形式为：[a,b,ab]
    public static void main(String[] args) {
        String s1="a"; //ldc #2
        String s2 = "b"; //ldc #3
        String s3= "ab"; // ldc #4
        String s4 = s1+s2;  //new StringBuilder().appedn("a").append("b").toString(),toString() 中new String("ab")
        /*
        : new           #5                  // class java/lang/StringBuilder
        12: dup
        13: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
        16: aload_1
        17: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        20: aload_2
        21: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        24: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        27: astore        4
         */
        System.out.println(s4==s3); //false
        String s5  ="a"+"b"; //   46: ldc           #4                  // String ab
        //javac在编译器的优化，结果已经在编译期间确定为ab了
        System.out.println(s5==s3);
        String s6 = new String("a")+new String("b"); //new String("ab") 存放在堆中
        String s7 = s6.intern();//将这个字符串对象存入常量池中，如果有则不存放，如果没有就放入，会把串池中的对象返回
        System.out.println(s7==s3);
        System.out.println(s6 == "ab" );
    }
}

