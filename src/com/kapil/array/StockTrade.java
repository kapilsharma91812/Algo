package com.kapil.array;

/**
 * Created by kapilsharma on 24/06/17.
 */

/**
 * Maximum profit by buying and selling a share at most twice
 * Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
 * Output:  100
 * Trader earns 100 as sum of 28 and 72
 * Buy at price 2, sell at 30, buy at 8 and sell at 80
 *
 * Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
 * Output:  72
 * Buy at price 8 and sell at 80.
 *
 * Input:   price[] = {90, 80, 70, 60, 50}
 * Output:  0
 * Not possible to earn.
 */
public class StockTrade {
    public static void main(String[] args) {
        int data[] = new int[]{2, 30, 15, 10, 8, 25, 80};
        System.out.println("Max Profit: " + findMaxProfit(data));
    }

    private static int findMaxProfit(int[] data) {
        int index = 0;
        int buyIndex;
        int sellIndex = -1;
        int profit = 0;
        while (index < data.length) {
            buyIndex = doBuy(data, index);
            if (buyIndex != -1) {
                sellIndex = doSell(data, data[buyIndex], buyIndex + 1);

            }
            if (buyIndex != -1 && sellIndex != -1) {
                profit += data[sellIndex] - data[buyIndex];
                System.out.println("Purchasing at:" + data[buyIndex] + " and selling at:" + data[sellIndex]);
            } else {
                break;
            }
            index = sellIndex + 1;

        }
        return profit;
    }

    private static int doBuy(int data[], int index) {
        int buyValue = data[index];
        int buyIndex = index;
        index++;
        while (index < data.length) {
            if (data[index] < buyValue) {
                buyValue = data[index];
                buyIndex = index;
                index++;

            } else {
                return buyIndex;
            }
        }
        return buyIndex;
    }


    private static int doSell(int data[], int buyValue, int index) {
        int sellValue = 0;
        int sellIndex = -1;
        while (index < data.length) {
            if (data[index] > buyValue && data[index] > sellValue) {
                sellValue = data[index];
                sellIndex = index;
                index++;

            } else if (sellValue == 0) {
                index++;
            } else {
                return sellIndex;
            }
        }
        return sellIndex;
    }
}
