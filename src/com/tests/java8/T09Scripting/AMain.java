package com.tests.java8.T09Scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AMain {

	public static void main(String[] args) throws ScriptException {
		
		ScriptEngineManager manager = new ScriptEngineManager();
		
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		
		System.out.println(engine.getClass().getName());
		
		System.out.println("Result: " + engine.eval( "function f() { return 1; }; f() + 1;" ));
		// jdk.nashorn.api.scripting.NashornScriptEngine
		// Result: 2.0
	}
}