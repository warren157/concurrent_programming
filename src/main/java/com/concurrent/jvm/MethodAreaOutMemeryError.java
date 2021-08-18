package com.concurrent.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author rui.wang
 * @version 1.0
 * @description: -XX:MaxMetaspaceSize=256m
 * @date 2021/7/8 14:28
 */
public class MethodAreaOutMemeryError extends ClassLoader {
    public static void main(String[] args) {
        int j=0;
        try {
            MethodAreaOutMemeryError mm = new MethodAreaOutMemeryError();
            for(int i=0;i<1000000;i++,j++) {
                //生成类的而二进制字节码
                ClassWriter writer = new ClassWriter(0);
                writer.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                byte[] code = writer.toByteArray();
                mm.defineClass("Class"+i,code,0,code.length);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(j);
        }finally {
            System.out.println(j);
        }

    }
}
