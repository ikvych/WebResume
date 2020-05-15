<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>

<div class="card " style="margin-top: 1em">
    <div class="card-body">
        <div class="row">
            <div class="col-md-3 col-12" style="margin-bottom: 2%">
                <div class="btn-group">
                    <i class="fa fa-book fa-2x" style="color: #727272"></i><a class="text-dark" style="margin-left: 1em" href="/edit/courses"><h4> Courses</h4></a>
                </div>
            </div>
            <div class="col-md-9 col-12">
                <ul class="timeline">
                    <c:forEach var="course" items="${profile.courses}">
                        <li>
                            <div class="timeline-badge success">
                                <i class="fa fa-book"></i>'
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4 class="timeline-title">${course.name } at ${course.organization }</h4>
                                    <p>
                                        <small class="dates"><i class="fa fa-calendar"></i>
                                            <strong>Date:</strong>
                                            <javatime:format value="${course.beginDate}" pattern="yyyy-MM" /> -
                                            <c:choose>
                                                <c:when test="${course.finishDate.isBefore(course.currentDate)}">
                                                    <javatime:format value="${course.finishDate}" pattern="yyyy-MM" />
                                                </c:when>
                                                <c:otherwise>
                                                    <strong class="label label-danger">Not finished yet</strong>
                                                </c:otherwise>
                                            </c:choose>
                                        </small>
                                    </p>
                                </div>
                                <div class="timeline-body">
                                    <p>
                                        <strong>Course included:</strong> ${course.description }
                                    </p>
                                    <c:if test="${course.demo != null }">
                                        <p>
                                            <strong>Demo: </strong><a href="${course.demo}">${course.demo}</a>
                                        </p>
                                    </c:if>
                                    <c:if test="${course.src != null }">
                                        <p>
                                            <strong>Source code: </strong><a href="${course.src}">${course.src}</a>
                                        </p>
                                    </c:if>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>