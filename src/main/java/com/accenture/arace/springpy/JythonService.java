package com.accenture.arace.springpy;

import java.io.InputStream;

import org.python.core.PyClass;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Component;

@Component
public class JythonService {
    
    PythonInterpreter pythonInterpreter;

    public JythonService() {
        pythonInterpreter = new PythonInterpreter();
    }

    public void invokeHelloWorld(InputStream inputStream) {
        pythonInterpreter.execfile(inputStream);
    }
    
    public String invokeClass(Integer numerator, Integer denominator) {
        pythonInterpreter.exec("from divider import Divider");
        PyClass dividerDef = (PyClass) pythonInterpreter.get("Divider");
        PyObject divider = dividerDef.__call__();
        PyObject pyObject = divider.invoke("divide",new PyInteger(numerator),new PyInteger(denominator));
        System.out.println(pyObject.toString());
        return pyObject.toString();
    }

}