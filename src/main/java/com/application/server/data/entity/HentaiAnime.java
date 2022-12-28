package com.application.server.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.CastUtils;

@Entity
@Table(name = "hentai_anime")
public class HentaiAnime extends AbstractEntity {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "HENTAI_ANIME_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "HENTAI_ANIME_NAME")
	private String name;

	@Column(name = "HENTAI_ANIME_NAME_EN")
	private String nameEn;

	@Column(name = "HENTAI_ANIME_EPISODE_COUNT")
	private Integer episodeCount;

	@Column(name = "HENTAI_ANIME_RUNNING")
	private Integer running;

	@Column(name = "HENTAI_ANIME_WATCHED")
	private Integer watched;

	@Column(name = "HENTAI_ANIME_OWNED")
	private Integer owned;

	@Column(name = "HENTAI_ANIME_LINK")
	private String link;

	@Column(name = "HENTAI_ANIME_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiAnime() {
	}

	public HentaiAnime(String name, String nameEn, Integer episodeCount, Integer running, Integer watched,
			Integer owned, String link, String imagePath) {
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

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	public String getDisplayValue() {
		return this.getNameEn();
	}

	public Boolean getRunningAsBoolean() {
		return CastUtils.convertIntegerToBoolean(this.getRunning());
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
