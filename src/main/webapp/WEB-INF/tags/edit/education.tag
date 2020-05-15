<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags" %>

<%@ attribute name="index" required="true" type="java.lang.Object" %>
<%@ attribute name="education" required="false" type="ikvych.resume.entity.Education" %>

<div id="edit-item-${index}" class="card-body border edit-item" style="margin-bottom: 1em">
    <input name="items[${index}].id" value="${education.id}" type="hidden"/>
    <div class="row float-right">
        <button type="button" class="close" onclick="$('#edit-item-${index }').remove();">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputUniversity">University</label>
            <input name="items[${index}].university" value="${education.university}" type="text" class="form-control"
                   id="inputUniversity">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index}].university" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="inputFaculty">Faculty</label>
            <input name="items[${index}].faculty" value="${education.faculty}" type="text" class="form-control"
                   id="inputFaculty">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].faculty" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputBeginYear">Begin year</label>
            <select name="items[${index }].beginYear" class="form-control" id="inputBeginYear">
                <c:forEach var="year" items="${years}">
                    <option value="${year}" ${year == education.beginYear ? 'selected="selected"' : '' }>${year}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label for="inputFinishYear">Finish year</label>
            <select name="items[${index }].finishYear" class="form-control" id="inputFinishYear">
                <c:forEach var="year" items="${years}">
                    <option value="${year}" ${year == education.finishYear ? 'selected="selected"' : '' }>${year}</option>
                </c:forEach>
            </select>
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].finishYear" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>


    <div class="form-row">
        <div class="form-group col-md-12">
            <label for="inputPosition">Specialty developed</label>
            <textarea name="items[${index}].summary" rows="3" type="text" class="form-control"
                      id="inputPosition">${education.summary}</textarea>
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].summary" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>
</div>
