package Parser;
import java.io.File;

public class Teste {
    public static void main(String args[]) {

        //Parser parser = new Parser("53 45,7 \"oi 56 ana tudo bem?\" algumacoisa");
        File file = new File("teste.emp");
        Parser parser = new Parser(file);

        while (parser.hasNext()) {
            Element e = parser.nextElement();
            System.out.println(e);
        }
    }
}
