package com.maimai.mybatisApp;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.dom4j.Element;
;
import org.dom4j.XPath;


/**
 * Created by maimai on 2018-04-19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class xml测试 {
    @Test
    public void Test() {
        String path="xml/ABKJ2017072900C.xml";
        xml测试 xmlp = new xml测试();
        Document doc = xmlp.readXML(path);
        Map nsMap=new HashMap();
        nsMap.put("xml","http://www.w3.org/XML/1998/namespace");
        XPath xpath=doc.createXPath("//article/title[@xml:lang='en']");
        xpath.setNamespaceURIs(nsMap);
        List<Element> list = xpath.selectNodes(doc);
        for(Element element:list){
            System.out.println(element.asXML());
            System.out.println(element.getData());
        }

    }

    public Document readXML(String file) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        SAXReader saxReader = new SAXReader();
        Document doc = null;
        try {
            doc = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
