package com.application.client.presenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.server.service.AbstractCrudService;
import com.vaadin.flow.component.HasComponents;

public abstract class AbstractImageGridPresenter<T> {

	public interface AbstractImageGridDisplay<T> extends HasComponents {

		List<T> getData();

		void setData(List<T> data);

		void buildComponents();

		String getContext();

		String getStyleClassName();

	}

	// ***********************************************************************************************************
	// Section de code : Variable
	// ***********************************************************************************************************

	protected AbstractImageGridDisplay<T> view;
	protected AbstractCrudService<T> service;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractImageGridPresenter(@Autowired AbstractCrudService<T> service) {
		this.service = service;
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	protected List<T> loadData() {
		return this.service.findAll();
	}

	public void initView(AbstractImageGridDisplay<T> view) {
		this.view = view;
		this.view.setData(this.loadData());
		this.view.buildComponents();
		this.bind();
	}

	public void bind() {

	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public AbstractImageGridDisplay<T> getView() {
		return this.view;
	}

	public AbstractCrudService<T> getService() {
		return this.service;
	}

}
