package com.application.server.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.CastUtils;

@Entity
@Table(name = "tv_show")
public class TvShow extends AbstractEntity {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "TV_SHOW_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TV_SHOW_NAME")
	private String name;

	@Column(name = "TV_SHOW_NAME_EN")
	private String nameEn;

	@Column(name = "TV_SHOW_NAME_FR")
	private String nameFr;

	@Column(name = "TV_SHOW_RATING")
	private Float rating;

	@Column(name = "TV_SHOW_RUNNING")
	private Integer running;

	@Column(name = "TV_SHOW_SEASON_COUNT")
	private Integer seasonCount;

	@Column(name = "TV_SHOW_OWNED")
	private Integer owned;

	@Column(name = "TV_SHOW_LIKED")
	private Integer liked;

	@Column(name = "TV_SHOW_LINK")
	private String link;

	@Column(name = "TV_SHOW_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public TvShow() {
	}

	public TvShow(String name, String nameEn, String nameFr, Float rating, Integer running, Integer seasonCount,
			Integer owned, Integer liked, String link, String imagePath) {
		this.name = name;
		this.nameEn = nameEn;
		this.nameFr = nameFr;
		this.rating = rating;
		this.running = running;
		this.seasonCount = seasonCount;
		this.owned = owned;
		this.liked = liked;
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
		return this.getNameEn();
	}

	public Double getRatingAsDouble() {
		return CastUtils.convertFloatToDouble(this.getRating());
	}

	public Boolean getOwnedAsBoolean() {
		return CastUtils.convertIntegerToBoolean(this.getOwned());
	}

	public Boolean getLikedAsBoolean() {
		return CastUtils.convertIntegerToBoolean(this.getLiked());
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

	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Integer getRunning() {
		return this.running;
	}

	public void setRunning(Integer running) {
		this.running = running;
	}

	public Integer getSeasonCount() {
		return this.seasonCount;
	}

	public void setSeasonCount(Integer seasonCount) {
		this.seasonCount = seasonCount;
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
