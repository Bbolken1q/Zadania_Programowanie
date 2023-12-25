package pl.bolekb;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.*;



public class Main {

    public static double pieniadze;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Losowanie");
        System.out.println("Podaj ile pieniędzy masz na losowanie: ");
        pieniadze = scanner.nextDouble(); //Podaj ilość pieniędzy przeznaczoną na losowanie
        double losowanie = floor(pieniadze/4);
        pieniadze = pieniadze - losowanie*4;

        System.out.println("Zostało ci " + pieniadze + " zł, masz " + losowanie + " losowań");

        System.out.println("Podaj 6 liczb od 1 do 49");
        int[] liczby = new int[6];

        for(int i = 0; i<6; i++)// przypisywanie liczb do elementów tablicy
        {

            while(true)
            {
                int liczby_bufer = scanner.nextInt();
                if(liczby_bufer<=50&&liczby_bufer>=1)
                {
                    liczby[i] = liczby_bufer;
                    break;
                }
                else
                {
                    System.out.println("Nieprawidłowa liczba. Spróbuj jeszcze raz");
                }
            }


        }
        System.out.println("Twoje liczby to: ");
        for(int i = 0; i<6; i++)
        {
            if(i==5)
            {
                System.out.println(liczby[i]);
            }
            else
            {
                System.out.print(liczby[i] + ", ");
            }

        }
        losuj(losowanie, liczby);
    }

    public static void losuj(double liczba_losowan, int[] wybor)
    {
        Random random = new Random();
        for (int i = 0; i < (liczba_losowan); i++)
        {
            int bufer_wygrana = 0;
            int[] randomNumbers = new int[6];
            for (int j = 0; j < 6; j++)
            {
                randomNumbers[j] = random.nextInt(49);
                if (randomNumbers[j] == wybor[j])
                {
                    bufer_wygrana++;
                    evaluate(bufer_wygrana);
                }
            }
        }
    }

    public static void evaluate(int wygrana)
    {
        switch (wygrana) {
            case 1, 2 -> System.out.println("Nie wygrałeś nic");
            case 3 -> {
                System.out.println("Wygrałeś 20 złotych");
                pieniadze = pieniadze + 20;
            }

            case 4 -> {
                System.out.println("Wygrałeś 500 złotych");
                pieniadze = pieniadze + 500;
            }

            case 5 -> {
                System.out.println("Wygrałeś 9000 złotych");
                pieniadze = pieniadze + 9000;
            }

            case 6 -> {
                System.out.println("Wygrałeś 1000000 złotych");
                pieniadze = pieniadze + 1000000;
            }
        }
    }
}