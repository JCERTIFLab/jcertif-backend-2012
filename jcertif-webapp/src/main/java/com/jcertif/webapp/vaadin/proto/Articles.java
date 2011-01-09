/**
 * 
 */
package com.jcertif.webapp.vaadin.proto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rossi.oddet
 *
 */
@XmlRootElement
public class Articles {
	protected List<Article> list = new ArrayList<Article>();

    public Articles(){}

    public Articles(List<Article> list){
        this.list=list;
    }

    @XmlElement(name="article")
    public List<Article> getList(){
        return list;
    }

}
