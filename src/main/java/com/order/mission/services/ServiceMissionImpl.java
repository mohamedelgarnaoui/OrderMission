package com.order.mission.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.order.mission.dao.IDaoMission;
import com.order.mission.entities.DetailMission;
import com.order.mission.entities.DocumentType;
import com.order.mission.entities.JustificationDocument;
import com.order.mission.entities.Mission;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;

@Transactional
public class ServiceMissionImpl implements IServiceMission {

	IDaoMission dao;
	
	@Autowired
	ServletContext context;
	
	@Value("#{myProps['uploadFolder']}")
	String UPLOAD_DIRECTORY;


	public void setDao(IDaoMission dao) {
		this.dao = dao;
	}

	@Override
	public Mission AddMission(Mission m) {
		return dao.AddMission(m);
	}

	@Override
	public Mission deleteMission(int idMission) {
		return dao.deleteMission(idMission);
	}

	@Override
	public Mission updateMission(Mission m) {
		return dao.updateMission(m);
	}

	@Override
	public Mission getMission(int idMission) {
		return dao.getMission(idMission);
	}

	@Override
	public List<Mission> getAllMission() {
		return dao.getAllMission();
	}

	@Override
	public DocumentType AddDocumentType(DocumentType dt) {
		return dao.AddDocumentType(dt);
	}

	@Override
	public DocumentType deleteDocumentType(int idDocumentType) {
		return dao.deleteDocumentType(idDocumentType);
	}

	@Override
	public DocumentType updateDocumentType(DocumentType dt) {
		return dao.updateDocumentType(dt);
	}

	@Override
	public DocumentType getDocumentType(int idDocumentType) {
		return dao.getDocumentType(idDocumentType);
	}

	@Override
	public List<DocumentType> getAllDocumentType() {
		return dao.getAllDocumentType();
	}

	@Override
	public JustificationDocument AddJustificationDocument(JustificationDocument jd) {
		return dao.AddJustificationDocument(jd);
	}

	@Override
	public JustificationDocument deleteJustificationDocument(int idJustificationDocument) {
		return dao.deleteJustificationDocument(idJustificationDocument);
	}

	@Override
	public JustificationDocument updateJustificationDocument(JustificationDocument jd) {
		return dao.updateJustificationDocument(jd);
	}

	@Override
	public JustificationDocument getJustificationDocument(int idJustificationDocument) {
		return dao.getJustificationDocument(idJustificationDocument);
	}

	@Override
	public List<JustificationDocument> getAllJustificationDocument() {
		return dao.getAllJustificationDocument();
	}

	@Override
	public DetailMission AddDetailMission(DetailMission dm) {
		return dao.AddDetailMission(dm);
	}

	@Override
	public DetailMission deleteDetailMission(int idDetailMission) {
		return dao.deleteDetailMission(idDetailMission);
	}

	@Override
	public DetailMission updateDetailMission(DetailMission dm) {
		return dao.updateDetailMission(dm);
	}

	@Override
	public DetailMission getDetailMission(int idDetailMission) {
		return dao.getDetailMission(idDetailMission);
	}

	@Override
	public List<DetailMission> getAllDetailMission() {
		return dao.getAllDetailMission();
	}

	@Override
	public Transport AddTransport(Transport t) {
		return dao.AddTransport(t);
	}

	@Override
	public Transport deleteTransport(int idTransport) {
		return dao.deleteTransport(idTransport);
	}

	@Override
	public Transport updateTransport(Transport t) {
		return dao.updateTransport(t);
	}

	@Override
	public Transport getTransport(int idTransport) {
		return dao.getTransport(idTransport);
	}

	@Override
	public List<Transport> getAllTransport() {
		return dao.getAllTransport();
	}

	@Override
	public State AddState(State s) {
		return dao.AddState(s);
	}

	@Override
	public State deleteState(int idState) {
		return dao.deleteState(idState);
	}

	@Override
	public State updateState(State s) {
		return dao.updateState(s);
	}

	@Override
	public State getState(int idState) {
		return dao.getState(idState);
	}

	@Override
	public List<State> getAllState() {
		return dao.getAllState();
	}

	@Override
	public List<Mission> getAllMissionByDep(int idDep) {
		return dao.getAllMisssionByDepartement(idDep);
	}

	@Override
	public List<Transport> getAllTransportByMission(int idMission) {
		return dao.getAllTransportByMission(idMission);
	}

	@Override
	public State getStatByMission(int idMission) {
		return dao.getStatByMission(idMission);
	}

	@Override
	public DetailMission detailmissionByMission(int idMission) {
		return dao.detailmissionByMission(idMission);
	}

	@Override
	public List<JustificationDocument> getJustificationDocByMission(int idMission) {
		return dao.getJustificationDocByMission(idMission);
	}

	@Override
	public List<Mission> getAllMissionByDepByState(int idDep, int idState) {
		return dao.getAllMissionByDepByState(idDep, idState);
	}

	@Override
	public List<Mission> getAllMissionByProfByState(int idProf, int idState) {
		return dao.getAllMissionByProfByState(idProf, idState);
	}

	@Override
	public List<Mission> getAllMissionByState(int idState) {
		return dao.getAllMissionByState(idState);
	}

	@Override
	public List<Mission> getAllMissionByProf(int idProfessor) {
		return dao.getAllMissionByProf(idProfessor);
	}

	@Override
	public void generatePDF(Mission m) throws DocumentException, IOException {
		String outputFilePath = "OrdreMission_Mr." + m.getProfessor().getLastName() + ".pdf"; // New file
		String fp = UPLOAD_DIRECTORY + "/ordremission.pdf";
		
		OutputStream fos = new FileOutputStream(new File(outputFilePath));
		PdfReader pdfReader = new PdfReader(fp);
		PdfStamper pdfStamper = new PdfStamper(pdfReader, fos);
		String test1 [] = m.getDepartureTime().toString().split(" ");
		String test2 [] = m.getReturnTime().toString().split(" ");

		//getOverContent() allows you to write content on TOP of existing pdf content.
		//getUnderContent() allows you to write content on BELOW of existing pdf content.
		PdfContentByte pdfContentByte = pdfStamper.getOverContent(1);
		
		Collection<Transport> mtrs = getAllTransportByMission(m.getIdMission());
		String trs = "";
		for (Transport transport : mtrs) {
			trs += transport.getTypeTransport() + ", ";
		}
		trs = trs.substring(0,trs.lastIndexOf(","));
		System.out.println(trs);
		addingTextToPdf(m.getIdMission()+"", 296, 700, pdfContentByte);
		addingTextToPdf(m.getProfessor().getFirstName()+" "+m.getProfessor().getLastName(), 130, 428, pdfContentByte);//35, 760
		addingTextToPdf(m.getSubject(), 130, 384, pdfContentByte);//35, 760
		addingTextToPdf(trs, 130, 365, pdfContentByte);//35, 760
		
		addingTextToPdf(test1[0], 100, 320, pdfContentByte);//35, 760
		addingTextToPdf(test1[1], 330, 324, pdfContentByte);//35, 760
		
		addingTextToPdf(m.getDestination().getName().toString(), 170, 405, pdfContentByte);//35, 760
		
		addingTextToPdf(test2[0], 100, 299, pdfContentByte);//35, 760
		addingTextToPdf(test2[1], 330, 303, pdfContentByte);
		pdfStamper.close(); //close pdfStamper
	}

	public void addingTextToPdf(String txt, int x, int y, PdfContentByte pdfContentByte) throws DocumentException, IOException {

		Font f1 = FontFactory.getFont(FontFactory.COURIER, 20);
		f1.setColor(BaseColor.LIGHT_GRAY);

		
		// Add text in existing PDF
		pdfContentByte.beginText();//Font name //Font encoding //Font embedded
		pdfContentByte.setFontAndSize(f1.getBaseFont(), 13); // set font and size
		pdfContentByte.setDefaultColorspace(PdfName.DEFAULTGRAY, PdfName.BACKGROUNDCOLOR);
		pdfContentByte.setTextMatrix(x, y); // set x and y co-ordinates

		//0, 800 will write text on TOP LEFT of pdf page
		//0, 0 will write text on BOTTOM LEFT of pdf page
		pdfContentByte.showText(txt); // add the text

		pdfContentByte.endText();
	}

}
