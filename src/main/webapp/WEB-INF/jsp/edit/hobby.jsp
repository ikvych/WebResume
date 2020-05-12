<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags/edit"%>

<div class="container"  data-csrf-value="${_csrf.token}">
    <div class="row" style="height: 100vh">
        <div class="col-12">
            <resume:tab-header selected="hobby" />
            <div class="card border-top-0">
                <div class="card-body" data-max-hobbies='5' id="ui-block-container">
                    <h4 style="margin-top: 10px">Hobbies</h4>
                    <div class="row">
                        <c:forEach var="hobby" items="${hobby.items}">
                            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                                <button style="margin-top: 0.5em" type="button" data-toggle="button" class="text-left btn btn-block btn-light hobby-btn <%--${hobby.selected ? 'active' : '' }--%>"
                                        a<%--ria-pressed="${hobby.selected ? 'true' : 'false' }"--%>>
                                    <i class="fa fa-address-book fa-lg"></i> ${hobby.name }
                                </button>
                            </div>
                        </c:forEach>
                    </div>
                    <a href="javascript:resume.hobbies.save();" class="btn btn-primary">Сохранить</a>
                </div>
            </div>
        </div>
    </div>
</div>