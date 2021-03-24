package com.xjc.study.leetcode;

/**
 * Description: TODO
 *  车位模拟
 * @author 19040838
 * @title: leetCode_1603_SimulationPark
 * Created by 19040838 on 2021.03.19 15:52
 */
public class leetCode_1603_SimulationPark {
    public static void main(String[] args) {
        leetCode_1603_SimulationPark leetCode1603SimulationPark = new leetCode_1603_SimulationPark(1,1,0);
        System.out.println(addCar(3));
    }
    private static int big,medium,small;
    public leetCode_1603_SimulationPark(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public static boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big > 0) {
                    big--;
                    return true;
                }
                break;
            case 2:
                if (medium > 0) {
                    medium--;
                    return true;
                }
                break;
            case 3:
                if (small > 0) {
                    small--;
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }
}
