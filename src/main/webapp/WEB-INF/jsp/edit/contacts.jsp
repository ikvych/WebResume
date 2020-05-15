<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags/edit"%>



<div class="container">
    <div class="row" style="height: 100vh">
        <div class="col-12">
            <resume:tab-header selected="contacts" />

            <div class="card border-top-0">
                <form:form action="/edit/contacts" method="post" modelAttribute="contacts" style="margin-top: 10px">
                    <div class="card-body">
                        <h4 class="card-title text-center" style="margin-top: 10px">Additional contacts</h4>

                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputSkype">Skype</label>
                                    <form:input path="skype" type="text" class="form-control" id="InputSkype"/>
                                    <div class="row " >
                                        <div class="col-12">
                                            <form:errors path="skype" cssClass="alert alert-danger" element="div" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    1. Желательно, чтобы skype содержал Ваше имя и фамилию как указано в загран паспорте. Если указанное имя уже занято, возможны сокращения.<br />
                                    2. Не рекомендуется использовать креативные skype, например TheBestDeveloper, lackomka, etc.<br />
                                    3. Если у Вас нет адекватного skype-имени, значит пришло время его создать
                                </blockquote>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputFacebook">Facebook</label>
                                    <form:input path="facebook" type="text" class="form-control" id="InputFacebook"/>
                                    <div class="row " >
                                        <div class="col-12">
                                            <form:errors path="facebook" cssClass="alert alert-danger" element="div" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="InputLinkedin">Linkedin</label>
                                    <form:input path="linkedin" type="text" class="form-control" id="InputLinkedin"/>
                                    <div class="row " >
                                        <div class="col-12">
                                            <form:errors path="linkedin" cssClass="alert alert-danger" element="div" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="InputGithub">Github</label>
                                    <form:input path="github" type="text" class="form-control" id="InputGithub"/>
                                    <div class="row " >
                                        <div class="col-12">
                                            <form:errors path="github" cssClass="alert alert-danger" element="div" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="InputStackoverflow">Stackoverflow</label>
                                    <form:input path="stackoverflow" type="text" class="form-control" id="InputStackoverflow"/>
                                    <div class="row " >
                                        <div class="col-12">
                                            <form:errors path="stackoverflow" cssClass="alert alert-danger" element="div" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    1. Для получения полной информации о кандидате HR-менеджер может поискать его профиль в социальной сети. Для того, чтобы Ваш профиль был быстрее всего найден,
                                    укажите ссылки на него в Ваших дополнительных контактах<br />
                                    2. Указывая профиль, убедитесь что в нем нет информации противоречашей Вашему резюме, так как такие несоответствия видны невооруженным глазом <br />
                                    3. Просмотрите Ваш профиль со стороны и убедитесь, что в нем нет неприличных фотографий Вашей бурной студенческой жизни - это информация некчему при поиске работы<br/>
                                    4. Если Вы состоите в сомнительных группах, которые компрометируют Вас как адекватного человека, пришло время покинуть эти сообщества <br/>
                                    5. В настройках современных социальных сетях есть возможность создания именованных ссылок на профиль, вместо id12345678, поэтому имеет смысл
                                    воспользоваться данными возможностями
                                </blockquote>
                            </div>
                        </div>

                        <input type="submit" class="btn btn-dark" value="Save">
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</div>