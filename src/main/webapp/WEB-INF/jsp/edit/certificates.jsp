<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>

<div class="container">
    <div class="row" style="height: 100vh">
        <div class="col-12">
            <resume:tab-header selected="certificates"/>
            <div class="card border-top-0">
                <form:form action="/edit/certificates" enctype="multipart/form-data" method="post" modelAttribute="certificates" >
                    <div class="card-body">
                        <h4 class="card-title" style="margin-top: 10px">Certificates</h4>
                        <div class="row d-flex justify-content-center" id="EditContainer">
                            <c:forEach var="certificate" items="${certificates.items }" varStatus="status">
                                <resume:certificate index="${status.index }"
                                                    largeUrl="${certificate.largeURL }"
                                                    smallUrl="${certificate.smallURL }"
                                                    name="${certificate.name }"
                                                    id="${certificate.id }"/>
                            </c:forEach>
                        </div>
                        <div class="row-12 m-2">
                            <div class="col-xs-12 text-center">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#certificateUploader">+ Add certificate</button>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-dark" style="margin-top: 1em">Save</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script id="ui-block-template" type="text/x-handlebars-template">
    <resume:certificate index="{{index}}"
                        largeUrl="{{largeUrl}}"
                        smallUrl="{{smallUrl}}"
                        name="{{name}}"/>
</script>
<resume:certificate-viewer />
<resume:certificate-uploader />
<content tag="js-init">
    <script>
        $(document).ready(function() {
            initCertificateViewer();
            createCertificateUploader();
        });
    </script>
</content>