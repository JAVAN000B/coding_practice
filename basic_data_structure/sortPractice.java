/**
 * @Classname sortPractice
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class sortPractice {
    public sortPractice(){}

    //本质是挖坑填坑，在这样的一个过程中交换左右两边的数字
    public void quickSort(int[] data){
        qsCore(data,0,data.length-1);
    }

    public void qsCore(int[] data, int top, int end){
        if (top>=end) return;
        int i = top;
        int j = end;
        int target = data[top];
        int targetId = top;
        while (i<=end){
            if (j==i){
                data[j] = target;
                qsCore(data,top,j-1);
                qsCore(data, i+1, end);
                break;
            };
            while (j>i){
                if(data[j]<target){
                    data[targetId] = data[j];
                    targetId = j;
                    break;
                }
                j--;
            }
            while (j>i){
                if (data[i]>target){
                    data[targetId] = data[i];
                    targetId = i;
                    break;
                }
                i++;
            }
        }
    }

    public void mergeSort(int[] data){
        int[] tmp;
        separatePart(data,0,data.length-1,tmp = new int[data.length]);
    }

    public void separatePart(int[] data, int left, int right, int[] tmp){
        if (right<=left) return;
        int mid = (right+left)/2;
        separatePart(data,left,mid,tmp);//左边归并排序，使得左子序列有序
        separatePart(data,mid+1,right,tmp);//右边归并排序，使得右子序列有序
        mergePart(data,left,mid,right,tmp);//将两个有序子数组合并操作
    }

    public void mergePart(int[] data,int left,int mid , int right, int[] tmp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(data[i]<=data[j]){
                tmp[t++] = data[i++];
            }else {
                tmp[t++] = data[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进tmp中
            tmp[t++] = data[i++];
        }
        while(j<=right){//将右序列剩余元素填充进tmp中
            tmp[t++] = data[j++];
        }
        t = 0;
        //将tmp中的元素全部拷贝到原数组中
        while(left <= right){
            data[left++] = tmp[t++];
        }
    }

    public void my_mergeSort(int[] data){
        int[] tmp;
        my_separatePart(data,0, data.length-1,tmp = new int[data.length]);
    }

    public void my_separatePart(int[] data, int left, int right, int[] tmp){
        if (right<=left) return;
        int mid = (left+right)/2;
        my_separatePart(data, left, mid, tmp);
        my_separatePart(data, mid+1, right, tmp);
        my_mergePart(data, left, right, mid, tmp);
    }

    public void my_mergePart(int[] data, int left, int right, int mid, int[] tmp){
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i<=mid&&j<=right){
            if(data[i]<=data[j]){
                tmp[k++] = data[i++];
            }else {
                tmp[k++] = data[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进tmp中
            tmp[k++] = data[i++];
        }
        while(j<=right){//将右序列剩余元素填充进tmp中
            tmp[k++] = data[j++];
        }
        k = 0;
        //将tmp中的元素全部拷贝到原数组中
        while(left <= right){
            data[left++] = tmp[k++];
        }
    }



    public static void main(String[] args) {
        int[] list = {3,5,6,7,1,2};
        sortPractice sortTest = new sortPractice();
        sortTest.quickSort(list);
        System.out.println("finish");
    }

}
