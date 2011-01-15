/**
 * 
 */
package com.jcertif.bo.article;

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
	protected List<Article> articles = new ArrayList<Article>();

    public Articles(){}

    public Articles(List<Article> articles){
        this.articles=articles;
    }

    @XmlElement(name="article")
    public List<Article> getArticles(){
        return articles;
    }

}
