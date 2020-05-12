<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>

<div class="container">
    <div class="row">
        <div class="col-12">
            <resume:tab-header selected="profile"/>
            <div class="card border-top-0">
                <form:form action="/edit/profile" method="post" modelAttribute="profile">
                    <div class="card-body">
                        <h4 class="card-title text-center"
                            style="margin-top: 10px; margin-bottom: 20px">${profile.firstName} ${profile.lastName}</h4>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <img id="" src="${profile.largePhoto }" class="edit-photo"/><br/>
                                    <input type="file" name="profilePhoto" id="inputPhoto"/>
                                </div>
                            </div>
                            <div class="col-sm-6 help-block">
                                <blockquote>
                                    1. Фотография может многое рассказать о кандидате: начиная от его эстетических
                                    качеств и заканчивая его отношением к поиску серьезной работы<br/>
                                    2. Фотография как на паспорт или в костюме необязательна, главное адекватность и
                                    ухоженный, акууратный внешний вид<br/>
                                    3. В качестве примеров Вы можете посмотреть на фотографии демонстрационных резюме в
                                    данном приложении<br/>
                                    4. Размер фотографии должен быть не меньше чем 400x400 <br/>
                                    5. Файл должен быть в формате jpg <br/>
                                </blockquote>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputBirthDay">BirthDay</label>
                                    <form:input path="birthDay" type="text" class="form-control" id="InputBirthDay"
                                                required="required"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="birthDay" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>

                            </div>

                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    Формат даты: yyyy-mm-dd (четыре цифры года - код месяца - день рождения)
                                </blockquote>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputCountry">Country</label>
                                    <form:input path="country" type="text" class="form-control" id="InputCountry"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="country" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>
                                <div class="form-group">
                                    <label for="InputCity">City</label>
                                    <form:input path="city" type="text" class="form-control" id="InputCity"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="city" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>
                            </div>
                            <div class="col-6">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputEmail">Email</label>
                                    <form:input path="email" type="text" class="form-control" id="InputEmail"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="email" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>
                            </div>
                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    1. Желательно, чтобы email содержал Ваше имя и фамилию как указано в загран
                                    паспорте. Если указанное имя уже занято, возможны сокращения.<br/>
                                    2. Не рекомендуется использовать креативные email, например
                                    TheBestDeveloper@gmail.com, lackomka@gmail.com, etc.<br/>
                                    3. Не рекомендуется использовать доменное имя работодателя там где Вы сейчас
                                    работаете.<br/>
                                    4. Для программистов рекомендуется использовать домен @gmail.com
                                </blockquote>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputTelephone">Phone number</label>
                                    <form:input path="phone" type="text" class="form-control" id="InputTelephone"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>
                            </div>
                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    Номер телефона должен быть рабочим и тем номером с которого Вы будете отвечать на
                                    звонки с неизвестных Вам номеров.
                                    Номер телефона нужно предоставлять в формате <a
                                        href="https://ru.wikipedia.org/wiki/E.164" target="_blank">E.164</a>, например:
                                    +380501234567
                                </blockquote>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputObjective">Objective</label>
                                    <form:input path="objective" type="text" class="form-control" id="InputObjective"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="objective" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>
                            </div>
                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    В данном разделе нужно указать желаемую должность, максимально кратно и понятно
                                </blockquote>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="InputSummery">Summery</label>
                                    <form:textarea path="summary" type="text" class="form-control" id="InputSummery"
                                                   rows="8"/>
                                        <%--                                    <div class="row " >
                                                                                <div class="col-12">
                                                                                    <form:errors path="summary" cssClass="alert alert-danger" element="div" />
                                                                                </div>
                                                                            </div>--%>
                                </div>
                            </div>
                            <div class="col-6">
                                <blockquote>
                                    <br/>
                                    1. В данном разделе необходимо описать Ваш опыт (практический или теоретический) по
                                    тому направлению в котором Вы ищите работу.<br/>
                                    2. Если Вы работали фотографом и хотите изменить профиль своей деятельности не нужно
                                    описывать Ваши достижения в фотографии при поиске работы программистом<br/>
                                    3. Если во желаемой должности у Вас нет достижений, это повод пройти какие-либо
                                    курсы в данном направлении или самостоятельно изучить основы будущей профессии
                                </blockquote>
                            </div>
                        </div>
                        <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="exampleFormControlTextarea1">A few words about yourself that will showcase
                                    your strengths.</label>
                                <form:textarea path="info" class="form-control" id="exampleFormControlTextarea1"
                                               rows="3"/>
                                <div class="row ">
                                    <div class="col-12">
                                        <form:errors path="info" cssClass="alert alert-danger" element="div"/>
                                    </div>
                                </div>
                            </div>
                            <blockquote>
                                Укажите дополнительную информацию, которая действительно важна работодателю.
                                Например:<br/>
                                <i>Наличие открытой визы в иностранное государство, семейное положение, если женат и
                                    есть дети, реальный опыт в деятельности, которая может быть Вашей предметной
                                    областью
                                    при разработке програмного обеспечения, возможно опыт исследовательской работы в НИИ
                                    и т.д. </i><br/>
                                НЕ стоит указывать ваши личностные качества, почти все кандидаты ответственные,
                                комуникабельные и порядочные)))<br/>
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
