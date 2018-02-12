/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.HashMap;

/**
 *
 * @author Promptnow
 */
public class Rules {
     protected static final HashMap<String, Integer> SUIT;
    static
    {
        SUIT = new HashMap<String, Integer>();
        SUIT.put("S", 4);
        SUIT.put("H", 3);
        SUIT.put("D", 2);
        SUIT.put("C", 1);
    }
    
     protected static final HashMap<String, Integer> CARDRULE;
    static
    {
        CARDRULE = new HashMap<String, Integer>();
        CARDRULE.put("A",14);
        //CARDRULE.put("1", 1);
        CARDRULE.put("2", 2);
        CARDRULE.put("3", 3);
        CARDRULE.put("4", 4);
        CARDRULE.put("5", 5);
        CARDRULE.put("6", 6);
        CARDRULE.put("7", 7);
        CARDRULE.put("8", 8);
        CARDRULE.put("9", 9);
        CARDRULE.put("10",10);
        CARDRULE.put("J", 11);
        CARDRULE.put("Q", 12);
        CARDRULE.put("K", 13);
    }
    
    protected static final HashMap<String, Integer> RULES;
     static
    {
        RULES = new HashMap<String, Integer>();
        RULES.put("Royal straight flush", 10);
        RULES.put("Straight flush", 9);
        RULES.put("Fourth", 8);
        RULES.put("Full house", 7);
        RULES.put("Flush", 6);
        RULES.put("Straight", 5);
        RULES.put("Three of kinds", 4);
        RULES.put("Two pairs", 3);
        RULES.put("Pairs", 2);
        RULES.put("High card", 1);
    }
}
