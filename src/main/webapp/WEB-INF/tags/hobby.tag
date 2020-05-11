<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>

<div class="card " style="margin-top: 1em">
    <div class="card-body">
        <div class="row">
            <div class="col-md-3 col-12" style="margin-bottom: 2%">
                <div class="btn-group">
                    <i class="fa fa-heart fa-2x " style="color: #727272"></i><a class="text-dark" style="margin-left: 1em" href="/edit/hobby"><h4> Hobbies</h4></a>
                </div>
            </div>
            <div class="col-md-9 col-12">
                <table class="table table-bordered p-2 m-0">
                    <tbody class="">
                    <c:forEach var="hobby" items="${profile.hobbies}">
                        <tr>
                            <td><i class="fa fa-${hobby.name}"></i></td>
                            <td>${hobby.name }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>