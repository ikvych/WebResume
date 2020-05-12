<%@ tag pageEncoding="UTF-8" language="java"%>

<%@ attribute name="selected" required="true" type="java.lang.String" %>

<ul class="nav nav-tabs nav-fill" style="margin-top: 10px">
    <li class="nav-item" role="presentation" >
        <a ${selected == 'profile' ?     'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/profile">Profile</a>
    </li>

    <li class="nav-item" role="presentation" >
        <a ${selected == 'contacts' ?    'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/contacts">Contacts</a>
    </li>

    <li class="nav-item" role="presentation" >
        <a ${selected == 'skills' ?     'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/skills">Technical skills</a>
    </li>

    <li class="nav-item" role="presentation" >
        <a ${selected == 'practical' ?    'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/practical">Practical skills</a>
    </li>

    <li class="nav-item" role="presentation" >
        <a ${selected == 'certificates' ? 'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/certificates">Certificates</a>
    </li>
    <li class="nav-item" role="presentation" >
        <a ${selected == 'courses' ?     'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/courses">Courses</a>
    </li>
    <li class="nav-item" role="presentation" >
        <a ${selected == 'education' ?   'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/educations">Education</a>
    </li>
    <li class="nav-item" role="presentation" >
        <a ${selected == 'languages' ?    'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/languages">Language</a>
    </li>
    <li class="nav-item" role="presentation" >
        <a ${selected == 'hobby' ?       'class="nav-link text-dark active"' : 'class="nav-link text-dark"'} href="/edit/hobby">Hobby</a>
    </li>
</ul>
