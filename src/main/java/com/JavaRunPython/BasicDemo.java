package com.JavaRunPython;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;


/**
 * java调用python Demo
 * https://blog.csdn.net/weixin_30268071/article/details/97875668
 */

public class BasicDemo {

    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("test.py"); // 可能需要写全路径
        PyFunction function = (PyFunction)interpreter.get("my_test",PyFunction.class);
        PyObject pyobject = function.__call__(new PyString("huzhiwei"),new PyString("25"));
        System.out.println("anwser = " + pyobject.toString());
    }

}
