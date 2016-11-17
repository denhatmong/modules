package com.csc.xmltopdf.pdfoutput;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.pdf.PDFDocument;
import com.adobe.pdf.PDFFactory;

/**
 * This class is used to generate PDF use template and XML datasource
 * 
 * @version 1.0
 * @author CSC
 */
public class PDFGenerator {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

	/**
	 * This method is responsible for output PDF
	 * 
	 * @param template the Acrobate design template
	 * @param sourceFile the input xml file
	 * @param output the output xml
	 */
	public void print(String template, String sourceFile, String output) throws FileNotFoundException, IOException {

		PDFImport(template, sourceFile, output);
	}

	private static void PDFImport(String inPdfName, String XMLSourceFile, String outputFile)
	        throws FileNotFoundException, IOException {

		PDFDocument doc = null;
		// open the pdf template file
		FileInputStream inPdfFile = new FileInputStream(inPdfName);
		try {
			doc = PDFFactory.openDocument(inPdfFile);
		} catch (IOException e) {
			LOGGER.error("Error opening PDF file :" + inPdfName, e);
		}
		if (doc == null)
		    LOGGER.info("Cannot open PDF file : " + inPdfName);
		else
		    LOGGER.info(inPdfName + " was successfully opened.");
		boolean b = false;
		InputStream inputStream;
		// TODO open the XML data file and import the data into template
		String formDataFile = XMLSourceFile;
		FileInputStream fileInputStream = new FileInputStream(formDataFile);
		try {
			doc.importFormData(fileInputStream);
			LOGGER.info("\nForm data was imported from file " + formDataFile);
		} catch (Exception e) {
			LOGGER.error("\nError importing form Data.", e);
		}
		// save the file as an PDF file
		String outPDFName = outputFile;
		inputStream = doc.save();
		b = false;
		try {
			b = saveFile(inputStream, outPDFName);
		} catch (Exception e) {
			LOGGER.error("\nError saving PDF file.", e);
		}
		if (b == true)
			LOGGER.info("\nDocument was saved to file : " + outPDFName);
		else
			LOGGER.info("\nDocument was not saved to file.");
	}

	private static boolean saveFile(InputStream is, String filePath) throws Exception {
		boolean retVal = false;
		byte[] buffer = new byte[10240];
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(filePath);
			int len = 0;
			while (true) {
				len = is.read(buffer);
				if (len == -1)
					break;
				outStream.write(buffer, 0, len);
			}
			outStream.close();
			retVal = true;
		} catch (IOException io) {
			LOGGER.info(
			    "Writing the array of bytes into the file " + filePath + " failed in saveFile");
			throw new Exception("Writing the array of bytes into the file " + filePath + " failed in saveFile");
		}
		return retVal;
	}
}