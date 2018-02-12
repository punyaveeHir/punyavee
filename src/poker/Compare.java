/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static poker.Rules.CARDRULE;

/**
 *
 * @author Promptnow
 */
public class Compare extends Rules {
    public String compare(String A,String B){
        String result="",rankA,rule="",rankB;
        int highCardA,highCardB;
       // int[] pointA,pointB;
        String[] handA,handB,pointA = null,pointB = null;
        
        handA=A.split(",");
        handB=B.split(",");
        rule=handA[0];
        handA=handA[1].split("T"); // 0=rank , 1=highCard A
        handB=handB[1].split("T"); // 0=rank , 1=highCard B
        rankA=handA[0];
        rankB=handB[0];
        //get A
        if(handA[0].contains("10")){
            pointA[0]="10";
            pointA[1]=handA[0].substring(0, 1);
        }
        if(handA[0].contains("10")){
            pointA[0]="10";
            pointA[1]=handA[0].substring(0, 1);
        }
        if(handB[0].contains("10")){
            pointB[0]="10";
            pointB[1]=handB[0].substring(0, 1);
        }
        else{
        pointA=handA[0].split("|");
        pointB=handB[0].split("|");
        }
        
        highCardA=CARDRULE.get(pointA[0])+SUIT.get(pointA[1]);
        //get B
        
        highCardB=CARDRULE.get(pointB[0])+SUIT.get(pointB[1]);
        
        if(highCardA>highCardB){
            result="Player A win!";
        }
        else if(highCardA<highCardB){
            result="Player B win!";
        }
        else{
            
            handA=handA[1].split("#");
            handB=handB[1].split("#");
            int j=0,k=0;
            
            highCardA=0;
            highCardB=0;
            
            if(rule.equals("Three of kinds") || rule.equals("Pairs"))
            { //not fourth
                 int[] handPointA,handPointB;
                   handPointA = new int[handA.length];
                   handPointB = new int[handB.length];
              for(String p : handA){ //get point if A
                 
                 handPointA[j]=getPoint(p);
                 if(handPointA[j]>highCardA){
                     highCardA=handPointA[j];
                 }
                 j++;
              }
              for(String p : handB){ //get point if A
               
                 handPointB[k]=getPoint(p);
                 if(handPointB[k]>highCardA){
                     highCardB=handPointB[k];
                 }
                 k++;
              }
              
              if(highCardA>highCardB){
                    result= "Player A win!";
                }
                else if(highCardA<highCardB){
                    result= "Player B win!";
                }
                else{
                    result= "Draw!";
                }
            }
            else if(rule.equals("Fourth")){ //Fourth
             //get A
                if(handA[0].contains("10")){
                    pointA[0]="10";
                    pointA[1]=handA[0].substring(handA[0].length()-1);
                }
                else{
                    pointA=handA[0].split("|");
                }
                if(handB[0].contains("10")){
                    pointB[0]="10";
                    pointB[1]=handB[0].substring(handB[0].length()-1);
                }
                else{ 
                    pointB=handB[0].split("|");
                }
                highCardA=CARDRULE.get(pointA[0])+SUIT.get(pointA[1]);           
                highCardB=CARDRULE.get(pointB[0])+SUIT.get(pointB[1]);
                }
                if(highCardA>highCardB){
                    result="Player A win!";
                }
                else if(highCardA<highCardB){
                    result="Player B win!";
                }
                else{
                    result="Draw!";
                }
      
        }

    return result;
    }
    
        public String compareTwoPairs(String A,String B){
            String result,highPairA,highPairB,secondPairA,secondPairB,highCardA,highCardB;
            int pointA,pointB;
            String[] handA,handB;
            handA=A.split(",");
            handB=B.split(",");
            
            handA=handA[1].split("T");
            handB=handB[1].split("T");
            highPairA=handA[0];
            highPairB=handB[0];
            
            handA=handA[1].split("#");
            handB=handB[1].split("#");
            secondPairA=handA[0];
            secondPairB=handB[0];
            highCardA=handA[1];
            highCardB=handB[1];
            
            pointA=getPoint(highPairA);
            pointB=getPoint(highPairB);
            if(pointA>pointB){
                result="Player A win!";
            }
            else if(pointB>pointA){
                result="Player B win!";
            }else
            {
                pointA=getPoint(secondPairA);
                pointB=getPoint(secondPairB);
                if(pointA>pointB){
                    result="Player A win!";
                }
                else if(pointB>pointA){
                    result="Player B win!";
                }
                else{
                    pointA=getPoint(highCardA);
                    pointB=getPoint(highCardB);
                    if(pointA>pointB){
                        result="Player A win!";
                    }
                    else if(pointB>pointA){
                        result="Player B win!";
                    }
                    else{
                        result="Draw!";
                    }
                }
            }
            
            return result;
        }
        
        public int getPoint(String str){
            int p,s;
            String[] card;
            card=str.split("|");
            if(str.contains("10")){
             p=10;
            s=SUIT.get(card[2]);
            }else{
            p=CARDRULE.get(card[0]);
            s=SUIT.get(card[1]);
            }
        return p+s;
        }
        
         public int getPointHome(String str){
            int p,s;
            String[] card;
            card=str.split("|");
            if(str.contains("10")){
             p=10;
            s=SUIT.get(card[2]);
            }else{
            p=CARDRULE.get(card[1]);
            s=SUIT.get(card[2]);
            }
        return p+s;
        }
  
    
     public String findHighCard(String str){
        String highCard="",highSuit="";
       // int a=0,b=0;
        String[] cards,point;
         String[] suit;
         int[] sortRank,sortSuit;
       sortRank = new int[5];
       sortSuit=new int[5];
       suit=new String[5];
       point=new String[5];
        cards=str.split(",");
        
         for (int i = 0; i < cards.length; i++) {  
               point[i]= cards[i].substring(0,cards[i].length()-1); 
               suit[i]=cards[i].substring(cards[i].length()-1);
               sortRank[i]=CARDRULE.get(point[i]);
               sortSuit[i]=SUIT.get(suit[i]);
        }   
         Arrays.sort(sortRank); //high point
         Arrays.sort(sortSuit); //high suit
         
         if(!straightFlush(str).isEmpty() || !straight(str).isEmpty()){
             if(sortRank[4]==14 && sortRank[0]==2){
                sortRank[4]=1;
                Arrays.sort(sortRank);
             }     
         }
          highCard=Integer.toString(sortRank[sortRank.length-1]);
         highSuit=Integer.toString(sortSuit[sortSuit.length-1]);

     return highCard+","+highSuit;
    }
     
     
         public String findHighCardReturnByKey(String str){
        String highCard="";
        String[] cards;
         int[] sortRank;
       sortRank = new int[5];
        cards=str.split(",");
        
         for (int i = 0; i < cards.length; i++) {  
               cards[i]= cards[i].substring(0,cards[i].length()-1); 
               sortRank[i]=CARDRULE.get(cards[i]);
        }   
         Arrays.sort(sortRank);
       
    return highCard;
    }
    
    public String royalStraightFlush(String str){
        String rank="",s1,s2,rankS="",rankF="";
     
        String[] cardsForS,cardForF;
        
        int[] sortCard;
       sortCard = new int[5];
       
        cardsForS=str.split(",");
        cardForF=str.split(",");
        // <editor-fold defaultstate="collapsed" desc="Straight">
        
        //get num from string
        for (int i = 0; i < cardsForS.length; i++) {  
            
               cardsForS[i]= cardsForS[i].substring(0,cardsForS[i].length()-1); 
            sortCard[i]=CARDRULE.get(cardsForS[i]);
           // suit[i]=cardsForS[i].substring(cardsForS[i].length()-1);
        }

        Arrays.sort(sortCard);
        //evaluate
        if(sortCard[0]==10 && sortCard[1]==11 && sortCard[2]==12 && sortCard[3]==13 && sortCard[4]==14){
            rankS="Royal Straight";
        }
        // </editor-fold>

         // <editor-fold defaultstate="collapsed" desc="Flush">
           for (int i = 0; i < cardForF.length; i++) {
               cardForF[i]=cardForF[i].substring(cardForF[i].length()-1);
        }    
         for(int j = 0; j < 4; j++){          
             s1=cardForF[j+1];
             s2=cardForF[j];
             if(cardForF[j].equals(s1.charAt(0)+"")){               
                 if(j==3){
                     rankF="Flush";
                 }
             }
             else{
             break;
             }
         }
        // </editor-fold>
        
        if(!rankS.isEmpty() && !rankF.isEmpty()){
            rank="Royal straight flush";
        }
    return rank;
     
   
    }
    
    public String straightFlush(String str){
    String rank="",s1,rankS="",rankF="";
    
        String[] cardsForS,cardForF;
        
        int[] sortCard;
       sortCard = new int[5];
       
        cardsForS=str.split(",");
        cardForF=str.split(",");
        // <editor-fold defaultstate="collapsed" desc="Straight">
        
        //get num from string
        for (int i = 0; i < cardsForS.length; i++) {  
            
               cardsForS[i]= cardsForS[i].substring(0,cardsForS[i].length()-1); 
            sortCard[i]=CARDRULE.get(cardsForS[i]);
           // suit[i]=cardsForS[i].substring(cardsForS[i].length()-1);
        }

        Arrays.sort(sortCard);
        //evaluate
        for(int j=0;j<4;j++){
            if(sortCard[j]<sortCard[j+1]){
                int check=sortCard[j+1]-sortCard[j]; 
                if(check==1){
                    if(j==3){
                        rankS="Straight";
                    }
                }
                else if(sortCard[4]==14 && sortCard[0]==2){
                     if(j==3){
                        rankS="Straight";
                    }
                }
                else{
                break;
                }
            }
        }
        // </editor-fold>

         // <editor-fold defaultstate="collapsed" desc="Flush">
           for (int i = 0; i < cardForF.length; i++) {
               cardForF[i]=cardForF[i].substring(cardForF[i].length()-1);
        }    
         for(int j = 0; j < 4; j++){          
             s1=cardForF[j+1];
             if(cardForF[j].equals(s1.charAt(0)+"")){               
                 if(j==3){
                     rankF="Flush";
                 }
             }
             else{
             break;
             }
         }
        // </editor-fold>
        
        if(!rankS.isEmpty() && !rankF.isEmpty()){
            rank="Straight flush";
        }
    return rank;
    }
    
    public String fullHouse(String str){
        String rank="";
        String[] cards;
        String[] card;
   
        card = new String[5];
        int i=0,j=0;
        Map<String, Integer> charMap = new HashMap<>();
        
        cards=str.split(",");
        
        for (String c: cards) {
           c=c.substring(0,c.length()-1);
           card[i]=c;
           i++;     
        }
        for (String c: card) {
           if (charMap.containsKey(c)) {
               charMap.put(c, charMap.get(c) + 1);

           } else {
               charMap.put(c, 1);
           }  
            
        }
        
 
        
       for (Map.Entry<String, Integer> entry : charMap.entrySet()) {
           //n=จำนวนไพ่ต่อใบ
            if(charMap.entrySet().size()==2){    
                if(entry.getValue()==3){
                    if(rank.isEmpty()){
                        rank=entry.getKey();
                    }
                else{
                    rank=rank+"T"+entry.getKey();
                }
                }
                else if(entry.getValue()==2){
                    if(rank.isEmpty()){
                        rank=entry.getKey();
                    }
                else{
                    rank=rank+"#"+entry.getKey();
                }   
                }
                if(j==1){
                rank="Full house"+","+rank;
                }
                j++;
            }
            else break;
       }
        
        return rank;
    }
    
    public String flush(String str){
        String rank="",s1;
        
        String[] cards;
        cards=str.split(",");
         for (int i = 0; i < cards.length; i++) {
               cards[i]=cards[i].substring(cards[i].length()-1);
        }    
         for(int j = 0; j < 4; j++){          
             s1=cards[j+1];
             if(cards[j].equals(s1.charAt(0)+"")){               
                 if(j==3){
                     rank="Flush";
                 }
             }
             else{
             break;
             }
         }
        return rank;
    }
    
    
    public String straight(String str){
       
        String rank="";
        String[] cards;
        int[] sortCard;
       sortCard = new int[5];
        cards=str.split(",");
        //get num from string
        for (int i = 0; i < cards.length; i++) {
               cards[i]= cards[i].substring(0,cards[i].length()-1);
            sortCard[i]=CARDRULE.get(cards[i]);
        }
     
     
        Arrays.sort(sortCard);
        //evaluate
        for(int j=0;j<4;j++){
            if(sortCard[j]<sortCard[j+1]){
                int check=sortCard[j+1]-sortCard[j]; 
                if(check==1){
                    if(j==3){
                        rank="Straight";
                    }
                }
                else if(sortCard[4]==14 && sortCard[0]==2){
                      if(j==3){
                        rank="Straight";
                    }
                }
                else{
                break;
                }
            }
        }
    
    return rank;
    }
    
    
    
     public String twoPair(String str){
     String rank="",point,highPair1="",highCard="",highPair2="";
     int i=0;
     String[] cards,splitStrHighPair1,splitStrHighPair2;
    // first = new String[3];
     //splitStr=new String[1];
     Map<String, Integer> charMap = new HashMap<>();
     cards=str.split(",");
     
     try{
         for (String c: cards) { 
                 point=c.substring(0, cards[i].length()-1);
                 i++;
                 
           if (charMap.containsKey(point)) {
               charMap.put(point, charMap.get(point) + 1);

           } else {
               charMap.put(point, 1);
           }    
        }
        
        
          ArrayList<String> arr = new ArrayList<>();
          ArrayList<String> first = new ArrayList<>();
          ArrayList<String> second = new ArrayList<>();
         
         int x,y,max1=0,max2=0;
         
      for (Map.Entry<String, Integer> entry : charMap.entrySet()) {
        
        if(entry.getValue()>1){
            arr.add(entry.getKey());
     
        }
        else{
            
            highCard=entry.getKey();
        }

      }
      
    
      
    for(String s:arr){
       for (String c: cards) {
         //if(){}
           if(first.size()<2){
           if(c.contains(s)){
               first.add(c);
           }
           }
           if(second.size()<2){
            second.add(c);
           }
           if(c.contains(highCard)){
               highCard=c;
           }
       }
    }
        for(String s : first){
            x=getPoint(s);
            if(x>max1){
                max1=x;
                highPair1=s;
            }
        }
    for(String s : second){
            x=getPoint(s);
            if(x>max2){
                max2=x;
                highPair2=s;
            }
        }
    
        splitStrHighPair1=highPair1.split("");
        splitStrHighPair2=highPair2.split("");
        
        x=CARDRULE.get(splitStrHighPair1[0]);
        y=CARDRULE.get(splitStrHighPair2[0]);
        String bufferString="";
        if(y>x){
            bufferString=highPair2;
            highPair2=highPair1;
            highPair1=bufferString;
        }
        
      if(charMap.entrySet().size()==3){
      rank="Two pairs"+","+highPair1+"T"+highPair2+"#"+highCard;
      }
      
    return rank;
     }
     catch(Exception ex){
         return "";
     }
    }
     
     public String pairOrThreeOfKindsOrFourth(String str){
       String[] card,pairStr;
      ArrayList<String> highCard = new ArrayList<>();
     // Poker p=new Poker();
       String pair="",rank="",highCardStr="";
       card = str.split(",");
       int i=1,point;
       
       try{
       ////find pair
       for(String c : card){
            //card=c.substring(0, card.length-1);
         while(i < card.length){
            // pair=c.substring(0, card.length-1);
            if(c.charAt(0)==card[i].charAt(0)){
              
               if(pair.isEmpty()){
                    pair=c+","+card[i];
               }
               else{
                    pair=pair+","+card[i];
               }
            }
            
            else{
                highCard.add(card[i]);
                
            }    
         i++;
         }
       }
       
       for(String s:highCard){
           if(highCardStr.isEmpty()){
               highCardStr+=s;
           }else{
               highCardStr+="#"+s;
           }
           
       }

      
       pairStr=pair.split(",");
       String[] highPair;
       String pointOfCard,suit,hc="",hs="";
       int highPoint=0,highSuit=0,x,y;
       
      // if(pairStr.length==1){
       
       for(String p : pairStr){
//           // <editor-fold defaultstate="collapsed" desc="PlayerA">
//           highPair=p.split("|");
//           pointOfCard=highPair[1];
//           suit=highPair[2];
//            // </editor-fold>
           highPair=p.split("|");
           pointOfCard=highPair[0];
           suit=highPair[1];
           x=CARDRULE.get(pointOfCard);
           y=SUIT.get(suit);
          
          // if(pairStr.length==1){
                if(x>highPoint && y>highSuit){
                    highPoint=x;
                    highSuit=y;
                    hc=pointOfCard;
                    hs=suit;
                }
          // }
          
       }
       switch(pairStr.length){
           case 2 : 
             
               rank= "Pairs"+","+hc+hs+"T"+highCardStr;
               break;
           case 3 :
               rank= "Three of kinds"+","+hc+hs+"T"+highCardStr;
               break;
           case 4 :
               rank="Fourth"+","+hc+hs+"T"+highCardStr;
           default: break;
       
       }
       return rank;
       }
       catch(Exception ex){
           return "";
       }
     }
     
     
     public String compareFullHouse(String A,String B,String strA,String strB){
        String[] cardsA,cardsB,handA,handB;
        String result;
        int maxA=0,x,maxB=0,y;
         ArrayList<String> threeOfKindsA = new ArrayList<>();
         ArrayList<String> pairA = new ArrayList<>();
         ArrayList<String> threeOfKindsB = new ArrayList<>();
         ArrayList<String> pairB = new ArrayList<>();
        cardsA=A.split(",");
        cardsB=B.split(",");
        cardsA=cardsA[1].split("#");
        cardsB=cardsB[1].split("#");
        handA=strA.split(",");
        handB=strB.split(",");
        
        for(String s : handA){
            if(s.contains(cardsA[0])){
                 threeOfKindsA.add(s);
            }
             if(s.contains(cardsA[1])){
                 pairA.add(s);
            }
        }
        
        for(String s : handB){
            if(s.contains(cardsB[0])){
                 threeOfKindsB.add(s);
            }
             if(s.contains(cardsB[1])){
                 pairB.add(s);
            }
        }
        
        for(String s : threeOfKindsA){
            x=getPoint(s);
            if(x>maxA){
                maxA=x;
            }
        }
        
        for(String s : threeOfKindsB){
            y=getPoint(s);
            if(y>maxB){
                maxB=y;
            }
        }
        
        if(maxA>maxB){
            result="Player A win!";
        
        }
        else if(maxA<maxB){
            result="Player B win!";
        }
        else{     
            maxA=0;
            maxB=0;
            for(String s : pairA){
                x=getPoint(s);
                if(x>maxA){
                    maxA=x;
                }
            }
            for(String s : pairB){
                y=getPoint(s);
                if(y>maxB){
                    maxB=y;
                }
            }
            if(maxA>maxB){
                result="Player A win!";
        
            }
            else if(maxA<maxB){
                result="Player B win!";
            }
            else{
                result="Draw!";
            }
        
        }
      
        
        return result;
     }
     
//     public String compareFlush(String A,String B){
//         String result="";
//        String[] handA,handB,suitA,suitB;
//        int x,y,i=0;
//        int[] pointA,pointB;
//        pointA = new int[4];
//        pointB = new int[4];
//        handA=A.split(",");
//        handB=B.split(",");
//        
//        for(String s : handA){
//            x=getPoint(s);
//            pointA[i]=x;
//        }
//         for(String s : handB){
//            x=getPoint(s);
//            pointB[i]=x;
//        }
//        
//         Arrays.sort(pointA);
//         Arrays.sort(pointB);
//        
//         for(int j=0;j<5;j++){
//             if(pointA[j]>pointB[j]){
//                 result="Player A win!";
//             }
//             else{
//             result="Player B win!";
//             
//             }
//             if(j==4){
//                 if(pointA[j]>pointB[j]){
//                 result="Player A win!";
//                }
//                 else if(pointA[j]<pointB[j]){
//                 result="Player B win!";
//             
//                }
//                 else{
//                     result="Draw!";
//                 }
//                 
//             
//             }
//         }
//        return result;
//     }
     
     public String compareHighCard(String A,String B){
        String result="";
        String[] handA,handB;
        int x,y,i=0;
        int[] pointA,pointB;
        pointA = new int[5];
        pointB = new int[5];
        handA=A.split(",");
        handB=B.split(",");
        
        for(String s : handA){
            x=getPoint(s);
            pointA[i]=x;
            i++;
        }
        i=0;
         for(String s : handB){
            x=getPoint(s);
            pointB[i]=x;
            i++;
        }
        
         Arrays.sort(pointA);
         Arrays.sort(pointB);
        
         for(int j=0;j<5;j++){
             if(pointA[j]>pointB[j]){
                 result="Player A win!";
                 break;
             }
             else if(pointA[j]<pointB[j]){
             result="Player B win!";
             break;
             
             }
             if(j==4){
                 if(pointA[j]>pointB[j]){
                 result="Player A win!";
                }
                 else if(pointA[j]<pointB[j]){
                 result="Player B win!";
             
                }
                 else{
                     result="Draw!";
                 }
                 
             
             }
         }
        return result;
     }
}
