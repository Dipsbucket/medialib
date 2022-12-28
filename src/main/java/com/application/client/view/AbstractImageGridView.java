package com.application.client.view;

import java.util.List;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.AbstractImageGridPresenter.AbstractImageGridDisplay;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.template.Id;

public abstract class AbstractImageGridView<T> extends LitTemplate implements AbstractImageGridDisplay<T> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -588240749202274449L;

	protected List<T> data;

	@Id
	protected Select<String> sortBy;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractImageGridView() {
		this.addClassNames(this.getStyleClassName(), StyleConstants.CSS_CLASS_DISPLAY_BLOCK,
				StyleConstants.CSS_CLASS_SIZING_FULL_PARENT_HEIGHT);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public List<T> getData() {
		return this.data;
	}

	@Override
	public void setData(List<T> data) {
		this.data = data;
	}

}
