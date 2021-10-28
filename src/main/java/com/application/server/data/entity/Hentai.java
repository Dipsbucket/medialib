package com.application.server.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hentai")
public class Hentai extends AbstractEntity {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "HENTAI_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "HENTAI_NAME")
	private String name;

	@Column(name = "HENTAI_NAME_EN")
	private String nameEn;

	@Column(name = "HENTAI_EPISODE_COUNT")
	private Integer episodeCount;

	@Column(name = "HENTAI_RUNNING")
	private Integer running;

	@Column(name = "HENTAI_WATCHED")
	private Integer watched;

	@Column(name = "HENTAI_OWNED")
	private Integer owned;

	@Column(name = "HENTAI_LINK")
	private String link;

	@Column(name = "HENTAI_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public Hentai() {
	}

	public Hentai(String name, String nameEn, Integer episodeCount, Integer running, Integer watched, Integer owned,
			Integer liked, String link, String imagePath) {
		this.name = name;
		this.nameEn = nameEn;
		this.episodeCount = episodeCount;
		this.running = running;
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

	public Integer getEpisodeCount() {
		return this.episodeCount;
	}

	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	public Integer getRunning() {
		return this.running;
	}

	public void setRunning(Integer running) {
		this.running = running;
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

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
