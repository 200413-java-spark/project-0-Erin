package com.github.ettynan.mort;


import com.github.ettynan.mort.ReadIn;
import com.github.ettynan.mort.Info;
import com.github.ettynan.mort.Calc;


public class Mort {
    public static void main(String []args) {
        
        // read in file call to reader function
        ReadIn readIn = new ReadIn();

        // gather all the needed information from user for mortgage calculation
        // Info info = new Info();
        Calc calc = new Calc(readIn);
        System.out.println(calc);
        }
    }
