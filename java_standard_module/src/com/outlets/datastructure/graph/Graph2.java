/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Graph2
 * Author:   hyqin
 * Date:     2019-04-26 16:08
 * Description: 图的数据结构，用邻接表的方式实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈图的数据结构，用邻接表的方式实现〉
 *
 * @author hyqin
 * @create 2019-04-26
 * @since 1.0.0
 */
public class Graph2 {

    class graphArray {

    }

    //保存顶点信息
    class Vertex {
        //前驱顶点
        Vertex prior;
        //权值
        Object weight;
        //后继顶点
        Vertex next;

        Vertex(Object weight) {
            this.weight = weight;
            prior = null;
            next = null;
        }

        Vertex() {
        }

    }

    public void create() {
        Vertex vertices[] = new Vertex[Graph.MAX_NODE_NUM];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex();
        }

        //构造
        vertices[0].next = new Vertex(1);
        vertices[0].next.next = new Vertex(2);
        vertices[1].next = new Vertex(6);
        vertices[2].next = new Vertex(3);

        //打印


    }

}
