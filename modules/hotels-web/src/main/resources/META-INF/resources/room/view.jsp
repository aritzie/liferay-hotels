<%@ include file="../init.jsp" %>

<div class="container-fluid-1280">
	<h1>
		${hotel.name}
	</h1>
	<clay:management-toolbar
		disabled="${roomCount > 0}"
		displayContext="${roomManagementToolbarDisplayContext}"
		itemsTotal="${roomCount}"
		searchContainerId="roomEntries"
		selectable="false"
	/>
	<liferay-ui:search-container 
		emptyResultsMessage="no-rooms"
		id="roomEntries"
		iteratorURL="${portletURL}"
		total="${roomCount}"
	>
		<liferay-ui:search-container-results 
			results="${rooms}" 
		/>
		<liferay-ui:search-container-row 
			className="com.hiberus.hotels.model.Room"
			modelVar="room"
		>
			<%@ include file="/room/entry_search_columns.jspf"%>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator
				displayStyle="${roomManagementToolbarDisplayContext.getDisplayStyle()}"
				markupView="lexicon" />
	</liferay-ui:search-container>
	
</div>