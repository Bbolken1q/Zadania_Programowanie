package pl.bolekb;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Math.*;


public class Main {

    public static double pieniadze;
    public static Object[] wylosowaneLiczby = new Object[6];
    public static int wygrane;
    public static int losowanie;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Losowanie");

        System.out.println("Podaj ile pieniędzy masz na losowanie: ");
        pieniadze = scanner.nextDouble(); //Podaj ilość pieniędzy przeznaczoną na losowanie
        losowanie = (int)floor(pieniadze/4);
        pieniadze = pieniadze - losowanie*4;

        System.out.println("Zostało ci " + pieniadze + " zł, masz " + losowanie + " losowań");

        System.out.println("Podaj 6 liczb od 1 do 49");

        int[] liczby = new int[6];

        for(int i = 0; i<6; i++)// przypisywanie liczb do elementów tablicy
        {
            while(true)
            {
                int liczby_bufer = scanner.nextInt();
                if(liczby_bufer<=50&&liczby_bufer>=1&&IntStream.of(liczby).noneMatch(x -> x==liczby_bufer))
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

        losowanie(losowanie, liczby);

        while(pieniadze>4)
        {
            System.out.println("Czy chcesz zagrac jeszcze raz?");
            String wybor;
            scanner.nextLine();
            wybor = scanner.nextLine();
            if (wybor.equalsIgnoreCase("tak"))
            {
                losowanie = (int)floor(pieniadze/4);
                pieniadze = pieniadze - losowanie*4;
                losowanie(losowanie, liczby);
            }
            else
            {
                break;
            }
        }


    }

    public static void losowanie(double liczba_losowan, int[] wybor)
    {
        for (int i = 0; i < (liczba_losowan); i++)
        {
            losujLiczby();
            for (int j = 0; j < 6; j++)
            {
                if ((int)wylosowaneLiczby[j] == wybor[j])
                {
                    wygrane++;
                }
            }
            //System.out.println(wygrane);
            evaluate(wygrane);
        }
        losowanie = 0;
        System.out.println("Masz " + pieniadze + " zlotych");
    }

    public static void evaluate(int wygrana)
    {
        switch (wygrana) {
            case 0, 1, 2 -> System.out.println("Nie wygrałeś nic");
            case 3 -> {
                System.out.println("Wygrałeś 20 złotych");
                pieniadze = pieniadze + 20;
                wypiszLiczby();
            }

            case 4 -> {
                System.out.println("Wygrałeś 500 złotych");
                pieniadze = pieniadze + 500;
                wypiszLiczby();
            }

            case 5 -> {
                System.out.println("Wygrałeś 9000 złotych");
                pieniadze = pieniadze + 9000;
                wypiszLiczby();
            }

            case 6 -> {
                System.out.println("Wygrałeś 1000000 złotych");
                pieniadze = pieniadze + 1000000;
                wypiszLiczby();
            }
        }
        wygrane = 0;
    }

    public static void losujLiczby()
    {
        Set<Integer> wylosowane = new HashSet<>();
        Random random = new Random();
        for(int i = 0; i<6; i++)
        {
            while(true) {
                if (wylosowane.add(random.nextInt(49))) {
                    break;
                }
            }
        }
        wylosowaneLiczby = wylosowane.toArray();
    }

    public static void wypiszLiczby()
    {
        for (int j = 0; j < 6; j++)
        {
            if(j==5)
            {
                System.out.println(wylosowaneLiczby[j]);
            }
            else
            {
                System.out.print(wylosowaneLiczby[j] + ", ");
            }
        }
    }
}