package com.order.mission.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class JustificationDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocument;
	private String document;
	private String comment;
	@ManyToOne
	private DocumentType documentType;
	@ManyToOne
	private Mission mission;

	public JustificationDocument() {
		super();
	}

	public JustificationDocument(int idDocument, String document, String comment) {
		super();
		this.idDocument = idDocument;
		this.document = document;
		this.comment = comment;
	}

	public JustificationDocument(String document, String comment) {
		super();
		this.document = document;
		this.comment = comment;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}