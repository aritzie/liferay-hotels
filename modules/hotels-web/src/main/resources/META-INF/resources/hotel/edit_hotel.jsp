<%@ include file="../init.jsp"%>
<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.hotel-service-error" arguments="<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>" />	
</liferay-ui:error>
<liferay-ui:error key="emailInvalid" message="error.email-invalid" />
<portlet:actionURL var="hotelActionUrl" name="/hotels/hotel/add">
	<portlet:param name="redirect" value="${redirect}" />
</portlet:actionURL>
<h1>
	<c:choose>
		<c:when test="${hotelId==0}">
			<liferay-ui:message key="hotel.add"></liferay-ui:message>
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="hotel.edit"></liferay-ui:message>
		</c:otherwise>
	</c:choose>
</h1>
<aui:model-context bean="${hotel}" model="${hotelClass}" />
<aui:form action="<%=hotelActionUrl %>" name="fm">
	<aui:input name="hotelId" field="hotelId" type="hidden" />
		<aui:fieldset>
			<aui:input name="name" label="hotel.label.name">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
			</aui:input>
			<aui:input name="email" label="hotel.label.email">
				<aui:validator name="required" />
				<aui:validator name="email" />
			</aui:input>
			<aui:input name="address" label="hotel.label.address">
				<aui:validator name="required" />
			</aui:input>
			<aui:input name="location" label="hotel.label.location">
				<aui:validator name="required" />
			</aui:input>
			<aui:input type="date" name="foundationDate" label="hotel.label.foundationDate">
				<aui:validator name="required" />
			</aui:input>
		</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button type="cancel" onClick="${redirect}"/>
	</aui:button-row>
	
</aui:form>