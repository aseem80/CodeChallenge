package io.concur.interview;

import io.concur.interview.exception.InvalidInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Find Couple of Numbers Adding SUM to N!
 */
public class App {
    private static final Integer COUPLE_SUM = 42;
    private static final Integer MAXIMUM_ELEMENTS_ALLOWED = 1000000;

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new InvalidInputException( "Integer values are required" );
        }
        Integer[] input = new Integer[args.length];
        int index = 0;
        for (String arg : args) {
            try {
                Integer number = Integer.getInteger( arg );
                input[index] = number;
                index++;
            } catch (Exception e) {
                throw new InvalidInputException( "Provided Input is not an integer " + arg );
            }
        }
        System.out.println( hasCoupleForSum( input ) );

    }


    public static boolean hasCoupleForSum(Integer[] input) {
        if(input.length > MAXIMUM_ELEMENTS_ALLOWED) {
            throw new InvalidInputException( "Maximum Allowed Number of Elements : " + MAXIMUM_ELEMENTS_ALLOWED  );
        }
        Map<Integer, Integer> integerOccurenceMap = new HashMap<>( );
        for (Integer number : input) {
            if (integerOccurenceMap.get( number )!=null) {
                Integer timesOcccurence = integerOccurenceMap.get( number );
                ++timesOcccurence;
                integerOccurenceMap.put( number, timesOcccurence );
            }
            else {
                integerOccurenceMap.put( number, 1 );

            }
        }
        Set<Integer> keys = integerOccurenceMap.keySet( );
        boolean hasCoupleWithSum = false;
        for (Integer key : keys) {
            Integer numberToFind = COUPLE_SUM - key;
            if (integerOccurenceMap.containsKey( numberToFind )) {
                //If 21 exists more than 1 time only then we will have two numbers (21,21)
                if (key.equals( numberToFind )) {
                    Integer timesOcccurence = integerOccurenceMap.get( key );
                    if (timesOcccurence > 1) {
                        hasCoupleWithSum = true;
                        break;
                    }

                }
                else {
                    hasCoupleWithSum = true;
                    break;
                }
            }
        }


        return hasCoupleWithSum;


    }


}
