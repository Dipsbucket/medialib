package com.application.server.data.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import utils.CastUtils;

@Entity
@Table(name = "movie")
public class Movie extends AbstractEntity {

	public enum MovieGenre {
		ACTION, ADVENTURE, ANIMATION, BIOGRAPHY, COMEDY, CRIME, DRAMA, FAMILY, FANTASY, HISTORY, HORROR, MUSICAL,
		MYSTERY, ROMANCE, SCI_FI, SHORT, SPORT, THRILLER, WAR;
	}

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "MOVIE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "MOVIE_NAME")
	private String name;

	@Column(name = "MOVIE_NAME_EN")
	private String nameEn;

	@Column(name = "MOVIE_NAME_FR")
	private String nameFr;

	@Column(name = "MOVIE_RELEASE_DATE")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	@Column(name = "MOVIE_GENRES")
	private String genres;

	@Column(name = "MOVIE_RATING")
	private Float rating;

	@Column(name = "MOVIE_WATCHED")
	private Integer watched;

	@Column(name = "MOVIE_OWNED")
	private Integer owned;

	@Column(name = "MOVIE_LIKED")
	private Integer liked;

	@Column(name = "MOVIE_LINK")
	private String link;

	@Column(name = "MOVIE_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public Movie() {
	}

	public Movie(String name, String nameEn, String nameFr, Date releaseDate, String genres, Float rating,
			Integer watched, Integer owned, Integer liked, String link, String imagePath) {
		this.name = name;
		this.nameEn = nameEn;
		this.nameFr = nameFr;
		this.releaseDate = releaseDate;
		this.genres = genres;
		this.rating = rating;
		this.watched = watched;
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
		return this.getImagePath();
	}

	@Override
	public void setPath(String path) {
		// Non Implémenté
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	public String getDisplayValue() {
		return this.getNameEn();
	}

	public LocalDate getReleaseDateAsLocalDate() {
		return CastUtils.convertDateToLocalDate(this.getReleaseDate());
	}

	public Double getRatingAsDouble() {
		return CastUtils.convertFloatToDouble(this.getRating());
	}

	public Boolean getWatchedAsBoolean() {
		return CastUtils.convertIntegerToBoolean(this.getWatched());
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

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenres() {
		return this.genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
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
