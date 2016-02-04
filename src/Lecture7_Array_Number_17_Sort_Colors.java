
public class Lecture7_Array_Number_17_Sort_Colors {
	/************************************************************************
	 * rainbow sort
	 * 
	 ************************************************************************/
	
	public void sortColors(int[] a) {
        if(a == null || a.length <= 1)
            return;
        
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while(i <= pr){
            if(a[i] == 0){
                swap(a, pl, i);
                pl++;
                i++;
            }else if(a[i] == 1){
                i++;
            }else{
                swap(a, pr, i);
                pr--;
            }
        }
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
	
	
    
	/************************************************************************
	 * using quickSort
	 * 
	 ************************************************************************/
	
	public void sortColors2(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    
    public void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int i = left, j = right;
        double pivot = (nums[left] + nums[right]) / 2.0;
        while(i < j){
            while(i < right && nums[i] < pivot){
                i++;
            }
            while(j > left && nums[j] >= pivot){
                j--;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j]; 
                nums[j] = temp;
            }
        }
        if(j > left){
            quickSort(nums, left, j);
        }
        if(j + 1 < right){
            quickSort(nums, j + 1, right);
        }
    }
}
