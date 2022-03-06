import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Scanner;
class CheatCollection{
    private HashMap<String, List<String>> cheatsheet = new HashMap<>();
    
    int answerProbability(String[] str, String key){
        int rating = 0;
        for (String s:str){
            if(cheatsheet.get(key).contains(s)){
                rating+=5;
            }
        }
        return rating;
    }
    
    void add(String key, String value){
        List<String> valueList =Arrays.asList(value.split("[\\s,.?:-]")); 
        
        cheatsheet.put(key, valueList);    
    }

    HashMap<Integer, String> findBestAnswer(String[] desc){
        HashMap<Integer, String> bestAnswer = new HashMap<>();
       
        for(String key :cheatsheet.keySet()){
            int score =answerProbability(desc,key);
            if(score !=0){
                bestAnswer.put(score, key);
            }
            
            
        }
    
        return bestAnswer;
        
    }

   TreeMap<Integer, String> findAnswer(String desc){
        String[] descArr =desc.toLowerCase().split("[\\s,.?:-]"); 
        System.out.println(Arrays.toString(descArr));
        TreeMap<Integer, String> sorted = new TreeMap<>(findBestAnswer(descArr));
        
        
        
        return sorted;
   }

    
}

    
public class CheatSheet{
    CheatCollection cc = new CheatCollection();
        
    void start(String desc){
        TreeMap<Integer, String> result = new TreeMap<>(cc.findAnswer(desc));

        List<String> answers = new ArrayList<>();
        for(int key:result.keySet()){
            answers.add(result.get(key));
        }
        printResult(answers);
        
       
    }
    
    void printResult(List<String> res){
        if(res.size()==0){
            System.out.println("No Result Found"); 
        }else{
            System.out.println("Top "+res.size()+" Result(s)");        
            for(int i = res.size()-1; i>=0; i--){
                System.out.println(res.get(i));
            }
        }
    }
    
     void add(){
        cc.add("Range", "tell us the spread of out data from the lowest to highest value in the distribution");
        cc.add("Inter-Quartile Range", "it gives us the spread of middle of your distribution");
        cc.add("Average","the quotient obtained by dividing the sum total of a set of figures by the numbers of figures");
        cc.add("Percentile","describes the percentage of data values that fall at or below another data value");
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CheatSheet cs = new CheatSheet();     
        cs.add();    
        
        while(true){
             System.out.println("Enter Question:");
             cs.start(scanner.nextLine());
        }
       
        
    }

    

}
