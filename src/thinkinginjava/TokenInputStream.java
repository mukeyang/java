package thinkinginjava;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by CS on 2017/9/27.
 */
public class TokenInputStream  {



    private char[] cbuf = new char[256];

    private int i = 0;

    public TokenInputStream(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try {
            inputStreamReader.read(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String outString = "";

    public Token getToken() throws IOException {

        Token token;

        Character c = cbuf[i];
        String s = c.toString();

        switch (s){
            case "(":
                token = Token.LPAR;
                break;
            case ")":
                token = Token.RPAR;
                break;
            case "+":
                token = Token.PLUS;
                break;
            case "-":
                token = Token.MINUS;
                break;
            case "*":
                token = Token.MULT;
                break;
            case "/":
                token = Token.DIV;
                break;
            case " ":
                token = Token.NONE;
                break;
            default:
                token = Token.INT;
        }

        if(token == Token.INT){
            outString = "{" + token.tokenType + "," + token.value + "("+ s +")}";
        }else{
            outString = "{" + token.tokenType + ",\"" + token.value +"\"}";
        }

        return token;
    }


    public void consumeToken() {
        System.out.println(outString);
        i++;
    }

    public static void main(String[] args) throws IOException {
//        TokenInputStream t = new TokenInputStream(System.in);
//        for (int i = 0; i < 5; i++) {
//        t.getToken();
//            t.consumeToken();
//        }
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        System.out.println(line.toCharArray());
//        BufferedReader a=new BufferedReader(new InputStreamReader(System.in));
//        char[] cbuf = new char[1];
//        int read = a.read(cbuf);
//        System.out.println(cbuf[0]);
        BufferedInputStream b = new BufferedInputStream(System.in);
        byte[] b1 = new byte[1];
        b.read(b1);
        System.out.println(new Character((char) b1[0]));
    }
}
