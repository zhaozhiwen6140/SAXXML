package com.example.cnlive.saxxml;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by CNLive on 2016/3/10.
 */
public class ContentHandler extends DefaultHandler {
    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;
    @Override
    public void startDocument() throws SAXException {
       id=new StringBuilder();
        name=new StringBuilder();
        version=new StringBuilder();

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName=localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("app".equals(localName)){
            Log.e("id",id.toString().trim());
            Log.e("name",name.toString().trim());
            Log.e("id",version.toString().trim());
        }
        //清空数据，防止为下一次的数据存储造成影响。
        id.setLength(0);
        name.setLength(0);
        version.setLength(0);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("id".equals(nodeName)){
            id.append(ch,start,length);
        }else if("name".equals(nodeName)){
            name.append(nodeName);
        }else if("version".equals(nodeName)){
            name.append(version);
        }
    }
}
