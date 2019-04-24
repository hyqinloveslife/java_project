/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TreeUtils
 * Author:   hyqin
 * Date:     2019-04-22 16:47
 * Description: 树的工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.tree;

/**
 * 〈一句话功能简述〉<br> 
 * 〈树的工具类〉
 *  用内部内的方法去实现二叉树
 *
 * @author hyqin
 * @create 2019-04-22
 * @since 1.0.0
 */
public class TreeUtils {
    class BTree<T>{
        private T value;

        //定义二叉树的左子树节点
        private BTree<T> lChild;
        //定义二叉树的右子树节点
        private BTree<T> rChild;

        public BTree(){}

        public BTree(T value){
            this.value = value;
        }

    }

    public static int depth(BTree tree){
        if (tree==null){
            return 0;
        }else {
            if (depth(tree.lChild)>depth(tree.rChild)){
                return depth(tree.lChild)+1;
            }else {
                return depth(tree.rChild)+1;
            }
        }
    }

    /**
     * 前序打印二叉树节点的值
     * @param tree
     */
    public static void prePrint(BTree tree){
        if (tree!=null){
            System.out.println(tree.value+"     ");
            prePrint(tree.lChild);
            prePrint(tree.rChild);
        }

    }

    /**
     * 创建一颗二叉树
     */
    public static void createTree(BTree bTree, int [] nums){
        int [] newArray = nums;
        if (nums.length>0){

        }
    }

}
