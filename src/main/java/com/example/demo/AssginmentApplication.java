package com.spring.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EventSimulation 
{
    
    public static void distribution(Map<Object, Integer> input) 
    {
        
    	
    	
    	//resultMap to store the occurrences of events and initialize it's count to 0
        Map<Object, Integer> resultMap = new HashMap<>();
        
        for (Object event : input.keySet()) 
        {
            resultMap.put(event, 0);
        }
        
        // Random method to simulate the occurrence of an event with given biases
       
           Random random = new Random();
           int occurrences = 1000;
        
        /* Calculating the cumulative probability for every occurrence(eg:1000 occurrences) and 
           if cp equals or greater then the current random number then the event has been selected 
           and the count of occurrence is added in resultMap
        
        */
        
        
        for (int i = 0; i < occurrences; i++) 
        {
        	
            int randomNumber = random.nextInt(100) + 1;
            int cumulativeProbability = 0;
            
            
            for (Map.Entry<Object, Integer> entry : input.entrySet()) 
            {
                
            	Object event = entry.getKey();
                int probability = entry.getValue();
                
                cumulativeProbability += probability;
                
                if (randomNumber <= cumulativeProbability)
                {
                    resultMap.put(event, resultMap.get(event) + 1);
                    break;
                }
                
                
            }
        }
        
        // Displaying the results
        for (Map.Entry<Object, Integer> entry : resultMap.entrySet()) 
        {
            Object event = entry.getKey();
            int count = entry.getValue();
            double percentage = (count / (double) occurrences) * 100;
            System.out.printf("%s: %d times (%.2f%%)%n", event, count, percentage);
        }
    }
    
    public static void main(String[] args) 
    {
        Map<Object, Integer> dice = new HashMap<>();
        dice.put(1, 10);
        dice.put(2, 30);
        dice.put(3, 15);
        dice.put(4, 15);
        dice.put(5, 30);
        dice.put(6, 0);
        
        System.out.println("The probability distribution of rolling a dice 1000 times: \n");
        distribution(dice);
        
        Map<Object, Integer> coin = new HashMap<>();
        coin.put("HEAD", 35);
        coin.put("TAIL", 65);
        
        System.out.println("\nThe probability distribution of tossing a coin 1000 times: \n");
        distribution(coin);
    }
    
    
}
