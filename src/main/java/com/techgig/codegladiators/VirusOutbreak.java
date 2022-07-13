package com.techgig.codegladiators;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/*
coronavirus
1
crnas

coronavirus
1
onarous


coronavirus
3
abcde
crnas
onarous



coronavirus
10
abcde
crnas
onarous
vius
onai
s
c
u
cornas
1
 */
public class VirusOutbreak {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String virusComposition = sc.nextLine().trim();
       // char[] virusCompositionArray = virusComposition.toCharArray();
        int numberOfPerson = Integer.parseInt(sc.nextLine().trim());
        String[] bloodCompositions = new String[numberOfPerson];

        for(int i=0;i<numberOfPerson;i++){
            bloodCompositions[i] = sc.nextLine().trim();
        }
        /*Arrays.asList(bloodComposition).stream().forEach( b-> {
            //Blood composition stream
            AtomicInteger pos = new AtomicInteger();
            Arrays.asList(b.toCharArray()).stream()
                    //blood composition string stream
                    .forEach(bChar ->{
                                boolean match = Arrays.asList(virusComposition.substring(pos.get(), virusComposition.length()-1)).stream()
                                        //Virus composition string stream
                                        .anyMatch(v -> bChar.equals(v));
                                if(match){
                                }
                            });

        });*/
        AtomicBoolean match = new AtomicBoolean(false);
        Arrays.asList(bloodCompositions).stream().forEach( bloodComposition-> {
            int pos = 0;
            for(char bChar: bloodComposition.toCharArray()){
                match.set(false);
                char[] virusCompositionArray = virusComposition.substring(pos, virusComposition.length()).toCharArray();
                for(char virusChar:virusCompositionArray){
                    if(virusChar == bChar){
                        match.set(true);
                        pos ++;
                        break;
                    }
                    pos ++;
                }
                if(!match.get()){ break;}
            }
            if(match.get()){ System.out.println("POSITIVE");}
            if(!match.get()){ System.out.println("NEGATIVE");}
        });



    }
}
