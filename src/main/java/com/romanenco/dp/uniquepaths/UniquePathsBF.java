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

package com.romanenco.dp.uniquepaths;

/**
 * Unique paths problem.
 * https://oj.leetcode.com/problems/unique-paths/
 *
 * Brute force solution.
 *
 * See http://www.romanenco.com/unique-paths-problem/
 *
 * @author Andrew Romanenco
 *
 */
public class UniquePathsBF {

    public long uniquePathsTD(int m, int n) {
        return paths(0, 0, m, n);
    }

    private long paths(int i, int j, int m, int n) {
        if ((i == m)||(j == n)) {
            return 0;
        }
        if ((i == m - 1)||(j == n - 1)) {
            return 1;
        }
        return paths(i + 1, j, m, n) + paths(i, j + 1, m, n);
    }

}
