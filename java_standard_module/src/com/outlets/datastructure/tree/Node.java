/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Node
 * Author:   hyqin
 * Date:     2019-04-30 19:46
 * Description: 定义二叉树的节点
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.tree;

/**
 * 〈一句话功能简述〉<br>
 * 〈定义二叉树的节点〉
 *
 * @author hyqin
 * @create 2019-04-30
 * @since 1.0.0
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
