import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-select';
import { html, LitElement } from 'lit';
import { customElement } from 'lit/decorators';

@customElement('jav-image-container')
export class JavImageContainer extends LitElement {

	createRenderRoot() {
		// Do not use a shadow root
		return this;
	}

	render() {
	return html `
		<li class="bg-contrast-5 flex flex-col items-start p-m rounded-l">
			<div class="bg-contrast flex items-center justify-center mb-m overflow-hidden rounded-m w-full" style="height: 300px;">
				<img id="image" class="w-full" />
			</div>
			<span class="text-xl font-semibold" id="header" style="width: 100%; text-align: center;"></span>
		</li> 
	`;
	}
  
}
