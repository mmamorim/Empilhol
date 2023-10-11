package Parser;

public class Element {
    public final static int UNDEFINED = 0;
    public final static int INT = 1;
    public final static int DOUBLE = 2;
    public final static int STRING = 3;
    public final static int TOKEN = 4;

    private int type;
    private int int_value;
    private double double_value;
    private String string_value;
    private Element next;

    public Element() {
        this.type = Element.UNDEFINED;
    }

    public int getType() {
        return type;
    }

    public Element(int value) {
        this.int_value = value;
        this.type = Element.INT;
    }

    public Element(double value) {
        this.double_value = value;
        this.type = Element.DOUBLE;
    }

    public Element(String value) {
        this.string_value = value;
        this.type = Element.STRING;
    }

    public Element(String value, boolean isToken) {
        this.string_value = value;
        this.type = Element.TOKEN;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element e) {
        this.next = e;
    }

    public void print() {
        if (type == Element.UNDEFINED)
            System.out.println("UNDEFINED");
        if (type == Element.INT)
            System.out.println("[INT] " + int_value);
        if (type == Element.DOUBLE)
            System.out.println("[DOUBLE] " + double_value);
        if (type == Element.STRING)
            System.out.println("[STRING] " + string_value);
        if (type == Element.TOKEN)
            System.out.println("[TOKEN] " + string_value);
    }

    public String toString() {
        if (type == Element.INT)
            return "[INT] " + int_value;
        if (type == Element.DOUBLE)
            return "[DOUBLE] " + double_value;
        if (type == Element.STRING)
            return "[STRING] " + string_value;
        if (type == Element.TOKEN)
            return "[TOKEN] " + string_value;
        return "UNDEFINED";
    }
}
