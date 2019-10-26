<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="uni.fmi.masters.beans.UserBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Weather App</title>

    <meta name="apple-mobile-web-app-capable" content="yes">

    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="assets/css/main.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.4.1.js" > </script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</head>
<body>


<% UserBean user = (UserBean)request.getAttribute("user"); %>

<div class="home-page">

        <header>
            <div class="container">
                <nav class="navbar navbar-default">

                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <div class="current-weather">
                                <div class="img-container">
                                    <img src="assets/img/weather_icon.png" style="display:none;"/>
                                </div>
                                <div class="info">
                                    <div class="city">Пловдив</div>
                                    <div id="current-condition"></div>
                                    <div class="pull-right"><span id="current-temperature"></span> ℃</div>
                                </div>
                            </div>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="active">
                                    <a href="home.html">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                                        <span class="nav-label">Начало</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="friends.html">
                                        <i class="fa fa-users" aria-hidden="true"></i>
                                        <span class="nav-label">Приятели</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="inbox.html">
                                        <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                                        <span class="nav-label">Известия</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="profile.html">
                                        <i class="fa fa-cogs" aria-hidden="true"></i>
                                        <span class="nav-label">Профил</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html">
                                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                                        <span class="nav-label">Изход</span>
                                    </a>
                                </li>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                </nav>
            </div>
        </header>


        <div class="container">
            <div class="row" style="margin-top:30px;">

                <div class="col-xs-12">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Твоят профил</h3>
                        </div>
                        <div class="panel-body">

                            <div class="row">
                                <div class="col-sm-4">
                                    <label for="user-image">Снимка</label>
                                    <input type="text" class="form-control" id="user-image" >
                                    <img class="img-thumbnail" src="assets/img/user.jpg" style="margin-top: 15px;">
                                </div>
                                <div class="col-sm-8">
                                    <form id="register-form">
                                        <div class="row">
                                            <div class="form-group col-sm-6">
                                                <label for="register-user">Потребител</label>
                                                <input type="text" class="form-control" id="register-user" placeholder="Потребител" value="${user.username}">
                                                <p class="help-block">Полето "потребител" е празно</p>
                                            </div>
                                            <div class="form-group col-sm-6">
                                                <label for="register-email">Email</label>
                                                <input type="email" class="form-control" id="register-email" placeholder="example@gmail.com" value="georgi24@abv.bg">
                                                <p class="help-block">Полето "Email" е празно</p>
                                            </div>
                                        </div>
                                       <div class="row">
                                           <div class="form-group col-sm-6">
                                               <label for="register-pass">Парола</label>
                                               <input type="password" class="form-control" id="register-pass" placeholder="Парола" value="password123">
                                               <p class="help-block">Полето "парола" е празно</p>
                                           </div>
                                           <div class="form-group col-sm-6">
                                               <label for="confirm-register-pass">Повтори паролата</label>
                                               <input type="password" class="form-control" id="confirm-register-pass" placeholder="Парола" value="password123">
                                               <p class="help-block">Полето "парола" е празно</p>
                                           </div>
                                       </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer" style="height:55px;">
                            <button type="button" class="btn btn-primary pull-right publish"><span class="glyphicon glyphicon-floppy-save"></span> Запази</button>
                        </div>
                    </div>
                </div>



            </div>
        </div>

</div>



</body>
</html>
