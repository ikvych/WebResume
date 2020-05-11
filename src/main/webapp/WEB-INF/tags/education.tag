<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>

<div class="card " style="margin-top: 1em">
    <div class="card-body">
        <div class="row">
            <div class="col-md-3 col-12" style="margin-bottom: 2%">
                <div class="btn-group">
                    <i class="fa fa-graduation-cap fa-2x" style="color: #727272"></i><a class="text-dark" style="margin-left: 1em" href="/edit/education"><h4> Education</h4></a>
                </div>
            </div>
            <div class="col-md-9 col-12">
                <ul class="timeline">
                    <c:forEach var="education" items="${profile.educations}">
                        <li>
                            <div class="timeline-badge warning">
                                <i class="fa fa-graduation-cap"></i>
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4 class="timeline-title">${education.summary }</h4>
                                    <p>
                                        <small class="dates"><i class="fa fa-calendar"></i>
                                                ${education.beginYear } -
                                            <c:choose>
                                                <c:when test="${education.finishYear <= education.currentDate.year}">
                                                    ${education.finishYear }
                                                </c:when>
                                                <c:otherwise>
                                                    <strong class="label label-danger">Current</strong>
                                                </c:otherwise>
                                            </c:choose>
                                        </small>
                                    </p>
                                </div>
                                <div class="timeline-body">
                                    <p>${education.faculty }, ${education.university }</p>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

            </div>
        </div>
    </div>
</div>