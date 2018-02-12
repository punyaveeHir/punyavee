/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author Promptnow
 */
public class Poker extends Rules {

    /**
     * @param args the command line arguments
     */
 //  HashMap signRule=new HashMap();  
  
    
    public static void main(String[] args) {
        // TODO code application logic here
       // Poker p=new Poker(); 
        Compare c=new Compare();
        String PlayerA="",PlayerB="",result="",highCardA,highCardB;
        int rankA,rankB;
       Scanner sc=new Scanner(System.in);
       String A=sc.next();
       String B=sc.next();
       
        // <editor-fold defaultstate="collapsed" desc="PlayerA">
       PlayerA=c.royalStraightFlush(A);
       if(!PlayerA.contains("Royal straight flush")){
            PlayerA=c.straightFlush(A);
            if(!PlayerA.contains("Straight flush")){
                PlayerA=c.pairOrThreeOfKindsOrFourth(A);
                if(!PlayerA.contains("Fourth")){
                    PlayerA=c.fullHouse(A);
                    if(!PlayerA.contains("Full house")){
                        PlayerA=c.flush(A);
                        if(!PlayerA.contains("Flush")){
                            PlayerA=c.straight(A);
                            if(!PlayerA.contains("Straight")){
                                PlayerA=c.pairOrThreeOfKindsOrFourth(A);
                                if(!PlayerA.contains("Three of kinds")){
                                    PlayerA=c.twoPair(A);
                                    if(!PlayerA.contains("Two pairs")){
                                        PlayerA=c.pairOrThreeOfKindsOrFourth(A);
                                    }
                                    if(PlayerA.equals("")){
                                        PlayerA="High card";
                                    }
                                }
                            }
                        }
                    }
                }
            }
       }
       // </editor-fold>
       
        // <editor-fold defaultstate="collapsed" desc="PlayerB">
       PlayerB=c.royalStraightFlush(B);
       if(!PlayerB.contains("Royal straight flush")){
            PlayerB=c.straightFlush(B);
            if(!PlayerB.contains("Straight flush")){
                PlayerB=c.pairOrThreeOfKindsOrFourth(B);
                if(!PlayerB.contains("Fourth")){
                    PlayerB=c.fullHouse(B);
                    if(!PlayerB.contains("Full house")){
                        PlayerB=c.flush(B);
                        if(!PlayerB.contains("Flush")){
                            PlayerB=c.straight(B);
                            if(!PlayerB.contains("Straight")){
                                PlayerB=c.pairOrThreeOfKindsOrFourth(B);
                                if(!PlayerB.contains("Three of kinds")){
                                    PlayerB=c.twoPair(B);
                                    if(!PlayerB.contains("Two pairs")){
                                        PlayerB=c.pairOrThreeOfKindsOrFourth(B);
                                    }
                                    if(PlayerB.equals("")){
                                        PlayerB="High card";
                                    }
                                }
                            }
                        }
                    }
                }
            }
       }
       // </editor-fold>
       String[] bufferStrA,bufferStrB;
       bufferStrA=PlayerA.split(",");
       bufferStrB=PlayerB.split(",");
       rankA=RULES.get(bufferStrA[0]);
       rankB=RULES.get(bufferStrB[0]);
       if(rankA>rankB){
        result="Player A win!";
       }
       else if(rankB>rankA){
       result="Player B win!";
       }
       else {
           //String cardPoint,suitPoint;
           String[] handA,handB;
           switch(rankA){
               case 10 :       
               
               case 5 : 
               case 9 : highCardA=c.findHighCard(A);
                        highCardB=c.findHighCard(B); 
                        handA=highCardA.split(",");
                        handB=highCardB.split(",");
                        if(Integer.parseInt(handA[0])>Integer.parseInt(handB[0])){
                            result="Player A win!";
                        }else if(Integer.parseInt(handA[0])<Integer.parseInt(handB[0])) result="Player B win!";
                        
                        else {
                             if(Integer.parseInt(handA[1])>Integer.parseInt(handB[1]))
                            result="Player A win!";
                             else if(Integer.parseInt(handA[1])<Integer.parseInt(handB[1])) result="Player B win!";
                             else result="Draw!";
                        }
                        break;
               case 3 : result=c.compareTwoPairs(PlayerA, PlayerB);
                        break;
               case 7 : result=c.compareFullHouse(PlayerA, PlayerB, A, B);
                        break;
               case 8 : 
               case 4 :
               case 2 : result= c.compare(PlayerA, PlayerB);
                        break;

               default :
                        result=c.compareHighCard(A,B);
                        break;
           
           }
       
       }
       
       
        System.out.println(result);
   
        
    }

    
    
     
     
}
