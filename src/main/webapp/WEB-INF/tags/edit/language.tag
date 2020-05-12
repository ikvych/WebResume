<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="index"    required="true"  type="java.lang.Object"%>
<%@ attribute name="language"       required="false" type="ikvych.resume.entity.Language"%>


<div class="card-body border" style="margin-bottom: 1em">
    <input name="items[${index }].id" value="${language.id}" type="hidden">
    <div class="form-row ">
        <div class="form-group col-md-2">
            <label for="items${index }type">Type</label>
<%--            <select name="items[${index }].type" class="form-control" id="items${index }type">
                <c:forEach var="languageType" items="${languageTypes}">
                    <option value="${languageType.dbValue }" ${languageType == language.type ? 'selected="selected"' : '' }>
                            ${languageType.dbValue}
                    </option>
                </c:forEach>
            </select>--%>
        </div>
        <div class="form-group col-md-2">
            <label class="control-label" for="items${index }name">Language</label>
            <input class="form-control" name="items[${index }].name" id="items${index }name" value="${language.name }" required="required">
<%--            <div class="row" >
                <div class="col-12">
                    <form:errors path="items[${index }].name" cssClass="alert alert-danger" element="div" />
                </div>
            </div>--%>
        </div>
        <div class="form-group col-md-8">
            <label for="items${index }level">Level</label>
            <div style="padding: 0 30px;">
                <form:input path="items[${index }].level"/>
                <%--                <resume:form-input-slider index="${index }" value="${language != null ? language.level.sliderIntValue : 4}" />--%>
            </div>
        </div>

    </div>


</div>