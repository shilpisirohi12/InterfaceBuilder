package application;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class xmlTest {
	
	final static String filePath="/u02/ETL_Share/pge/inraker/etl/v3";
	final static String archivePath="/u02/ETL_Share/pge/inraker/etl/v3/archive";
	final static String fileMask="CCB-EXTRACT-SA_[%m%d%Y]_*.DAT";
	final static String interfaceName="interfaceName";
	final static String interfaceDesc="desc";

	public xmlTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//Generating XML
		try {
		DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
		Document doc=docBuilder.newDocument();
		
		//Root Element
		Element rootElement=doc.createElementNS("http://dataraker.net/etl.xsd","etl");
		doc.appendChild(rootElement);

		//Setting Root Element Attribute
		
		rootElement.setAttribute("xmlns", "http://dataraker.net/etl.xsd");
		rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttribute("xsi:schemaLocation", "http://dataraker.net/etl.xsd");
		
		//source Element
		Element sourceElement=doc.createElement("source");
		rootElement.appendChild(sourceElement);

		//Setting Source Element Attribute
		sourceElement.setAttribute("desc", "lg");
		sourceElement.setAttribute("name", "lg");
		sourceElement.setAttribute("xsi:type", "source_type_file");
		sourceElement.setAttribute("file_archive_flag", "true");
		sourceElement.setAttribute("file_compress_flag", "false");
		
		//Source Name Element
		Element sourceNameElement=doc.createElement("source_name");
		sourceElement.appendChild(sourceNameElement);
		
		//Conn Name Element
		Element connNameElement=doc.createElement("conn_name");
		sourceElement.appendChild(connNameElement);
		
		//File path Element
		Element filepathElement=doc.createElement("file_path");
		filepathElement.appendChild(doc.createTextNode(filePath));
		sourceElement.appendChild(filepathElement);
		
		// Archive path Element
		Element archivepathElement=doc.createElement("archive_path");
		archivepathElement.appendChild(doc.createTextNode(archivePath));
		sourceElement.appendChild(archivepathElement);
		
		//file mask Element
		Element filemaskElement=doc.createElement("file_mask");
		filemaskElement.appendChild(doc.createTextNode(fileMask));
		sourceElement.appendChild(filemaskElement);
		
		//Formats Element
		Element formats=doc.createElement("formats");
		rootElement.appendChild(formats);
		
		//Format element
		Element format=doc.createElement("format");
		format.setAttribute("xsi:type", "format_type_delimited");
		format.setAttribute("name",interfaceName );
		format.setAttribute("desc", interfaceDesc);
		format.setAttribute("line_terminator", "\n");
		format.setAttribute("delimiter", "," );
		format.setAttribute("escape_char", " ");
		format.setAttribute("quote_char", "\"");
		format.setAttribute("double_quote", "false");
		format.setAttribute("skip_lines_bottom", "0");
		format.setAttribute("skip_lines_top", "0");
		formats.appendChild(format);
		
	
		
		
		
		//Writing the document into XML File
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		DOMSource source=new DOMSource(doc);
		StreamResult result=new StreamResult(new File("D:\\xmlFiles\\testfile.xml"));
		transformer.transform(source, result);
		}
		catch(ParserConfigurationException  pe) {
			pe.printStackTrace();
	    }catch(TransformerException te) {
			te.printStackTrace();
		}

	}
}
