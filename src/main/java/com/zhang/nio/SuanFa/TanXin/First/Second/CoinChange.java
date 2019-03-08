package com.zhang.nio.SuanFa.TanXin.First.Second;

public class CoinChange {
    public static void main(String[] args)
    {
        //人民币面值集合
        int[] values = { 1, 2, 5, 10, 20, 50, 100 };
        //各种面值对应数量集合
        int[] counts = { 3, 1, 2, 1, 1, 3, 5 };
        //求442元人民币需各种面值多少张
        int[] num = change(442, values, counts);
        print(num, values);
    }
    public static int[] change(int money, int[] values, int[] counts) {
        //用来记录需要的各种面值张数
        int[] result = new int[values.length];

        for (int i = values.length - 1; i >= 0; i--) {
            int num = 0;
            //需要最大面值人民币张数
            int c = min(money / values[i], counts[i]);
            //剩下钱数
            money = money - c * values[i];
            //将需要最大面值人民币张数存入数组
            num += c;
            result[i] = num;
        }
        return result;
    }

    /**
     * 返回最小值
     */
    private static int min(int i, int j) {
        return i > j ? j : i;
    }

    private static void print(int[] num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num[i] != 0) {
                System.out.println("需要面额为" + values[i] + "的人民币" + num[i] + "张");
            }
        }
    }
}
