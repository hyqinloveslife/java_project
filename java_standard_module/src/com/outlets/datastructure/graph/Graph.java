/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Graph
 * Author:   hyqin
 * Date:     2019-04-26 15:58
 * Description: 图的实现方式，通过邻接矩阵的方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.graph;

import com.sun.istack.internal.NotNull;

/**
 * 〈一句话功能简述〉<br> 〈图的实现方式，通过邻接矩阵的方式〉 这不就是一个二维数组吗？
 *
 * @author hyqin
 * @create 2019-04-26
 * @since 1.0.0
 */
public class Graph {
    public static final int MAX_NODE_NUM = 3;

    //这是一种邻接矩阵的方式
    static int graphs[][] = new int[MAX_NODE_NUM][MAX_NODE_NUM];

    public static void main(String[] args) {
        print(graphs);
    }

    @NotNull
    public static void print(int[][] graphs) {
        for (int i = 0; i < graphs.length; i++) {
            for (int j = 0; j < graphs[i].length; j++) {
                System.out.print(graphs[i][j] + " ");
            }
            System.out.println();
        }

    }

}
