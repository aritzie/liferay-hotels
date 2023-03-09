<%@ include file="../init.jsp" %>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.hotel-service-error" />
</liferay-ui:error>
<liferay-ui:success key="hotelAdded" message="hotel-added-successfully" />
<liferay-ui:success key="hotelUpdated" message="hotel-updated-successfully" />
<liferay-ui:success key="hotelDeleted" message="hotel-deleted-successfully" />

<div class="container-fluid-1280">
	<h1>
		<liferay-:message key="Hotels" />
	</h1>
	<clay:management-toolbar
		disabled="${hotelCount > 0}"
		displayContext="${hotelManagementToolbarDisplayContext}"
		itemsTotal="${hotelCount}"
		searchContainerId="hotelEntries"
		selectable="false"
	/>
	<liferay-ui:search-container 
		emptyResultsMessage="no-hotel"
		id="hotelEntries"
		iteratorURL="${portletURL}"
		total="${hotelCount}"
	>
		<liferay-ui:search-container-results 
			results="${hotels}" 
		/>
		<liferay-ui:search-container-row 
			className="com.hiberus.hotels.model.Hotel"
			modelVar="hotel"
		>
			<%@ include file="/hotel/entry_search_columns.jspf"%>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator
				displayStyle="${hotelManagementToolbarDisplayContext.getDisplayStyle()}"
				markupView="lexicon" />
	</liferay-ui:search-container>
	
</div>