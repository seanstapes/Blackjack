package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void deal1() {
        ArrayList<String> ar = new ArrayList<String>();
        String[] CardName = {"ACE of Hearts", "ACE of Clubs", "Ace of Spades", "Ace of Diamonds", "2 of Hearts", "2 of Clubs", "2 of Spades,", "2 of Diamonds", "3 of Hearts", "3 of Clubs", "3 of Spades,", "3 of Diamonds", "4 of Hearts", "4 of Clubs", "4 of Spades", "4 of Diamonds", "5 of Hearts", "5 of Clubs", "5 of Spades,", "5 of Diamonds", "6 of Hearts", "6 of Clubs", "6 of Spades,", "6 of Diamonds", "7 of Hearts", "7 of Clubs", "7 of Spades,", "7 of Diamonds", "8 of Hearts", "8 of Clubs", "8 of Spades,", "8 of Diamonds", "9 of Hearts", "9 of Clubs", "9 of Spades,", "9 of Diamonds", "10 of Hearts", "2 of Clubs", "10 of Spades,", "10 of Diamonds", "Jack of Hearts", "Jack of Clubs", "Jack of Spades,", "Jack of Diamonds", "Queen of Hearts", "Queen of Clubs", "Queen of Spades,", "Queen of Diamonds", "King of Hearts", "King of Clubs", "King of Spades,", "King of Diamonds",};
        int[] CardValue = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int playerCount = 0;
        int dealerCount = 0;
        ArrayList<String> playerCards = new ArrayList<String>();
        ArrayList<String> dealerCards = new ArrayList<String>();
        int bet = 100;
        System.out.println("Welcome to blackjack!");
        System.out.println("You have $" + bet + ". How much would you like to bet?");
        Scanner bettingMoney = new Scanner(System.in);
        int yourBet = bettingMoney.nextInt();

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                Random RandomCard = new Random();
                int low = 0;
                int high = CardName.length;
                int randomCard = RandomCard.nextInt(high - low) + low;;
                playerCount += CardValue[randomCard];
                playerCards.add(CardName[randomCard]);

                // Removing cards from deck
                CardValue = removeTheElement(CardValue, randomCard);
                CardName = removeTheElement2(CardName, randomCard);

                if (i == 2) {
                    System.out.println("Player has: ");
                    for(String d:playerCards) {
                        System.out.println(d);
                    }
                    System.out.println("Players count: " + playerCount);
                    System.out.println(" ");
                }
            }
            else {
                Random RandomCard = new Random();
                int low = 0;
                int high = CardName.length;
                int randomCard = RandomCard.nextInt(high - low) + low;
                dealerCount += CardValue[randomCard];
                dealerCards.add(CardName[randomCard]);

                // Removing cards from deck
                CardValue = removeTheElement(CardValue, randomCard);
                CardName = removeTheElement2(CardName, randomCard);

                if (i == 3) {
                    System.out.println("Dealer has: ");
                    for (int j = 0; j < 1;j++)
                    {
                        System.out.println(dealerCards.get(j));
                    }
                    System.out.println("Hidden Card");
                    System.out.println("Dealer count: ?");
                    System.out.println(" ");
                }
            }
        }
        while (playerCount < 21 & bet > 0) {
            System.out.println("Hit(1) or Stand (2)");
            Scanner input = new Scanner(System.in);
            int firstNumber = input.nextInt();
            if (playerCount < 21 || firstNumber != 2) {
                if (firstNumber == 1) {
                    Random RandomCard = new Random();
                    int low = 0;
                    int high = CardName.length;
                    int randomCard = RandomCard.nextInt(high - low) + low;;
                    playerCount += CardValue[randomCard];
                    playerCards.add(CardName[randomCard]);

                    // Removing cards from deck
                    CardValue = removeTheElement(CardValue, randomCard);
                    CardName = removeTheElement2(CardName, randomCard);
                    System.out.println("Player has: ");
                    for(String d:playerCards) {
                        System.out.println(d);
                    }
                    System.out.println("Players count: " + playerCount);
                    System.out.println(" ");
                    if (playerCount == 21) {

                        System.out.println("Player wins $" + 2*yourBet);
                        System.out.println(" ");
                        deal1();
                        break;
                    }
                    else if (playerCount > 21) {
                        System.out.println("You bust. Dealer wins");
                        System.out.println("You lost $" + yourBet);
                        System.out.println(" ");
                        bet -= yourBet;
                        if (bet > 0) {
                            deal1();
                        }
                        else {
                            System.out.println("You went broke");
                            break;
                        }
                    }
                }
                else {
                    for (int k = 0; dealerCount < 17; k++) {
                        Random RandomCard = new Random();
                        int low = 0;
                        int high = CardName.length;
                        int randomCard = RandomCard.nextInt(high - low) + low;
                        dealerCount += CardValue[randomCard];
                        dealerCards.add(CardName[randomCard]);

                        // Removing cards from deck
                        CardValue = removeTheElement(CardValue, randomCard);
                        CardName = removeTheElement2(CardName, randomCard);

                        System.out.println("Dealer has: ");
                        for (String d : dealerCards) {
                            System.out.println(d);
                        }
                        System.out.println("Dealer count: " + dealerCount);
                        System.out.println(" ");
                    }
                    if (dealerCount > 21) {
                        System.out.println("Dealer bust. Player wins $" + 2*yourBet);
                        System.out.println(" ");
                        deal1();
                        break;
                    } else if (21 - playerCount < 21 - dealerCount) {
                        System.out.println("Player wins $" + 2*yourBet);
                        System.out.println(" ");
                        deal1();
                        break;
                    } else if (21 - playerCount > 21 - dealerCount) {
                        System.out.println("Dealer has:");
                        for (String d : dealerCards) {
                            System.out.println(d);
                        }
                        System.out.println("Dealer count: " + dealerCount);
                        System.out.println("Dealer wins");
                        System.out.println("You lost $" + yourBet);
                        System.out.println(" ");
                        bet -= yourBet;
                        if (bet > 0) {
                            deal1();
                        }
                        else {
                            System.out.println("You went broke");
                            break;
                        }
                    }
                    else if (playerCount == dealerCount) {
                        System.out.println("Push: No one wins.");
                        System.out.println(" ");
                        deal1();
                        break;
                    }
                }
            }
        }
    }

    //Removing value from value array
    public static int[] removeTheElement(int[] arr,
                                         int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    //Removing card from deck
    public static String[] removeTheElement2(String[] arr,
                                         int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        String[] anotherArray = new String[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void main(String[] args) {
	deal1();
    }
}
