<%@ include file="../init.jsp"%>
<c:set var="room" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">
	
	<%-- View action. --%>
	<%--
		<portlet:renderURL var="viewRoomURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandsNames.VIEW_ROOM%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="hotelId" value="${room.roomId}" />
		</portlet:renderURL>
		<liferay-ui:icon image="view" url="${viewRoomURL}" />
	--%>
	
	<%-- Edit action. --%>
		<portlet:renderURL var="editRoomURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandsNames.EDIT_ROOM%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="roomId" value="${room.roomId}" />
			<portlet:param name="hotelId" value="${hotel.hotelId}" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="${editRoomURL}" />

	<%-- Permissions action. --%> 
	<%-- <c:if  test="${hotelModelPermission.contains(permissionChecker, hotel.hotelId, 'PERMISSIONS')}">  
		<liferay-security:permissionsURL
			modelResource="com.hiberus.hotels.model.Hotel"
			modelResourceDescription="${hotel.name}"
			resourcePrimKey="${hotel.hotelId}" 
			var="permissionsURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"/>
		<liferay-ui:icon image="permissions" method="get" url="${permissionsURL}" useDialog="true" />
 	</c:if>  --%> 
	
	<%-- Delete action. --%>
		<portlet:actionURL name="<%=MVCCommandsNames.DELETE_ROOM%>" var="deleteRoomURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="roomId" value="${room.roomId}" />
		</portlet:actionURL>
		<liferay-ui:icon-delete image="delete" url="${deleteRoomURL}" />
</liferay-ui:icon-menu>