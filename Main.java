import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static int function(int n) {
        if (n==2) {
            return n;
        }
        else {return n / (function(n/2));}
    }

    public static void main(String[] args) {
        System.out.println(function(12));

    }
}
