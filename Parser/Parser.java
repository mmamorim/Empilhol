
package Parser;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {
    private Scanner leitor;

    public Parser(File file) {
        
        try {
            leitor = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public Parser(String input) {
        leitor = new Scanner(input);
    }

    public Element nextInt() {
        try {
            int ivalue = leitor.nextInt();
            return new Element(ivalue);
        } catch (Exception e) {
            return new Element();
        }
    }

    public Element nextDouble() {
        try {
            double dvalue = leitor.nextDouble();
            return new Element(dvalue);
        } catch (Exception e) {
            return new Element();
        }
    }

    public Element nextToken() {
        String svalue = "";
        try {
            svalue = leitor.next();
            if (svalue.charAt(0) == '"') {
                if (svalue.length() > 1 && svalue.charAt(svalue.length() - 1) == '"') {
                    return new Element(svalue);
                }
                String snext = " ";
                while (leitor.hasNext() && snext.charAt(snext.length() - 1) != '"') {
                    snext = leitor.next();
                    // System.out.println("svalue "+svalue+" snext "+snext);
                    svalue = svalue + " " + snext;
                }
                // System.out.println("svalue "+svalue);
                // System.out.println("last "+svalue.charAt(svalue.length()-1));
                if (svalue.charAt(svalue.length() - 1) == '"') {
                    return new Element(svalue);
                } else {
                    return new Element(svalue,true);
                }
            }
            return new Element(svalue,true);
        } catch (Exception e) {
            return new Element();
        }
    }

    public boolean hasNext() {
        return leitor.hasNext();
    }

    public Element nextElement() {
        Element e = nextInt();
        if (e.getType() == Element.UNDEFINED) {
            e = nextDouble();
        }
        if (e.getType() == Element.UNDEFINED) {
            e = nextToken();
        }
        return e;
    }
}