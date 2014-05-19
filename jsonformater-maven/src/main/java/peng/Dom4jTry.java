package peng;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;

public class Dom4jTry {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Document document = read("c:" + File.separator + "App_config.xml");
		Element root = document.getRootElement();
		//root.accept(new MyVisitor());
		//treeWalkStart(root);
		iterateOne(root,"file");
	}
	
	public static Document read(String fileName) throws MalformedURLException,DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(fileName));
		return document;
	}
	
	public static Element getRootElement(Document doc) {
		return doc.getRootElement();
	}
	//1遍历方法
	public static void iterateAll(Element root){
		for (Iterator i = root.elementIterator(); i.hasNext(); ) {
			Element e = (Element)i.next();
			//do something
		}
	}
	public static void iterateOne(Element root, String theOne){
		for (Iterator i = root.elementIterator(theOne); i.hasNext(); ) {
			Element e = (Element)i.next();
			//do something
			System.out.println(e.getText());
		}
	}
	public static void iterateAttribute(Element root) {
		for (Iterator i = root.attributeIterator(); i.hasNext(); ) {
			Attribute attribute = (Attribute)i.next();
			//do something
		}
	}
	//2递归方法
	public static void treeWalkStart(Element root) {
		treeWalk(root);
	}
	public static void treeWalk(Element element) {
		for (int i=0, size=element.nodeCount(); i<size; i++) {
			Node node = element.node(i);
			if (node instanceof Element) {
				treeWalk((Element) node);
				System.out.println(node.getName());
			} else {
				//do something
			}
		}
	}
	//Visitor模式
	//root.accept(new MyVisitor());
}
class MyVisitor extends VisitorSupport {
	public void visit(Element element) {
		System.out.println("Element: " + element.getName());
	}
	public void visit(Attribute attr) {
		System.out.println("Attribute: " + attr.getName() + "value: " + attr.getValue());
	}
}
