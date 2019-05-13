import java.util.ArrayList;

public class SubSortThenMerge_Sorter{

    private ArrayList<String> usersData;
    private static Merger merger;

    public SubSortThenMerge_Sorter(ArrayList<String> usersData){
        this.usersData = usersData;
        merger = new Merger(usersData);
        //orderedData = new ArrayList<String>(usersData.size());
    }

    public void subSort(){
        subSort(0,usersData.size() - 1, usersData.size());
        merger.merge(0, usersData.size() - 1, usersData.size());
    }

    private void subSort(int firstList, int secondList, int end){
        if(firstList == secondList){
            return;
        }
        else{
            subSort(firstList, (firstList + secondList) / 2, (firstList + secondList) / 2 + 1);
            merger.merge(firstList, (firstList + secondList) / 2, (firstList + secondList) / 2 + 1);
            subSort((firstList + secondList) / 2 + 1, secondList, secondList + 1);
            merger.merge((firstList + secondList) / 2 + 1, secondList, secondList + 1);
            merger.merge(firstList, (firstList + secondList) / 2 + 1, end);
        }
    }

    /*private void subSort(int firstIndex, int secondIndex, int items){
        if(secondIndex == firstIndex){
        }
        else{
            
            subSort( firstIndex, secondIndex / 2, items/2);
            merger.merge(firstIndex, secondIndex/2, items/2);
            System.out.println(usersData);
            subSort(items - secondIndex / 2, secondIndex + items/2, items/2);
            merger.merge(items - secondIndex / 2 + 1, secondIndex + items/2, items/2);
            System.out.println(usersData);
        }
    }
    */
    public String toString() {
        return "" + usersData; 
    }

}