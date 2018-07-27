package com.accenture.arace.springpy;

import java.io.InputStream;

import org.python.core.PyClass;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Component;

@Component
public class JythonService {
    
    PythonInterpreter pythonInterpreter;

    public JythonService() {
        pythonInterpreter = new PythonInterpreter();
    }

    public void execScriptAsInputStream (InputStream inputStream) {
        pythonInterpreter.execfile(inputStream);
    }

    public String execMethodInPyClass(String fileName, String className, String methodName) {
        pythonInterpreter.exec("from main import Main");
        PyClass mainClass = (PyClass) pythonInterpreter.get("Main");
        PyObject main = mainClass.__call__();
        PyObject pyObject = main.invoke("launchAndDebug", new PyString("svn://192.168.37.135/test"));
        return pyObject.toString();
    }

}