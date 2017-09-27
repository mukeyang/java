package thinkinginjava;

/**
 * Created by CS on 2017/9/27.
 */
public enum Token {

    LPAR("LPAR","("),
    RPAR("RPAR",")"),
    PLUS("PLUS","+"),
    MINUS("MINUS","-"),
    MULT("MULT","*"),
    DIV("DIV","/"),
    INT("INT","Integer"),
    NONE("NONE","");

    public Object tokenType;
    public Object value;

    Token(Object tt, Object v) {
        this.tokenType = tt;
        this.value = v;
    }

}