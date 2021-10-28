package com.application.server.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "spectacle")
public class Spectacle extends AbstractEntity {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "SPECTACLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "SPECTACLE_NAME")
	private String name;

	@Column(name = "SPECTACLE_NAME_EN")
	private String nameEn;

	@Column(name = "SPECTACLE_NAME_FR")
	private String nameFr;

	@Column(name = "SPECTACLE_RELEASE_DATE")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	@Column(name = "SPECTACLE_RATING")
	private Float rating;

	@Column(name = "SPECTACLE_WATCHED")
	private Integer watched;

	@Column(name = "SPECTACLE_OWNED")
	private Integer owned;

	@Column(name = "SPECTACLE_LIKED")
	private Integer liked;

	@Column(name = "SPECTACLE_LINK")
	private String link;

	@Column(name = "SPECTACLE_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public Spectacle() {
	}

	public Spectacle(String name, String nameEn, String nameFr, Date releaseDate, Float rating, Integer watched,
			Integer owned, Integer liked, String link, String imagePath) {
		this.name = name;
		this.nameEn = nameEn;
		this.nameFr = nameFr;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.watched = watched;
		this.owned = owned;
		this.liked = liked;
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

	@Override
	public String getDisplayValue() {
		return this.nameEn;
	}

	@Override
	public void setDisplayValue(String value) {
		this.nameEn = value;
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameFr() {
		return this.nameFr;
	}

	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
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

	public Integer getLiked() {
		return this.liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
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
