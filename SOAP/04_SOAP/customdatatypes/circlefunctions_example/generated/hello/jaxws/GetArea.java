
package hello.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getArea", namespace = "http://hello/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArea", namespace = "http://hello/")
public class GetArea {

    @XmlElement(name = "arg0", namespace = "")
    private double arg0;

    /**
     * 
     * @return
     *     returns double
     */
    public double getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(double arg0) {
        this.arg0 = arg0;
    }

}
