/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BinaryTree
 * Author:   hyqin
 * Date:     2019-04-22 16:27
 * Description: 简单的二叉树实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.tree;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈简单的二叉树实现〉
 *
 * @author hyqin
 * @create 2019-04-22
 * @since 1.0.0
 */
public class BinaryTree<T> implements Tree{
    private T value;

    //定义二叉树的左子树节点
    private BinaryTree<T> lChild;
    //定义二叉树的右子树节点
    private BinaryTree<T> rChild;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getlChild() {
        return lChild;
    }

    public void setlChild(BinaryTree<T> lChild) {
        this.lChild = lChild;
    }

    public BinaryTree<T> getrChild() {
        return rChild;
    }

    public void setrChild(BinaryTree<T> rChild) {
        this.rChild = rChild;
    }

    public BinaryTree(){}

    public BinaryTree(T value){
        this.value = value;
        this.lChild = null;
        this.rChild = null;
    }


    /**
     * 在控制台手动输入的方法来创建二叉树
     * @param nums
     */
    public BinaryTree createBinaryTree(BinaryTree tree, int [] nums,int index){
        if (tree==null){
            tree = new BinaryTree(nums[index-1]);
        }else{
            tree.setValue(nums[index-1]);
        }
        for (int i =index;i<nums.length;i++){
            if (i%2==0){
                tree.setlChild(createBinaryTree(tree.getlChild(),nums,++i));
            }else{
                tree.setrChild(createBinaryTree(tree.getrChild(),nums,++i));
            }
        }
        return tree;
    }

    /**
     * 先序遍历二叉树
     * 顺序：根-左-右
     */
    public void prePrint(BinaryTree<T> tree){
        if (tree!=null){
            System.out.print(tree.getValue()+"  ");
            prePrint(tree.getlChild());
            prePrint(tree.getrChild());
        }
    }

    /**
     * 中序遍历二叉树
     * 顺序：左-根-又
     * @param tree
     */
    public void inPrint(BinaryTree<T> tree){
        if (tree!=null){
            inPrint(tree.getlChild());
            System.out.print(tree.getValue()+"  ");
            inPrint(tree.getrChild());
        }
    }

    public void behindPrnt(BinaryTree<T> tree){
        if (tree!=null){
            behindPrnt(tree.getlChild());
            behindPrnt(tree.getrChild());
            System.out.print(tree.getValue()+"  ");
        }
    }


    /**
     * 求二叉树的深度，虽然这种写法有问题，但是暂时还不知道怎么去改
     * @param tree
     * @return
     */
    /*public int depth(Tree tree) {
        BinaryTree<T> binaryTree = (BinaryTree<T>) tree;
        if (binaryTree==null){
            return 0;
        }else {
            if (depth(binaryTree.lChild)>depth(binaryTree.rChild)){
                return depth(binaryTree.lChild)+1;
            }else{
                return depth(binaryTree.rChild)+1;
            }
        }
    }*/
}
