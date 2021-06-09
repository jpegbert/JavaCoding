package com.JavaRunPython;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 * java调用python Demo
 */
public class JavaRunPythonDemo {

    /**
     * 这种方式会报找不到模块错误
     */
    private static void test() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import sys");
        interpreter.exec("E:/ruanjian/python3.6/anzhuangwenjian/Lib/site-packages/");

        interpreter.execfile("test1.py"); // 可能需要写全路径

        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyFunction pyFunction = interpreter.get("my_test", PyFunction.class);
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyobj = pyFunction.__call__(new PyString("abc"), new PyInteger(18));
        System.out.println("the anwser is: " + pyobj);
    }

    /**
     * 这种方式只能运行不引入第三方模块的
     */
    private static void test0() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("test.py"); // 可能需要写全路径

        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyFunction pyFunction = interpreter.get("my_test", PyFunction.class);
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyobj = pyFunction.__call__(new PyString("abc"), new PyInteger(18));
        System.out.println("the anwser is: " + pyobj);
    }

    public static void main(String[] args) {
        test0();
        test();
    }

}
