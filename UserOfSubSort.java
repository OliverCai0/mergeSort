import java.util.ArrayList;

public class UserOfSubSort{
    
    public static void main(String[] commandLine){
        ArrayList<String> data = new ArrayList<String>();
        for(String element : "B,A,C,D,H,Z,X,C,B,A,C,D,H,Z,X,C".split(",")){
            data.add(element);
        }
        System.out.println(data);
        SubSortThenMerge_Sorter list = new SubSortThenMerge_Sorter(data);
        list.subSort();
        System.out.println(list);
    }
}
