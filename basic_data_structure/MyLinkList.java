import java.util.Hashtable;

/**
 * @Classname MyLinkList
 * @Description TODO
 * @Author Minghui Sun
 * @Version 1.0
 */
public class MyLinkList<T> {

    private static class Node<T>{
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

    }

    private int linkSize;
    private Node<T> beginner;

    public MyLinkList() {
        doclear();
    }

    public void doclear(){
        beginner = new Node<T>(null,null);
        linkSize = 0;

    }

    public void clear(){
        doclear();
    }

    public int getLinkSize(){
        return linkSize;
    }

    public boolean isempty(){
        return getLinkSize() == 0;
    }

    public Node<T> getNode(int idx){
        if (idx < 0 || idx>linkSize){
            throw new IndexOutOfBoundsException();
        }
        Node<T> first = beginner;
        int i = 0;
        while (i< idx){
            first = first.next;
            i++;
        }
        return first;
    }

    public T getData(Node<T> target){
        return target.data;
    }

    public void add(T insertData){
        Node<T> target = getNode(linkSize);
        addNode(target, insertData);
    }

    public void add(int idx,T insertData){
        Node<T> target = getNode(idx);
        addNode(target, insertData);
    }

    public void addNode(Node<T> previous, T insertData){
        Node<T> after = previous.next;
        Node<T> insert = new Node<>(insertData,after);
        previous.next = insert;
        linkSize++;
    }

    public T change(int idx, T new_value){
        Node<T> target = getNode(idx);
        return  changeNodeData(target, new_value);
    }

    public T changeNodeData(Node<T> target, T new_value){
        T old_value = target.data;
        target.data = new_value;
        return old_value;
    }

    public void delete(int idx){
        if (idx<0|| idx>linkSize){
            throw new IndexOutOfBoundsException();
        }
        Node<T> previous = getNode(idx-1);
        Node<T> target = getNode(idx);
        deleteNode(previous,target);
    }

    public void deleteNode(Node<T> previous, Node<T> target){
        previous.next = target.next;
        linkSize--;
    }

    public void deleteNode(Node<T> target){
        if (target.next != null){
            target.data = target.next.data;
            target.next = target.next.next;
        }
        linkSize--;
    }

    public void orderList(){
        Node<T> CurNode = beginner.next;
        Node<T> NextNode = null;
        T tmp;
        while (CurNode.next!= null){
            NextNode = CurNode.next;
            while (NextNode!=null){
                if ((int)CurNode.data > (int)NextNode.data){
                    tmp = CurNode.data;
                    CurNode.data = NextNode.data;
                    NextNode.data = tmp;
                }
                NextNode = NextNode.next;
            }
            CurNode = CurNode.next;
        }
    }

    public void deleteDuplicateSpace(){
        Hashtable<T, Integer> table = new Hashtable<T, Integer>();
        Node<T> before = beginner;
        Node<T> position = beginner.next;
        while (position.next != null){
            if (!table.containsKey(position.data)){
                table.put(position.data, 1);
            }else {
                before.next = position.next;
                position = before;
                linkSize--;
            }
            before = position;
            position = position.next;
        }
    }

    public void deleteDuplicateTime(){
        Node<T> cur = beginner;
        while (cur !=null){
            Node<T> after = cur;
            while (after.next !=null){
                if (cur.data == after.next.data){
                    after.next = after.next.next;
                    linkSize--;
                }else {
                    after = after.next;
                }
            }
            cur = cur.next;
        }
    }

    public Node<T> findLastKth(int k){
        Node<T> right = beginner.next;
        Node<T> left = beginner;
        int i = 1;
        while (right != null){
            i++;
            if (i > k){
                left = left.next;
            }
            right = right.next;
        }
        return left;
    }

    public void printList(){
        Node<T> tmp = beginner;
        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public void printReverse(Node<T> beginner){
        Node<T> cur = beginner;
        if (cur.next != null){
            printReverse(cur.next);
        }
        System.out.println(cur.data);
    }

    public Node<T> reverseList(Node<T> head){
        Node<T> pre = null;
        Node<T> next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public Node<T> iteratorReverse(Node<T> head){
        if (head.next == null){
            return head;
        }
        Node<T> rehead = iteratorReverse(head.next);
        head.next.next = head;
        head.next =null;
        return rehead;
    }

    public void reverseNocopy(){
        Node<T> cur = beginner.next;
        Node<T> pre = null;
        Node<T> next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        beginner.next = pre;
    }

    public Node<T> findMiddle(Node<T> start){
        Node<T> pointer1 = start;
        Node<T> pointer2 = start;
        while (pointer1.next!= null){
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
        }
        return pointer2;
    }

    public Node<T> findLoopPort(Node<T> head){
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public boolean checkCircle(Node<T> start){
        Node<T> pointer1 = start;
        Node<T> pointer2 = start;
        while (pointer1.next!= null){
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
            if (pointer1 == pointer2){
                return true;
            }
        }
        return false;
    }

    public boolean checkIntersect(Node<T> head1, Node<T> head2){
        Node<T> cur1 = head1;
        Node<T> cur2 = head2;
        while (cur1.next!= null){
            cur1 = cur1.next;
        }
        while (cur2.next!= null){
            cur2 = cur2.next;
        }
        if (cur1 == cur2) return true;
        return false;
    }

    public Node<T> getFirstIntersectNode(Node<T> head1, Node<T> head2){
        Node<T> cur1 = head1;
        Node<T> cur2 = head2;
        int len1 = 1;
        int len2 = 1;
        while (cur1.next!= null){
            cur1 = cur1.next;
            len1++;
        }
        while (cur2.next!= null){
            cur2 = cur2.next;
            len2++;
        }
        if (cur1 == cur2) return null;
        cur1 = head1;
        cur2 = head2;
        if (len1> len2){
            int d = len1 -len2;
            while (d!= 0){
                cur1 = cur1.next;
                d--;
            }
        }else {
            int d = len2 -len1;
            while (d!= 0){
                cur2 = cur2.next;
                d--;
            }
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static void main(String[] args){
        MyLinkList list = new MyLinkList();
        list.add(5);
        list.delete(1);
        list.add(10);
        list.add(10);
        list.add(5);
        list.change(1,100);
        list.add(70);
        list.add(10);
        list.add(10);
        list.add(70);
        list.orderList();
        list.deleteDuplicateTime();
        list.deleteDuplicateSpace();
        list.printList();
        System.out.println("===[]================>");
        list.reverseNocopy();
        list.printList();
        System.out.println("===[]================>");
        //list.iteratorReverse(list.beginner);
        //Node r = list.iteratorReverse(list.beginner);
        Node middle = list.findMiddle(list.beginner);
        list.printReverse(list.beginner);

    }




}

