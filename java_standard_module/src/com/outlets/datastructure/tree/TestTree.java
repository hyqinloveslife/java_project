/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestTree
 * Author:   hyqin
 * Date:     2019-04-22 16:38
 * Description: 二叉树的测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.tree;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二叉树的测试类〉
 *
 * @author hyqin
 * @create 2019-04-22
 * @since 1.0.0
 */
public class TestTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.setValue(1);
        tree.setrChild(new BinaryTree(2));
        tree.setlChild(new BinaryTree(3));
        tree.getlChild().setlChild(new BinaryTree(4));
        tree.getlChild().setrChild(new BinaryTree(5));
        tree.getrChild().setlChild(new BinaryTree(6));
        tree.getrChild().setrChild(new BinaryTree(7));

        System.out.print("先序遍历");
        tree.prePrint(tree);

        System.out.print("中序遍历");
        tree.inPrint(tree);

        System.out.print("后序遍历");
        tree.behindPrnt(tree);

    }
}
