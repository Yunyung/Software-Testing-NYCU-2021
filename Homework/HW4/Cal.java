// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapters 8, 9; pages 226, 257
// Can be run from command line
// No JUnit tests at this time.

import java.io.*;

public class Cal
{
    public static int cal (int month1, int day1, int month2,
                           int day2, int year)
    {
        //***********************************************************
        // Calculate the number of Days between the two given days in
        // the same year.
        // preconditions : day1 and day2 must be in same year
        //               1 <= month1, month2 <= 12
        //               1 <= day1, day2 <= 31
        //               month1 <= month2
        //               The range for year: 1 ... 10000
        //***********************************************************
        int numDays;

        if (month2 == month1) // in the same month
            numDays  = day2 - day1;
        else
        {
            // Skip month 0.
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            // Are we in a leap year?
            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;
            if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            // start with days in the two months
            numDays = day2 + (daysIn[month1] - day1);

            // add the days in the intervening months
            for (int i = month1 + 1; i <= month2-1; i++)
                numDays = daysIn[i] + numDays;
        }
        return (numDays);
    }

    public static void main (String[] argv)
    {  // Driver program for cal
        int month1, day1, month2, day2, year;
        int T;

        System.out.println ("Enter month1: ");
        month1 = getN();
        System.out.println ("Enter day1: ");
        day1 = getN();
        System.out.println ("Enter month2: ");
        month2 = getN();
        System.out.println ("Enter day2: ");
        day2 = getN();
        System.out.println ("Enter year: ");
        year = getN();
        // preconditions : day1 and day2 must be in same year
        //               1 <= month1, month2 <= 12
        //               1 <= day1, day2 <= 31
        //               month1 <= month2
        //               The range for year: 1 ... 10000

        if ( (month1 < 1) || (month1 > 12) )
        {
            month1 = 1;
            System.out.println ("invalid month1, choosing 1.");
        }
        if ( (month2 < 1) || (month2 > 12) )
        {
            month2 = 1;
            System.out.println ("invalid month2, choosing 1.");
        }
        if ( (day1 < 1) || (day1 > 31) )
        {
            day1 = 1;
            System.out.println ("invalid day1, choosing 1.");
        }
        if ( (day2 < 1) || (day2 > 31) )
        {
            day2 = 1;
            System.out.println ("invalid day2, choosing 1.");
        }
        while ( month1 > month2 )
        {
            System.out.println ("month1 must be prior or equals to month2");
            System.out.println ("Enter month1: ");
            month1 = getN();
            System.out.println ("Enter month2: ");
            month2 = getN();
        }
        if ( (year < 1) || (year > 10000) )
        {
            year = 1;
            System.out.println ("invalid year, choosing 1.");
        }

        T = cal (month1, day1, month2, day2, year);

        System.out.println ("Result is: " + T);
    }

    // ====================================
    // Read (or choose) an integer
    private static int getN ()
    {
        int inputInt = 1;
        BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
        String inStr;

        try
        {
            inStr    = in.readLine ();
            inputInt = Integer.parseInt(inStr);
        }
        catch (IOException e)
        {
            System.out.println ("Could not read input, choosing 1.");
        }
        catch (NumberFormatException e)
        {
            System.out.println ("Entry must be a number, choosing 1.");
        }

        return (inputInt);
    }  // end getN
}
