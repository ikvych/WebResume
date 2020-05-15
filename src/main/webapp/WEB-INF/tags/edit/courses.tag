<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags" %>

<%@ attribute name="index" required="true" type="java.lang.Object" %>
<%@ attribute name="course" required="false" type="ikvych.resume.entity.Course" %>

<div id="edit-item-${index}" class="card-body border edit-item" style="margin-bottom: 1em">
    <input name="items[${index}].id" value="${course.id}" type="hidden"/>
    <div class="row float-right">
        <button type="button" class="close" onclick="$('#edit-item-${index }').remove();">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCourse">Course name</label>
            <input name="items[${index}].name" value="${course.name}" type="text" class="form-control" id="inputCourse">
            <div class="row ">
                <div class="col-12">
                    <form:errors path="items[${index }].name" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="inputCompany">Name of school/platform</label>
            <input name="items[${index}].organization" value="${course.organization}" type="text" class="form-control"
                   id="inputCompany">
            <div class="row ">
                <div class="col-12">
                    <form:errors path="items[${index }].organization" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="beginDate">Begin date</label>
            <input name="items[${index}].beginDate" value="${course.beginDate}" type="month" class="form-control"
                   id="beginDate"/>
            <form:errors path="items[${index }].beginDate" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group col-md-6">
            <label for="finishDate">Finish date</label>
            <input name="items[${index}].finishDate" value="${course.finishDate}" type="month" class="form-control"
                   id="finishDate"/>
            <form:errors path="items[${index }].finishDate" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <textarea name="items[${index}].description" type="text" class="form-control" id="description"
                  rows="3">${course.description}</textarea>
        <div class="row">
            <div class="col-12">
                <form:errors path="items[${index }].description" cssClass="alert alert-danger" element="div"/>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputDemo">Link to demo</label>
            <input name="items[${index}].demo" value="${course.demo}" type="text" class="form-control"
                   id="inputDemo">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].demo" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="inputSRC">SRC</label>
            <input name="items[${index}].src" value="${course.src}" type="text" class="form-control" id="inputSRC">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].src" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>

</div>