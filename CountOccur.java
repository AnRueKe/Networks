/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countoccur;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * zählt, wie oft die Person im Buch in jedem Kapitel erwähnt wird
 */
public class CountOccur {
    public CountOccur(Filter chars, String filename){
    //stub
    }
    public CountOccur(Filter chars, String novel){
        try{
            //input of the novel
         BufferedReader read = new BufferedReader(new FileReader(new File(novel)));
         String line;
         ArrayList nnps = chars.getNNPS();
         Map<String, Integer> counter = new HashMap<String, Integer>();
         for(int i = 0; i < nnps.size(); i++){ //go through list of characters
             String[] lemma = (String[]) nnps.get(i); //lemma from filtered nnps
             for(Entity entity : lemma){ //put lemmas into the hashmap
                 counter.put(Entity.get(), 0); //initial 0
             }
         while(read.readLine()!=null){ //reads the novel line by line
             /**
              * if characters from the filtered AND checked list matches those in the novel
              * counter of given character +1
              * next line i++
              */
         }
         }

        }catch (IOException e){
        System.out.println("wrong file");}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
