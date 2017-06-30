package com.practice.study.reflect;

import com.practice.Objects.Person;

import java.lang.reflect.*;

/**
 * Created by junwuguo on 2017/2/13 0013.
 */
public class ReflectDemo {

    private static final String currentPackage = "com.practice.study.reflect";

    /**
     * Ϊ�˿����Java���䲿�ִ��룬�����쳣�Ҷ�����׳��������������
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {

        System.out.println("demo1��ͨ��Java������Ƶõ���İ���������");
        demo1();

        System.out.println("");
        System.out.println("demo2����֤���е��඼��Class���ʵ������");
        demo2();

        System.out.println("");
        System.out.println("demo3��ͨ��Java������ƣ��� Class �����������Ҳ���Ƿ�����ڵ���������");
        demo3();

        System.out.println("");
        System.out.println("demo4��ͨ��Java������Ƶõ�һ����Ĺ��캯������ʵ�ִ�������ʵ������");
        demo4();

        System.out.println("");
        System.out.println("demo5��ͨ��Java������Ʋ�����Ա����, set �� get");
        demo5();

        System.out.println("");
        System.out.println("demo6��ͨ��Java������Ƶõ����һЩ���ԣ��̳еĽӿڡ����ࡢ������Ϣ����Ա��Ϣ�����͵�");
        demo6();

        System.out.println("");
        System.out.println("demo7��ͨ��Java������Ƶ����෽��");
        demo7();

        System.out.println("");
        System.out.println("demo8��ͨ��Java������Ƶõ����������Ϣ");
        demo8();
    }

    /**
     * demo1��ͨ��Java������Ƶõ���İ���������
     */
    public static void demo1() {
        Person person = new Person();
        System.out.println("������" + person.getClass().getPackage().getName());
        System.out.println("����������" + person.getClass().getName());
    }

    /**
     * demo2����֤���е��඼��Class���ʵ������
     */
    public static void demo2() throws ClassNotFoundException {
        //�����������Ͷ�δ֪��Class�����ó�ֵΪnull��������θ����Ǹ�ֵ��Person��
        Class<?> class1 = null;
        Class<?> class2 = null;
        //д��1�������׳� ClassNotFoundException �쳣���������д��
        class1 = Class.forName("com.practice.Objects.Person");
        System.out.println("д��1��������" + class1.getPackage().getName() + " , ����������" + class1.getName());
        //д��2
        class2 = Person.class;
        System.out.println("д��2��������" + class2.getPackage().getName() + " , ����������" + class2.getName());
    }

    /**
     * demo3��ͨ��Java������ƣ��� Class �����������Ҳ���Ƿ�����ڵ���������
     */
    public static void demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> class1 = null;
        class1 = Class.forName("com.practice.Objects.Person");
        //�������ﲻ�ܴ�������������Ҫʵ�����������Person��һ��Ҫ���޲ι��캯��
        Person person = (Person) class1.newInstance();
        person.setName("xiaoming");
        person.setAge(20);
        System.out.println(person.getName() + " , " + person.getAge());
    }

    /**
     * demo4��ͨ��Java������Ƶõ�һ����Ĺ��캯������ʵ�ִ�������ʵ������
     */
    public static void demo4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> class1 = null;
        Person person1 = null;
        Person person2 = null;

        class1 = Class.forName("com.practice.Objects.Person");
        Constructor<?>[] constructors = class1.getConstructors();

        person1 = (Person) constructors[0].newInstance();
        person1.setName("xiaoming");
        person1.setAge(20);
        System.out.println(person1.getName() + " , " + person1.getAge());
        person2 = (Person) constructors[1].newInstance(21, "xiaohong");
        System.out.println(person2.getName() + " , " + person2.getAge());
    }

    /**
     * demo5��ͨ��Java������Ʋ�����Ա����, set �� get
     */
    public static void demo5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, SecurityException {
        Class<?> class1 = Class.forName("com.practice.Objects.Person");
        Object obj = class1.newInstance();
        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true); //ȡ�����ʼ��
        personNameField.set(obj, "С��");
        System.out.println("�޸�����֮��õ����Ա�����ֵ��" + personNameField.get(obj));
    }

    /**
     * demo6��ͨ��Java������Ƶõ����һЩ���ԣ��̳еĽӿڡ����ࡢ������Ϣ����Ա��Ϣ�����͵�
     */
    public static void demo6() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("com.practice.Objects.SuperMan");

        //ȡ�ø�������
        Class<?> superclass = class1.getSuperclass();
        System.out.println("SuperMan��ĸ�������" + superclass.getName());

        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("���еĳ�Ա" + i + "�� " + fields[i]);
        }

        //ȡ���෽��
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("ȡ��SuperMan��ķ���" + i + "��");
            System.out.println("��������" + methods[i].getName());
            System.out.println("�����������ͣ�" + methods[i].getReturnType());
            System.out.println("�����������η���" + Modifier.toString(methods[i].getModifiers()));
            System.out.println("��������д���� " + methods[i]);
        }

        //ȡ����ʵ�ֵĽӿڣ���Ϊ�ӿ���Ҳ����Class�����Եõ��ӿ��еķ���Ҳ��һ���ķ����õ���
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("ʵ�ֵĽӿ������� " + interfaces[i].getName());
        }
    }

    /**
     * demo7��ͨ��Java������Ƶ����෽��
     */
    public static void demo7() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.practice.Objects.SuperMan");

        System.out.println("�����޲η���fly()��");
        Method method = class1.getMethod("fly");
        method.invoke(class1.newInstance());

        System.out.println("�����вη���walk(int m)��");
        method = class1.getMethod("walk", int.class);
        method.invoke(class1.newInstance(), 100);
    }

    /**
     * demo8��ͨ��Java������Ƶõ����������Ϣ
     * ��java�����������������
     * 1��Bootstrap ClassLoader �˼���������c++��д��һ�㿪���к��ټ���
     * 2��Extension ClassLoader ����������չ��ļ��أ�һ���Ӧ����jre\lib\extĿ¼�е���
     * 3��AppClassLoader ����classpathָ�����࣬����õļ�������ͬʱҲ��java��Ĭ�ϵļ�������
     */
    public static void demo8() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("com.practice.Objects.SuperMan");
        String name = class1.getClassLoader().getClass().getName();
        System.out.println("�������������" + name);
    }

}
