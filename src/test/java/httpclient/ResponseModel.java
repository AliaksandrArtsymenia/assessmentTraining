package httpclient;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "NumberToDollarsResponse")
public class ResponseModel {
//    private String body;
//    private String numberToDollarsResponse;
    private String numberToDollarsResult;

//    @XmlElement(name = "body")
//    public void setBody(String body) {
//        this.body = body;
//    }

//    @XmlElement(name = "NumberToDollarsResponse")
//    public void setNumberToDollarsResponse(String numberToDollarsResponse) {
//        this.numberToDollarsResponse = numberToDollarsResponse;
//    }

    @XmlElement()
    public void setNumberToDollarsResult(String numberToDollarsResult) {
        this.numberToDollarsResult = numberToDollarsResult;
    }

//    public String getBody() {
//        return body;
//    }

//    public String getNumberToDollarsResponse() {
//        return numberToDollarsResponse;
//    }

    public String getNumberToDollarsResult() {
        return numberToDollarsResult;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
//                ", body='" + body + '\'' +
//                ", numberResponse='" + numberToDollarsResponse + '\'' +
                ", numberResult='" + numberToDollarsResult + '\'' +
                '}';
    }
}
