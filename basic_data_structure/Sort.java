/**
 * @Classname Sort
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class Sort {
    public int[] naiveSort(int[] list ){
        int length = list.length;
        if (length==0) return null;
        int i = 0;
        while (i < length){
            int j = i;
            int min = list[j];
            int minPosition = j;
            while (j < length){
                if (list[j] < min){
                    min = list[j];
                    minPosition = j;
                }
                j++;
            }
            int tmp = list[i];
            list[i] = min;
            list[minPosition] = tmp;
            i++;
        }
        return list;
    }

    public int[] insertSort(int[] list){
        if (list.length==0 || list==null) return null;
        int length = list.length;
        int i = 1;
        int tmp = 0;
        while (i < length){
            int j = i;
            while (j>0){
                if (list[j]<list[j-1]){
                    tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
                j--;
            }
            i++;
        }
        return list;
    }

    public int[] bubbleSort(int[] list){
        int length = list.length;
        int i = length;
        int tmp = 0;
        while (i >1){
            int j = 1;
            while (j<i){
                if (list[j] < list[j-1]){
                    tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
                j++;
            }
            i--;
        }
        return list;
    }

    public void mergeSort(int[] list){
        int length = list.length;
        int[] tmp = new int[length];
        MsortPart(list, 0, length-1, tmp);
    }

    public void MsortPart(int[] list, int left, int right, int[] tmp){
        if (left< right){
            int mid = (left+right)/2;
            MsortPart(list,left,mid,tmp);//左边归并排序，使得左子序列有序
            MsortPart(list,mid+1,right,tmp);//右边归并排序，使得右子序列有序
            merge(list,left,mid,right,tmp);//将两个有序子数组合并操作
        }
    }

    public void merge (int[] list, int left, int mid, int right, int[] tmp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i <= mid && j <= right){
            if (list[i] <= list[j]){
                tmp[t++] = list[i++];
            }else {
                tmp[t++] = list[j++];
            }
        }
        while (i <= mid){
            tmp[t++] = list[i++];
        }
        while (j <= right){
            tmp[t++] = list[j++];
        }
        t = 0;
        while (left <= right){
            list[left++] = tmp[t++];
        }
    }

    public void quickSort(int[] list){
        QsortPart(list, 0, list.length-1);
    }

    public void QsortPart(int[] list, int low, int high){
        int i,j;
        int index;
        if (low> high) return;
        i = low;
        j = high;
        index = list[i];
        while (i<j){
            while (i<j && index<=list[j])
                j--;
            if (i < j){
                list[i++] = list[j];
            }
            while (i<j && index>list[i]){
                i++;
            }
            if (i<j){
                list[j--] = list[i];
            }
        }
        list[i] = index;
        QsortPart(list,low,i-1);
        QsortPart(list,i+1,high);
    }

    public void shellSort(int[] list){
        int number = list.length/2;
        int i;
        int j;
        int tmp;
        while (number>= 1){
            for (i = number; i <list.length ; i++) {
                tmp = list[i];
                j = i - number;
                while (j>= 0 && list[j]<tmp){
                    list[j+number] = list[j];
                    j = j-number;
                }
                list[j+number] = tmp;
            }
            number = number/2;
        }
    }

    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void HeapSort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    public void printList(int[] list){
        for (int i = 0; i < list.length ; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        Sort sortMachine = new Sort();
        int[] testList = {1,2,3,4,5,6,7,8,9};
        //sortMachine.naiveSort(testList);
        //sortMachine.insertSort(testList);
        //sortMachine.bubbleSort(testList);
        //sortMachine.mergeSort(testList);
        //sortMachine.quickSort(testList);
        sortMachine.shellSort(testList);
        sortMachine.printList(testList);
    }

}
