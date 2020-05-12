<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags/edit"%>

<div class="container">
    <div class="row" style="height: 100vh">
        <div class="col-12">
            <resume:tab-header selected="courses" />
            <div class="card border-top-0">
                <form:form action="/edit/courses" method="post" modelAttribute="courses">
                    <div class="card-body">
                        <h4 class="card-title" style="margin-top: 10px">Training courses</h4>
                        <c:forEach var="course" items="${courses.items}" varStatus="status" >
                            <resume:courses index="${status.index}" course="${course}" />
                        </c:forEach>
                        <a href="" class="text-primary">+ add skills</a><br/>
                        <button type="submit" class="btn btn-dark" style="margin-top: 1em">Save</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>