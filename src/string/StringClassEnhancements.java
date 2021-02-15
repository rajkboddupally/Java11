/*
    Author - Raj Kumar Boddupally
    Date - 02/15/2021
 */

package string;

import java.util.Set;
import java.util.stream.Collectors;

public class StringClassEnhancements {
    public static void main(String[] args) {
        //repeat();
        //isBlank();
        //lines();
        strip();
    }

    /*
    Removes the white space from both, beginning and the end of string.
     */
    private static void strip() {
        String str = " hello ";
        System.out.println("strip -" + str.strip() + "-");
        System.out.println("stripLeading -" + str.stripLeading() + "-");
        System.out.println("stripTrailing -" + str.stripTrailing() + "-");
    }

    /*
    This method returns a stream of strings, which is a collection of all substrings split by lines (\n)
     */
    private static void lines() {
        String str = "hello\nwelcome\nto\njava11\njava11";
        str.lines().forEach(System.out::println);
        Set<String> mySet = str.lines().collect(Collectors.toSet());
        System.out.println(mySet);
    }

    /*
    isBlank() – This instance method returns a boolean value. Empty Strings and Strings with only white spaces are treated as blank.
     */
    private static void isBlank() {
        String str = "";
        String str1 = "  ";
        String str2 = "     ";

        System.out.println(str.isBlank());
        System.out.println("  " + str1.isBlank());
        System.out.println("     " + str2.isBlank());
        System.out.println("hello " + "hello".isBlank());

    }

    /*
    The repeat method simply repeats the string that many numbers of times as mentioned in the method in the form of an int.
     */
    private static void repeat() {
        String str = "hello ";
        System.out.println(str.repeat(5));
    }
}
