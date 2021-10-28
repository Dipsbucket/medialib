package com.application.client.presenter;

import com.application.server.data.entity.AbstractEntity;
import com.application.server.service.AbstractCrudService;

public abstract class AbstractEntityImageGridPresenter<T extends AbstractEntity> extends AbstractImageGridPresenter<T> {

	public interface AbstractEntityImageGridDisplay<T> extends AbstractImageGridDisplay<T> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractEntityImageGridPresenter(AbstractCrudService<T> service) {
		super(service);
	}

}
