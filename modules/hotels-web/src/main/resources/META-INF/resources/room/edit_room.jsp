<%@ include file="../init.jsp"%>
<portlet:actionURL var="roomActionUrl" name="/hotels/room/add">
	<portlet:param name="redirect" value="${redirect}" />
</portlet:actionURL>
<h1>
	<c:choose>
		<c:when test="${roomId==0}">
			<liferay-ui:message key="room.add"></liferay-ui:message>
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="room.edit"></liferay-ui:message>
		</c:otherwise>
	</c:choose>
</h1>
<aui:model-context bean="${room}" model="${roomClass}" />
<aui:form action="<%=roomActionUrl %>" name="fm">
	<aui:input name="roomId" field="roomId" type="hidden" />
	<aui:input name="hotelId" type="hidden" value="${hotelId}"/>
		<aui:fieldset>
			<aui:input name="number" label="room.label.number">
				<aui:validator name="required" />	
			</aui:input>
			<aui:input name="type" label="room.label.type">
				<aui:validator name="required" />					
			</aui:input>
			<aui:input name="size" label="room.label.size">
				<aui:validator name="required" />
			</aui:input>
			<aui:input name="price" label="room.label.price">
				<aui:validator name="required" />
			</aui:input>
		</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button type="cancel" onClick="${redirect}"/>
	</aui:button-row>
	
</aui:form>