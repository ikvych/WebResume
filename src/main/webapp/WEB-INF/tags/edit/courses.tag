<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="course" required="false" type="ikvych.resume.entity.Course"%>

<div class="card-body border" style="margin-bottom: 1em">
    <input name="items[${index}].id" value="${course.id}" type="hidden"/>
    <div class="row float-right">
        <button type="button" class="close" onclick="$('#ui-item-${index }').remove();">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputCourse">Course name</label>
            <input name="items[${index}].name" value="${course.name}" type="text" class="form-control" id="inputCourse">
<%--            <div class="row " >
                <div class="col-12">
                    <form:errors path="items[${index }].name" cssClass="alert alert-danger" element="div" />
                </div>
            </div>--%>
        </div>
        <div class="form-group col-md-4">
            <label for="inputCompany">Name of school/platform</label>
            <input name="items[${index}].organization" value="${course.organization}" type="text" class="form-control" id="inputCompany">
<%--            <div class="row " >
                <div class="col-12">
                    <form:errors path="items[${index }].school" cssClass="alert alert-danger" element="div" />
                </div>
            </div>--%>
        </div>
        <div class="form-group col-md-2">
            <label <%--for="inputFinishYear"--%>>Finish year</label>
<%--            <select name="items[${index }].finishDateYear" class="form-control" id="inputFinishYear">
                <c:forEach var="year" items="${years}">
                    <option value="${year}" ${year == course.finishDateYear ? 'selected="selected"' : '' }>${year}</option>
                </c:forEach>
            </select>--%>
        </div>
        <div class="form-group col-md-2">
            <label <%--for="inputFinishMonth"--%>>Finish month</label>
<%--            <select name="items[${index }].finishDateMonth" class="form-control" id="inputFinishMonth">
                <c:forEach var="month" items="${months}">
                    <option value="${month.key }" ${month.key == course.finishDateMonth ? 'selected="selected"' : '' }>${month.value }</option>
                </c:forEach>
            </select>--%>
        </div>
    </div>

</div>