package com.nz.nbp_converter.repository;


import com.nz.nbp_converter.entity.Product;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public final class XMLProductRepository {
    private String path = "src/main/resources/xml/products.xml";
    private static volatile XMLProductRepository instance;
    private XStream xstream;

    private XMLProductRepository(){
        xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream.processAnnotations(Product.class);


    }
    private Document getDoc(){
        // xml doc init
        File file = new File(path);
        DocumentBuilder builder = null;
        Document doc;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            doc = builder.parse(file);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        doc.getDocumentElement().normalize();
        return doc;
    }
    private void saveDomToFile(Document document,String fileName)
            throws Exception {

        DOMSource dom = new DOMSource(document);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();

        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(dom, result);
    }
    public void addProduct(Product product){
        Document doc = getDoc();
        Node root =  doc.getElementsByTagName("faktura").item(0);
        String productXml = productToXml(product);
        try {
            try {
                Node node =  DocumentBuilderFactory
                        .newInstance()
                        .newDocumentBuilder()
                        .parse(new ByteArrayInputStream(productXml.getBytes()))
                        .getDocumentElement();

                Node importedNode = doc.importNode(node,true);
                root.appendChild(importedNode);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            saveDomToFile(doc, path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String productToXml(Product product){

        return xstream.toXML(product);
    }
    public static XMLProductRepository getInstance(){
        if(instance != null){
            return instance;
        }
        synchronized (XMLProductRepository.class){
            if(instance == null){
                instance = new XMLProductRepository();
            }
            return instance;
        }

    }
}
