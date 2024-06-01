package org.core;

import javax.naming.Binding;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("groovy");

        String script = """
                def hello = 'Hello, Groovy!';
                println hello;
                """;

        // 执行Groovy脚本
        engine.eval(script);
    }
}