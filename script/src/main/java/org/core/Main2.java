//package org.core;
//
//import groovy.lang.Binding;
//import groovy.lang.GroovyShell;
//
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//
//public class Main2 {
//    public static void main(String[] args) throws Exception {
//        // 创建ScriptEngineManager实例
//        ScriptEngineManager factory = new ScriptEngineManager();
//
//        // 获取GroovyScriptEngine实例
//        ScriptEngine engine = factory.getEngineByName("groovy");
//
//        // 创建Binding对象，用于传递变量和值
//        Binding binding = new Binding();
//        binding.setVariable("name", "World");
//
//        // 执行Groovy脚本
//        engine.eval("println 'Hello, ' + name", binding);
//
//        // 或者使用GroovyShell执行脚本
//        GroovyShell shell = new GroovyShell(binding);
//        shell.evaluate("println 'Hello, ' + name");
//    }
//}
