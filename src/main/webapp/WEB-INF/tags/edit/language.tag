<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="index" required="true" type="java.lang.Object" %>
<%@ attribute name="language" required="false" type="ikvych.resume.entity.Language" %>


<div id="edit-item-${index}" class="card-body border edit-item" style="margin-bottom: 1em">
    <input name="items[${index }].id" value="${language.id}" type="hidden">
    <div class="row float-right">
        <button type="button" class="close" onclick="$('#edit-item-${index }').remove();">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>


    <div class="form-row">
        <div class="col-md-6 form-group">
            <label for="items${index }type">Тип</label>
            <select name="items[${index }].type" class="form-control p-0">
                <c:forEach var="languageType" items="${languageTypes }">
                    <option value="${languageType.dbValue }" ${languageType == language.type ? 'selected="selected"' : '' }>
                        <spring:message code="LanguageType.${languageType}"/>
                    </option>
                </c:forEach>
            </select>
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index}].type" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="col-md-6 form-group">
            <label class="control-label" for="items${index }name">Язык</label>
            <input class="form-control" name="items[${index }].name" id="items${index }name"
                   placeholder="Example: English" value="${language.name }" required="required">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index}].name" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>
    <div class="form-row d-none d-md-block">
        <div class="col form-group">
            <label for="items${index }level">Уровень</label>
            <div style="padding: 0 30px;">
                <resume:language-slider index="${index }"
                                        value="${language != null ? language.level.sliderIntValue : 4}"/>
            </div>
        </div>
        <div class="row d-none d-md-block">
            <div class="col-12">
                <form:errors path="items[${index}].level" cssClass="alert alert-danger" element="div"/>
            </div>
        </div>
    </div>
    <div class="form-row d-md-none">
        <div class="col form-group">
            <label for="items${index }level">Уровень</label>
            <select name="items[${index }].sliderIntValue" class="form-control p-0">
                <c:forEach var="languageLevel" items="${languageLevels }">
                    <option value="${languageLevel.dbValue }" ${languageLevel == language.level ? 'selected="selected"' : '' }>
                            ${languageLevel.getCaption() }
                    </option>
                </c:forEach>
            </select>
            <div class="row d-md-none">
                <div class="col-12">
                    <form:errors path="items[${index}].level" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>


</div>