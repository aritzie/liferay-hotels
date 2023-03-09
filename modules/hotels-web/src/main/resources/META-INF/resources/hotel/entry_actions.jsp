<%@ include file="../init.jsp"%>
<c:set var="hotel" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">
	
	<%-- View action. --%>
		<portlet:renderURL var="viewHotelURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandsNames.VIEW_HOTEL%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="hotelId" value="${hotel.hotelId}" />
		</portlet:renderURL>
		<liferay-ui:icon image="view" url="${viewHotelURL}" />

	
	<%-- Edit action. --%>
		<portlet:renderURL var="editHotelURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandsNames.EDIT_HOTEL%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="hotelId" value="${hotel.hotelId}" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="${editHotelURL}" />

	<%-- Permissions action. --%> 
	<%-- <c:if  test="${hotelModelPermission.contains(permissionChecker, hotel.hotelId, 'PERMISSIONS')}">  
		<liferay-security:permissionsURL
			modelResource="com.hiberus.livingstone.hotel.sb.model.Hotel"
			modelResourceDescription="${hotel.name}"
			resourcePrimKey="${hotel.hotelId}" 
			var="permissionsURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"/>
		<liferay-ui:icon image="permissions" method="get" url="${permissionsURL}" useDialog="true" />
 	</c:if>  --%> 
	
	<%-- Delete action. --%>
		<portlet:actionURL name="<%=MVCCommandsNames.DELETE_HOTEL%>"
			var="deleteHotelURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="hotelId" value="${hotel.hotelId}" />
		</portlet:actionURL>
		<liferay-ui:icon-delete image="delete" url="${deleteHotelURL}" />
</liferay-ui:icon-menu>