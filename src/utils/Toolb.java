package utils;

import java.io.InputStream;
import java.util.Scanner;
/**
 * Brainless ToolBox
 *
 */
public class Toolb {
    /**
     * Read All things from InputStream
     * a:InputStream
     * @param a java.io.InputStream
     * @return AllString
     */
    public static String readAllString(InputStream a){
        Scanner scr = new Scanner(a);
        StringBuilder sb = new StringBuilder();
        while(scr.hasNextLine()){
            sb.append(scr.nextLine());
        }
        return sb.toString();
    }
}
