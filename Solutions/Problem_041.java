/*

This problem was asked by Facebook.

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, 
and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. 
If there are multiple possible itineraries, return the lexicographically smallest one. 
All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] 
and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', 
you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a 
valid itinerary. However, the first one is lexicographically smaller.
*/

/*
SOLUTION:
simple ididea is to siply store every flight from as key and to as its value in hashmap and keep iterating until 
there is no further flight
TIME COMPLEXITY:O(N) where N are the number of flights taken
SPACE COMPLEXITY:O(N)
*/

//CURRENTLY OUTPUT IS NOT PRINTED LEXICOGRAPHICALLY
//WE CAN SIMPLY DO IT BY PUTTING ELEMENTS AS VALUE IN HASHMAP IN LEXICOGRAPHIC ORDER

//REASON: BUT IT WILL INCREASE COMPLEXITY TO O(N^2) AS FOR EVERY FLIGHT WE HAVE TO CHECK ALL THE VALUES 
//OF THAT KEY FOR ENTERING WHILE MAINTAINING LEXICOGRPAHIC ORDER.

import java.util.*;
public class Problem_041 {
    public static void main(String[] args) {
        // String[][] list = {{"SFO", "HKO"}, {"YYZ", "SFO"}, {"YUL", "YYZ"}, {"HKO", "ORD"}};
        String[][] list = {{"A", "B"}, {"A", "C"}, {"B", "C"}, {"C", "A"}};
        // String start = "YUL";
        String start = "A";

        HashMap<String,ArrayList<String>> hash = new HashMap<>();
        for(int i=0; i<list.length; i++){
            if(hash.containsKey(list[i][0])){
                ArrayList<String> temp = hash.get( list[i][0]);
                temp.add( list[i][1]);
                hash.put( list[i][0],temp);
            }
            else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add( list[i][1]);
                hash.put( list[i][0], temp);
            }
        }

        System.out.print( start+" ");
        while(true){
            ArrayList<String> temp = hash.get(start);
            if(temp==null || temp.size()==0){
                break;
            }

            String tempString = temp.get(temp.size()-1);

            System.out.print(tempString+" ");

            temp.remove(temp.size()-1);
            start = tempString;
        }
        
    }
}