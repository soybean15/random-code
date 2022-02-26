
import java.util.*;

class JejeConverter {
    Scanner sc = new Scanner(System.in);
    HashMap<Character, String[]> jejeMessage = new HashMap<>();
    List<Character> alphabet = new ArrayList<>();

    void createAlphabet(){
        int count = 0;
        for(char c='a'; c <='z'; c++){
            alphabet.add(c) ;
        }

    }

    void addJejeMessage(){
        jejeMessage.put('a', new String[]{"4","Ah","aH","4h","4H","a","A"});
        jejeMessage.put('b', new String[]{"bH","Bv","bV","vH","b","B"});
        jejeMessage.put('c', new String[]{"cH","cK","Kc","c","C"});
        jejeMessage.put('d', new String[]{"dH","Dh"});
        jejeMessage.put('e', new String[]{"eI","e","E","3"});
        jejeMessage.put('f', new String[]{"Fh","fH","f","F","pH"});
        jejeMessage.put('g', new String[]{"6","g","G","gH","Gh"});
        jejeMessage.put('h', new String[]{"h","H"});
        jejeMessage.put('i', new String[]{"1","i","I"});
        jejeMessage.put('j', new String[]{"j","J","jH","Jh"});
        jejeMessage.put('k', new String[]{"k","K","cK","Kc","cK","kH"});
        jejeMessage.put('l', new String[]{"1","l","L","I"});
        jejeMessage.put('m', new String[]{"m","M","mH","mH"});
        jejeMessage.put('n', new String[]{"n","N","nH","Nh"});
        jejeMessage.put('o', new String[]{"0","o","O"});
        jejeMessage.put('p', new String[]{"p","P","Fh","f","F","pH"});
        jejeMessage.put('q', new String[]{"q","Q","Qu","qU"});
        jejeMessage.put('r', new String[]{"r","R","rH","Rh"});
        jejeMessage.put('s', new String[]{"s","S","Sz","zS","Sx"});
        jejeMessage.put('t', new String[]{"t","T","7","tH","Th"});
        jejeMessage.put('u', new String[]{"u","U"});
        jejeMessage.put('v', new String[]{"v","V","Vb","vB"});
        jejeMessage.put('w', new String[]{"w","Wh"});
        jejeMessage.put('x', new String[]{"x","X","xS","Xs","Xx"});
        jejeMessage.put('y', new String[]{"y","Y","yH","Yh"});
        jejeMessage.put('z', new String[]{"z","Z","Zx","Zs","Zz"});
    }

    char[] splitMessage(String msg){
        return msg.toCharArray();
  }

    String convertToJeje(char[] msgs){
        StringBuilder message = new StringBuilder();

       for(char c: msgs){
           char ch = Character.toLowerCase(c);
           if(alphabet.contains(ch)){

               int size = jejeMessage.get(Character.toLowerCase(ch)).length;
               message.append(jejeMessage.get(Character.toLowerCase(ch))[new Random().nextInt(size)]);
           }else {
               message.append(c);
           }



       }
       return message.toString();
    }

    String input(String prompt){
        System.out.print(prompt);
        return sc.nextLine();
    }
    void start(){
        createAlphabet();
        addJejeMessage();
        String message = input("Message: ");
        System.out.println("C0nV3rT3d tO j3j3: "+convertToJeje(splitMessage(message)));
    }
}




public class Main {

    public static void main(String[] args) {
	JejeConverter jeje = new JejeConverter();

    while (true)
    jeje.start();

   }
}

