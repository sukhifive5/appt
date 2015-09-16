<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<div class="btn-toolbar">
    <div class="btn-group">
        <button class="btn btn-success" ng-click="changeView('agendaDay', myCalendar)">Day</button>
        <button class="btn btn-success" ng-click="changeView('agendaWeek', myCalendar)">Week</button>
        <button class="btn btn-success" ng-click="changeView('month', myCalendar)">Month</button>
    </div>
</div>
<div class="calendar" ng-model="eventSources" calendar="myCalendar" config="uiConfig.calendar" ui-calendar="uiConfig.calendar"></div>

