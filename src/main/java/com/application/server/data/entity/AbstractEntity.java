package com.application.server.data.entity;

import interfaces.HasId;
import interfaces.HasName;
import interfaces.HasPath;

public abstract class AbstractEntity implements HasId<Integer>, HasName, HasPath {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractEntity() {
	}

}
