<%-- 
    Document   : index
    Created on : 25/07/2016, 01:29:40
    Author     : Priscila Gouveia <priscilaggouveia@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%--<%@page import="com.bdnc.ondefuipicado.entidades.Foco"%>%--%>
<%@page import="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>SOS Mulher - Mapa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href='http://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
        <link href="resources/css/style_index.css" rel="stylesheet">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="resources/img/sos.png">
        <script src="resources/js/script.js"></script>
    </head>
    <body onload="func_search()">
        <nav class="navbar navbar-inverse  ">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img class="logo" src="resources/img/sos.png"></a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp" title="Mapa"><span class="glyphicon glyphicon-globe icone"></span></a></li>
                        <li><a href="VerificarUsuarioLogado" type="button" title="Fazer denúncia"><span class="glyphicon glyphicon-plus icone"></span></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" title="Configurações">
                                <span class="glyphicon glyphicon-cog icone"></span><span class="glyphicon caret icone"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="Logout">Sair</a></li>
                            </ul>
                    </ul>
                </div>
            </div>
        </nav>
        <input id="pac-input" class="controls" type="text" placeholder="Digite um endereço">
        
        <div id="tipo-mapas">
            <a href="#" onclick="alterarParaHeatMap()" class="btn btn-xs btn-default" id="btMapaDeCalor">Mapa de Calor</a>
        </div>        
        
        <div id="map" style="width:70%; height:92%"></div>
        
        <div id="conteudoLateral">
            <h3>SOS Mulher - Denuncie casos de violência</h3>
            <a href="VerificarUsuarioLogado" id="btMarcarFoco" class="btn btn-lg">Faça uma denúncia!</a>
            
            <div id="legenda">
                <h4>Legenda</h4>
                <img src="resources/img/blue-marker.png" height="25" width="18">   <i> - Assédio</i><br>
                <img src="resources/img/yellow-marker.png" height="25" width="18"><i> - Agressão</i><br>
                <img src="resources/img/red-marker.png" height="25" width="18">   <i> - Estupro</i><br>
            </div>
        </div>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRIyAgKD5uTIEUwTcnfAW_SuJqyqnahtc&callback=initMap&region=br">
        </script>

    </body>

</html>
