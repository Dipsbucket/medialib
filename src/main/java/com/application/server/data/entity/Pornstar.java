package com.application.server.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pornstar")
public class Pornstar extends AbstractEntity {

	public enum PornstarStatus {
		MAID, BENVENIDA, SEX_ADDICTED_MAID_TEACHER, NEOPHYTE;
	}

	public enum PornstarEthnicity {
		ASIAN, LATINA, BLACK, COCASIAN, EASTERN, INDIAN, ARAB, OTHER;
	}

	public enum PornstarType {
		BOOBS, TEEN, MILF, BLOND, BRUNETTE, RED, EMO, ASS, PERFECTION;
	}

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "PORNSTAR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "PORNSTAR_NAME")
	private String name;

	@Column(name = "PORNSTAR_STATUS", columnDefinition = "ENUM('MAID','BENVENIDA','SEX_ADDICTED_MAID_TEACHER','NEOPHYTE')")
	@Enumerated(EnumType.STRING)
	private PornstarStatus status;

	@Column(name = "PORNSTAR_ETHNICITY", columnDefinition = "ENUM('ASIAN','LATINA','BLACK','COCASIAN','EASTERN','INDIAN','ARAB','OTHER')")
	@Enumerated(EnumType.STRING)
	private PornstarEthnicity ethnicity;

	@Column(name = "PORNSTAR_TYPE")
	private String type;

	@Column(name = "PORNSTAR_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public Pornstar() {
	}

	public Pornstar(String name, PornstarStatus status, PornstarEthnicity ethnicity, String type, String imagePath) {
		this.name = name;
		this.status = status;
		this.ethnicity = ethnicity;
		this.type = type;
		this.imagePath = imagePath;
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPath() {
		return this.imagePath;
	}

	@Override
	public void setPath(String path) {
		this.imagePath = path;
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	public String getDisplayValue() {
		return this.getName();
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public PornstarStatus getStatus() {
		return this.status;
	}

	public void setStatus(PornstarStatus status) {
		this.status = status;
	}

	public PornstarEthnicity getEthnicity() {
		return this.ethnicity;
	}

	public void setEthnicity(PornstarEthnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
