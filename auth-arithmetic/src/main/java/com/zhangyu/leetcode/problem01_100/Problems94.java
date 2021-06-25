package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/6/25 3:34 下午
 */
@Slf4j
public class Problems94 {

    public static void main(String[] args) {

    }

    /**
     * @description:
     *
     * 栈+循环法
     *
     * @author: zhangyu122
     * @date: 2021/6/25 4:03 下午
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * @description:
     *
     * 递归
     *
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.6 MB,击败了71.58% 的Java用户
     * @author: zhangyu122
     * @date: 2021/6/25 4:03 下午
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root ==null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        TreeNode left = root.left;
        List<Integer> list = inorderTraversal(left);
        result.addAll(list);

        result.add(root.val);

        TreeNode right = root.right;
        List<Integer> list1 = inorderTraversal(right);
        result.addAll(list1);
        return result;
    }

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
