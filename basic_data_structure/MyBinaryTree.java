
import	java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname BinaryTreeTraverse
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MyBinaryTree<T> {
    static class Node<T>{
        T   data;
        Node<T> lNode;
        Node<T> rNode;

        public Node(T data){
            this.data = data;
        }

        public Node(Node<T> lNode,Node<T> rNode,T data) {
            this.lNode=lNode;
            this.rNode=rNode;
            this.data=data;
        }

    }

    private Node<T> root;

    public MyBinaryTree(T data){
        this.root = new Node<T> (data);
    }

    public Node<T> addNode(Node<T> parent, T data, boolean isLeft){
        if (parent == null){
            throw new IllegalArgumentException("父节点为空,你添加个锤子");
        }
        if (isLeft && parent.lNode!=null)
            throw new RuntimeException("左子节点已经存在，添加失败");
        if(!isLeft && parent.rNode!=null)
            throw new RuntimeException("右子节点已经存在，添加失败");
        Node<T> node = new Node<T> (data);
        if(isLeft) {
            parent.lNode=node;
        }else {
            parent.rNode=node;
        }
        return node;
    }

    //traverse!!!
    //非递归
    public ArrayList<Node<T>> preorderTraverse(Node<T> node){
        ArrayList<Node<T> > nodeList = new ArrayList<Node<T> > ();
        Stack<Node<T>> stack = new Stack<Node<T> > ();
        while (node!=null || !stack.isEmpty()){
            if (node != null){
                nodeList.add(node);
                if (node.lNode != null){
                    stack.push(node);
                }
                node = node.lNode;
            }else {
                node = stack.pop().rNode;
                nodeList.add(node);
                node = node.lNode;
            }

        }
        return nodeList;
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer> (1);
        tree.root.lNode = new Node<Integer> (2);
        tree.root.rNode = new Node<Integer> (3);
        tree.root.lNode.lNode = new Node<Integer> (4);
        tree.root.lNode.rNode = new Node<Integer> (5);
        ArrayList<Node<Integer>> nodelist = tree.preorderTraverse(tree.root);

        Node[] node = new Node[10];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 10; i++)
        {
            node[i] = new Node(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10)
                node[i].lNode = node[i*2+1];
            if(i*2+2 < 10)
                node[i].rNode = node[i*2+2];
        }
        ArrayList<Node<Integer>> nodelist2 = tree.preorderTraverse(node[0]);
        System.out.println("finish");
    }



}
