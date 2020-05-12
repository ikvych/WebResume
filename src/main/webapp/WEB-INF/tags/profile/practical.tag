<%@ tag import="java.time.LocalDate" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>

<div class="card " style="margin-top: 1em">
    <div class="card-body">
        <div class="row">
            <div class="col-md-3 col-12" style="margin-bottom: 2%">
                <div class="btn-group">
                    <i class="fa fa-briefcase fa-2x" style="color: #727272"></i><a class="text-dark" style="margin-left: 1em" href="/edit/practical"><h4> Work experience</h4></a>
                </div>
            </div>
            <div class="col-md-9 col-12">
                <ul class="timeline">

                    <c:forEach var="practic" items="${profile.practicals}">
                        <li>
                            <div class="timeline-badge danger">
                                <i class="fa fa-briefcase"></i>
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4 class="timeline-title">${practic.position } at ${practic.company }</h4>
                                    <p>
                                        <small class="dates"><i class="fa fa-calendar"></i>
                                            <javatime:format value="${practic.beginDate}" pattern="MMM yyyy" /> -
                                            <c:choose>
                                                <c:when test="${practic.finishDate.isBefore(practic.currentDate)}">
                                                    <javatime:format value="${practic.finishDate}" pattern="MMM yyyy" />
                                                </c:when>
                                                <c:otherwise>
                                                    <strong class="label label-danger">Current</strong>
                                                </c:otherwise>
                                            </c:choose>
                                        </small>
                                    </p>
                                </div>
                                <div class="timeline-body">
                                    <p>
                                        <strong>Responsibilities included:</strong> ${practic.responsibilities }
                                    </p>
                                    <c:if test="${practic.demo != null }">
                                        <p>
                                            <strong>Demo: </strong><a href="${practic.demo}">${practic.demo}</a>
                                        </p>
                                    </c:if>
                                    <c:if test="${practic.src != null }">
                                        <p>
                                            <strong>Source code: </strong><a href="${practic.src}">${practic.src}</a>
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