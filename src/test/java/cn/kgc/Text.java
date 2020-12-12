package cn.kgc;

public class Text {
    public void method1(String info) {
        info = info + "!";
        System.out.println(info);
    }
    public static void main(String[] args) {
        int num=4;
        num = change(num);
        num = change(num);
        System.out.println(num);

    }

    public static int change(int num) {
        num++;
        return num;
    }
}
