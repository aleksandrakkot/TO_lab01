package main;

import java.util.Scanner;

public class UserInput {
    private String code1;
    private String code2;
    private float wartosc;
    private Scanner scan;

    public UserInput()
    {
        scan = new Scanner(System.in);
    }

    public void getDataFromUser()
    {
        System.out.println("Podaj kod waluty 1");
        code1 = scan.nextLine();
        System.out.println("Podaj kod waluty 2");
        code2 = scan.nextLine();
        System.out.println("Podaj kwote w walucie 1");
        GetValidValue();
    }

    private void GetValidValue()  //zabezpieczenie w przypadku podania złej waluty
    {
        boolean success = false;
        while(!success)
        {
            try
            {
                wartosc = Float.parseFloat(scan.nextLine());
                success = true;
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Podano niepoprawna wartosc, podaj ponownie");
            }
        }
    }

    public String getCode1()
    {
        return code1;
    }

    public String getCode2()
    {
        return  code2;
    }

    public float getWartosc()
    {
        return wartosc;

    }
}
