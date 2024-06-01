package org.core;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        // 要执行的脚本
        String script = "def message = 'Hello, ' + name + '!'; return message;";

        // 准备输入参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", "John");

/*        // 创建GroovyShell对象
        GroovyShell shell = new GroovyShell();

        // 创建Binding对象，并将参数添加到Binding中
        Binding binding = new Binding(params);

        // 设置Binding对象到GroovyShell中
        Script parse = shell.parse(script, binding);
//        shell.setBinding(binding);

        // 执行脚本
//        Object result = shell.evaluate(parse.toString());
        Object result = parse.run();*/

        Binding binding = new Binding(params);
        GroovyShell shell = new GroovyShell(binding);
        Object result = shell.evaluate(script);

        // 打印脚本返回值
        System.out.println(result);
    }
}
