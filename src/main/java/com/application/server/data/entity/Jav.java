package com.application.server.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.CastUtils;

@Entity
@Table(name = "jav")
public class Jav extends AbstractEntity {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "JAV_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "JAV_NAME")
	private String name;

	@Column(name = "JAV_IDOLS")
	private String idols;

	@Column(name = "JAV_WATCHED")
	private Integer watched;

	@Column(name = "JAV_OWNED")
	private Integer owned;

	@Column(name = "JAV_LINK")
	private String link;

	@Column(name = "JAV_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public Jav() {
	}

	public Jav(String name, String idols, Integer watched, Integer owned, String link, String imagePath) {
		this.name = name;
		this.idols = idols;
		this.watched = watched;
		this.owned = owned;
		this.link = link;
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

	public Boolean getWatchedAsBoolean() {
		return CastUtils.convertIntegerToBoolean(this.getWatched());
	}

	public Boolean getOwnedAsBoolean() {
		return CastUtils.convertIntegerToBoolean(this.getOwned());
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public String getIdols() {
		return this.idols;
	}

	public void setIdols(String idols) {
		this.idols = idols;
	}

	public Integer getWatched() {
		return this.watched;
	}

	public void setWatched(Integer watched) {
		this.watched = watched;
	}

	public Integer getOwned() {
		return this.owned;
	}

	public void setOwned(Integer owned) {
		this.owned = owned;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
