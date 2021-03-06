<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="index" required="true" type="java.lang.Object" %>
<%@ attribute name="practical" required="false" type="ikvych.resume.entity.Practical" %>

<div id="edit-item-${index}" class="card-body border edit-item" style="margin-bottom: 1em">
    <input name="items[${index }].id" value="${practical.id}" type="hidden">
    <div class="row float-right">
        <button type="button" class="close" onclick="$('#edit-item-${index }').remove();">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputPosition">Position</label>
            <input name="items[${index}].position" value="${practical.position}" type="text" class="form-control"
                   id="inputPosition">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].position" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="inputCompany">Company or organization</label>
            <input name="items[${index}].company" value="${practical.company}" type="text" class="form-control"
                   id="inputCompany">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].company" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="beginDate">Begin date</label>
            <input name="items[${index}].beginDate" value="${practical.beginDate}" type="month" class="form-control"
                   id="beginDate"/>
            <form:errors path="items[${index }].beginDate" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group col-md-6">
            <label for="finishDate">Finish date</label>
            <input name="items[${index}].finishDate" value="${practical.finishDate}" type="month" class="form-control"
                   id="finishDate"/>
            <form:errors path="items[${index }].finishDate" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputDescription">Description</label>
        <textarea name="items[${index}].responsibilities" type="text" class="form-control" id="inputDescription"
                  rows="3">${practical.responsibilities}</textarea>
        <div class="row">
            <div class="col-12">
                <form:errors path="items[${index }].responsibilities" cssClass="alert alert-danger" element="div"/>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputDemo">Link to demo</label>
            <input name="items[${index}].demo" value="${practical.demo}" type="text" class="form-control"
                   id="inputDemo">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].demo" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="inputSRC">SRC</label>
            <input name="items[${index}].src" value="${practical.src}" type="text" class="form-control" id="inputSRC">
            <div class="row">
                <div class="col-12">
                    <form:errors path="items[${index }].src" cssClass="alert alert-danger" element="div"/>
                </div>
            </div>
        </div>
    </div>

</div>