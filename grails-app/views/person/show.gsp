<%@ page import="java.text.SimpleDateFormat; java.text.DateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="show-person" class="col-12 content scaffold-show" role="main">
                    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <f:display bean="person" />
%{-- the following ol and the import on line one are the only additions to the default view --}%
                    <ol class="property-list person-bookings"
                        style="transform: translateY(-2em)">
                            <li class="fieldcontain">
                                <span id="bookings-label" class="property-label">Bookings</span>
                                <div class="property-value" aria-labelledby="bookings-label"
                                     style="display: grid; grid-template-columns: repeat(4, max-content); gap: 0 1em;">
                                    <% def dateFormat = new SimpleDateFormat("dd. MMM yyyy") %>
                                    <g:each in="${this.bookings}" var="booking">
                                        <span>${booking.room.name}</span>
                                        <span>(${booking.room.capacity})</span>
                                        <span>${ dateFormat.format(booking.bookingDate)}</span>
                                        <span>${booking.timeslot}</span>
                                    </g:each>
                                </div>
                            </li>
                    </ol>
%{--end of addition --}%
                    <g:form resource="${this.person}" method="DELETE">
                        <fieldset class="buttons">
                            <g:link class="edit" action="edit" resource="${this.person}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </fieldset>
                    </g:form>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
