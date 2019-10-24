package jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
public class Capi {
    private String function;
    private String functionName;
    private String param;
//    @XmlAttribute
//    private String paramName;

    public String getFunction() {
        return function;
    }
    @XmlElement
    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunctionName() {
        return functionName;
    }
    @XmlAttribute
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getParam() {
        return param;
    }
    @XmlElement
    public void setParam(String param) {
        this.param = param;
    }

//    public String getParamName() {
//        return paramName;
//    }

//    public void setParamName(String paramName) {
//        this.paramName = paramName;
//    }

    public Capi(String function, String functionName, String param) {
        this.function = function;
        this.functionName = functionName;
        this.param = param;
    }

    public Capi(){};

    @Override
    public String toString() {
        return "CapiModel{" +
                "function='" + function + '\'' +
                ", functionName='" + functionName + '\'' +
                ", param=" + param +
//                ", paramName='" + paramName + '\'' +
                '}';
    }
}
