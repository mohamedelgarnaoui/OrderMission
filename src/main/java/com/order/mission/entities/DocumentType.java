package com.order.mission.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DocumentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;
	private String typeDocument;
	@OneToMany
	private Collection<JustificationDocument> justificationDocument;

	public DocumentType() {
		super();
	}

	public DocumentType(int idType, String typeDocument) {
		super();
		this.idType = idType;
		this.typeDocument = typeDocument;
	}

	public DocumentType(String typeDocument) {
		super();
		this.typeDocument = typeDocument;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public Collection<JustificationDocument> getJustificationDocument() {
		return justificationDocument;
	}

	public void setJustificationDocument(Collection<JustificationDocument> justificationDocument) {
		this.justificationDocument = justificationDocument;
	}


}