/**
 * zählt, wie oft die Person im Buch in jedem Kapitel erwähnt wird
 */
package countoccur;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountOccur {
    public CountOccur(){
    //stub
    }
    public CountOccur(Filter chars, String novel){
        try{
            //input of the novel
         BufferedReader read = new BufferedReader(new FileReader(new File(novel)));
         String line;
         ArrayList nnps = chars.getNNPS();
         Entity ent=new Entity();
         Map<String, Integer> counter = new HashMap<String, Integer>();
         for(int i = 0; i < nnps.size(); i++){ //go through list of characters
             String[] lemma = (String[]) nnps.get(i); //lemma from filtered nnps
             for(Entity entity : lemma){ //put lemmas into the hashmap
                 counter.put(Entity.get(), 0); //initial 0
             }
         while(read.readLine()!=null){ //reads the novel line by line
             /**
              * if characters from the filtered AND checked list matches those in the novel
              * counter +1
              * next entity i++
              */
             for(int j=0;j<counter.size();j++){ //go through hashmap bzw list of entities
                 if(counter.values().contains(nnps.get(i))){
                     counter.put(Entity.get(),counter.get(chars)+1);
                     j++;
                 }
             }
         }
         }
         /**
          * give results into ouput
          * reset value to 0
          * (next chapter i++)?
          */

        }catch (IOException e){
        System.out.println("wrong file");}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
}
