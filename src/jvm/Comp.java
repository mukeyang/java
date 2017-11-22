package jvm;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by CS on 2017/11/14.
 */
public class Comp {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine script = manager.getEngineByName("JavaScript");
        Object o = script.eval("var x=2");
        System.out.println(script.eval("x+1"));
    }
}
