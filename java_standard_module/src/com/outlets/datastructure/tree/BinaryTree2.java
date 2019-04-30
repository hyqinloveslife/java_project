/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BinaryTree2
 * Author:   hyqin
 * Date:     2019-04-30 19:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.tree;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-04-30
 * @since 1.0.0
 */
public class BinaryTree2 {
    private Node root;

    public BinaryTree2() {
        root = null;
    }

    /**
     * 将data插入到二叉排序树中
     *
     * @param data
     */
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;

            Node parent;

            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }

        }

    }

    /**
     * 输入数值，构建二叉树
     *
     * @param datas
     */
    public void buildTree(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            insert(datas[i]);
        }
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder() {
        this.preOrder(root);
    }

    /**
     * 想要用递归的方式来实现二叉排序树的插入
     *
     * @param data
     */
    public Node insertBinaryTree(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else {
            Node cur;
            if (node.data >= data) {
                cur = insertBinaryTree(node.left, data);
                node.left = cur;
            } else {
                cur = insertBinaryTree(node.right, data);
                node.right = cur;
            }
        }
        return node;
    }

}

