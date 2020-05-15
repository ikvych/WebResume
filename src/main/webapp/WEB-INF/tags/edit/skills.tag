<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="index" required="true" type="java.lang.Object" %>
<%@ attribute name="skill" required="false" type="ikvych.resume.entity.Skill" %>


<div id="edit-item-${index}" class="form-row edit-item" style="margin-top: 1em">
    <input name="items[${index}].id" value="${skill.id}" type="hidden"/>

    <div class="form-group col-md-2">
        <div class="float-right d-md-none" style="margin-left: 1em">
            <button type="button" class="close" onclick="$('#edit-item-${index }').remove();">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <input name="items[${index}].category" value="${skill.category}" type="text" class="form-control "/>
        <div class="row ">
            <div class="col-12">
                <form:errors path="items[${index}].category" cssClass="alert alert-danger" element="div"/>
            </div>
        </div>
    </div>
    <div class="form-group col">
        <textarea name="items[${index}].value" type="text" class="form-control " rows="3">${skill.value}</textarea>
        <form:errors path="items[${index}].value" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="float-right d-none d-md-block" style="margin-left: 1em">
        <button type="button" class="close" onclick="$('#edit-item-${index }').remove();">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>

</div>
