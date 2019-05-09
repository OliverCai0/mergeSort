/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
        System.out.println(nItems);
        ArrayList<String> list0 = new ArrayList<String>();
        for(int index = start0; index < start1; index ++){
          list0.add(usersData.get(index));
          //System.out.println(list0.size());
        }
        ArrayList<String> list1 = new ArrayList<String>();
        for(int index = start1; index < nItems; index ++){
          list1.add(usersData.get(index));
          //System.out.println(list1.size());
        }
        ArrayList<String> sortedList = new ArrayList<String>(usersData.size());
        for(int index = 0; index < start0; index ++){
          sortedList.add(index, usersData.get(index));
          //System.out.println(sortedList.size());
        }

        while(list0.size() > 0 || list1.size() > 0){
          System.out.println(sortedList);
          //System.out.println(list0);
          //System.out.println(list1);
          if(list0.size() == 0){
            for(String element : list1){
              sortedList.add(element);
            }
            list1.clear();
          }
          if(list1.size() == 0){
            for(String element : list0){
              sortedList.add(element);
            }
            list0.clear();
          }
          else{
            if(list0.get(0).compareTo(list1.get(0)) > 0){
            sortedList.add(list1.get(0));
           // System.out.println(list1);
            list1.remove(0);
          }
          else{
            sortedList.add(list0.get(0));
          //  System.out.println(list0);
            list0.remove(0);
          }
        }
        }
        System.out.println(nItems);
        for(int index = nItems; index < usersData.size(); index ++){
          //System.out.println("triggered");
          sortedList.add(usersData.get(index));
        }

        usersData = sortedList;
        }
        


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           ){
            System.out.println("Comparing " + usersData.get(i) + " to " + usersData.get(i+1));
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
           }
        return true;
}
}