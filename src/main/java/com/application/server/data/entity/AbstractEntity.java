package com.application.server.data.entity;

import interfaces.HasDisplayValue;
import interfaces.HasId;
import interfaces.HasName;
import interfaces.HasPath;

public abstract class AbstractEntity implements HasId<Integer>, HasName, HasPath, HasDisplayValue<String> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractEntity() {
	}

}
