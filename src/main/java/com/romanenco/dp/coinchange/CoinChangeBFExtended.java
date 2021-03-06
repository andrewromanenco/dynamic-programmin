/*
 * Copyright 2014 Andrew Romanenco
 * www.romanenco.com
 * andrew@romanenco.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.romanenco.dp.coinchange;

import java.util.HashMap;
import java.util.Map;

/**
 * Coin change problem.
 * Brute force solution with recursive calls stats.
 * See http://www.romanenco.com/coin-change-problem/
 *
 * @author Andrew Romanenco
 *
 */
public class CoinChangeBFExtended {

    private final Map<Integer,Integer> calls = new HashMap<>();

    public int getMinNumberOfCoins(int[] coins, int sum) {
        if (sum == 0) {
            return 0;  //base case
        }
        calls.put(sum, 1 + (calls.containsKey(sum)?calls.get(sum):0));
        int result = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (coin <= sum) {
                result = Math.min(
                        result,
                        getMinNumberOfCoins(coins, sum - coin) + 1
                        );
            }
        }
        return result;
    }

    public void printCallsStats() {
        for (int sum: calls.keySet()) {
            System.out.println(String.format("%d: %d", sum, calls.get(sum)));
        }
    }

}
