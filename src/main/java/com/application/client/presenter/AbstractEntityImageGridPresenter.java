package com.application.client.presenter;

import java.util.List;

import com.application.client.component.ImageContainer;
import com.application.client.component.dialog.AbstractEntityObjectView;
import com.application.client.constant.HtmlConstants;
import com.application.server.data.entity.AbstractEntity;
import com.application.server.service.AbstractCrudService;

import utils.CastUtils;

public abstract class AbstractEntityImageGridPresenter<T extends AbstractEntity> extends AbstractImageGridPresenter<T> {

	public interface AbstractEntityImageGridDisplay<T> extends AbstractImageGridDisplay<T> {

		List<ImageContainer> getImageContainerList();

	}

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	protected AbstractEntityObjectView<T> entityObjectView;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractEntityImageGridPresenter(AbstractCrudService<T> service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public AbstractEntityImageGridDisplay<T> getView() {
		return CastUtils.uncheckedCast(super.getView());
	}

	@Override
	public void bind() {
		super.bind();

		this.bindImageContainers();
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	protected abstract AbstractEntityObjectView<T> createEntityObjectView();

	protected void bindImageContainers() {
		this.getView().getImageContainerList().stream()
				.forEach(imageContainer -> this.bindImageContainer(imageContainer));
	}

	protected void bindImageContainer(ImageContainer imageContainer) {
		String dataName = imageContainer.getElement().getAttribute(HtmlConstants.HTML_ATTRIBUTE_KEY_NAME);
		imageContainer.getElement().addEventListener("click", event -> this.manageOpenObjectView(dataName));
	}

	protected AbstractEntityObjectView<T> getEntityObjectView() {
		if (this.entityObjectView == null) {
			this.entityObjectView = this.createEntityObjectView();
		}

		return this.entityObjectView;
	}

	private void manageOpenObjectView(String dataName) {
		T datum = this.getView().getData().stream().filter(p -> p.getName().equals(dataName)).findFirst().orElse(null);
		if (datum != null) {
			this.getEntityObjectView().setData(datum);
			this.getEntityObjectView().open();
		}
	}

}
