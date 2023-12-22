@XmlSchema(
    namespace = "http://www.w3.org/2003/05/soap-envelope",
    xmlns = {
        @XmlNs(prefix = "s", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
        @XmlNs(prefix = "a", namespaceURI = "http://www.w3.org/2005/08/addressing")
    }
)
package com.reusable.component.pojo;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;