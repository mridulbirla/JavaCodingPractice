import java.util.*;

public class interviewQuestions{


	public int findMaximum(int arr[],int low, int high){
		if (low==high){
			return arr[low];
		}
		else if ((low+high)==1){
			
			if (arr[low]>arr[high])
				return arr[low];
			else 
				return arr[high];
		}
		else{
			int mid= (low+high)/2;
			if(arr[mid]>arr[mid-1]){
				return findMaximum(arr,mid,high);
			}
			else if(arr[mid]<arr[mid-1]){
				System.out.println("mid with low"+low+(mid-1));
				return findMaximum(arr,low,mid-1);
			}
			else
				return arr[mid];
			
		}

	}
	

	public void findGreatestSubsequence(int arr[]){
		int[] sum=new int[arr.length];
		int[] index=new int[arr.length];
		int max,current_index,global_max=0,global_index=0;
		for(int i=0;i<arr.length;i++){
			index[i]=i;
			sum[i]=arr[i];
		}
		for(int i=0;i<arr.length;i++){
			max=sum[i];
			current_index=i;
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && max < (sum[j]+sum[i])){					
					max=sum[j]+sum[i];
					current_index=j;
				}
			}
			if(current_index!=i){
				index[i]=current_index;
				sum[i]=max;
			}
			//System.out.println(arr[i]+" "+index[i]+" "+sum[i]);
			if(global_max<sum[i]){
				global_max=sum[i];
				global_index=i;
			}
		}
		System.out.println("Global Max is:"+global_max+"\nElements are:--");
		while(true){
			System.out.print(arr[global_index]+",");
			if(index[global_index]==global_index)
				break;
			global_index=index[global_index];
		}
		System.out.println("");
	}

	public void findFirstTriplet(int arr2[]){
		
		int i=0,j,k=1,flag=-100;
		int[] smaller=new int[arr2.length];
		int[] greater=new int[arr2.length];
		smaller[0]=-1;
		greater[greater.length-1]=-1;
		int min=0;
		int max=arr2.length-1;

		for(i=1;i<arr2.length;i++){
			if(arr2[i]<=arr2[min]){
				min=i;
				smaller[i]=-1;
			}
			else
				smaller[i]=min;

		}
		for(i=arr2.length-2;i>=0;i--){
			if(arr2[i]>=arr2[max]){
				max=i;
				greater[i]=-1;
			}
			else
				greater[i]=max;

		}
		for(i=1;i<=arr2.length-2;i++){
			if(smaller[i]!=-1 && greater[i]!=-1){
				System.out.println(arr2[smaller[i]]+", "+arr2[i]+", "+arr2[greater[i]]);
			}
		}



	}	
	
	public static void main(String args[]){

		//int arr[]={1, 30, 40, 50, 60, 70, 23, 20};
		int arr2[]={12, 11, 10, 5, 6, 2, 30};
		int arr3[]={1, 101, 2, 3, 100, 4, 5};
		interviewQuestions q= new interviewQuestions();
		//System.out.println(q.findMaximum(arr,0,arr.length-1));
		//q.findFirstTriplet(arr2);
		q.findGreatestSubsequence(arr3);

	}

}