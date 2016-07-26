<%-- 
    Document   : nova-denuncia
    Created on : 25/07/2016, 17:18:32
    Author     : Priscila Gouveia <priscilaggouveia@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>SOS Mulher - Fazer Denúncia</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href='http://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
        <link href="resources/css/style.css" rel="stylesheet">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="resources/img/sos.png" >
        <script src="resources/js/script_maps.js"></script>
        <script src="resources/js/script.js"></script>
    </head>
    <body Onload="loadScript()">
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
                                <span class="glyphicon glyphicon-cog icone"></span><span class=" glyphicon caret icone"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="Logout">Sair</a></li>
                            </ul>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-5 col-md-offset-1 formdenuncia">
                    <h2>Fazer Denúncia</h2>
                    <hr>
                    <div class="row">
                        <form action="CadastrarDenuncia" method="POST">

                            <div class="form-group">
                                <h4>Tipo de Ocorrência:  </h4>
                                <select name="ocorrencia" class="form-control">
                                    <option value="assedio">Assédio</option>
                                    <option value="estupro">Estupro</option>  
                                    <option value="agressao">Agressão</option>
                                </select>
                            </div>

                            <h4>Data</h4>
                            <div class="form-group">
                                <label>
                                    <input type="month" class="form-control" name="data" id="data">
                                </label>
                            </div>

                            <h4>Nesta situação você foi:</h4>
                            <div class="radio">
                                <label class="radio-inline">
                                    <input type="radio" value="vitima" name="situacao" checked>
                                    Vítima da Ocorrência
                                </label>

                                <label class="radio-inline">
                                    <input type="radio" value="testemunha" name="situacao">
                                    Presenciou a Ocorrência
                                </label>
                            </div>

                            <h4>Você gostaria de ser identificado? </h4>
                            <div class=" form-group radio">
                                <label class="radio-inline">
                                    <input type="radio" value="sim" name="identificacao">
                                    Sim
                                </label>	

                                <label class="radio-inline">
                                    <input type="radio" value="nao" name="identificacao" checked>
                                    Não
                                </label>
                            </div>

                            <br>

                            <h4>Mais informações</h4>
                            <div class="form-group">
                                <textarea class="form-control" id="info" name="info" cols=50 rows=3 required placeholder="Adicione as informações que você julgar importantes para o registro da ocorrência"></textarea>
                            </div>
                            <input type="text" id="coordenada" name="coordenada">
                            <button type="submit" class="btn btn-default pull-right">
                                Denunciar
                            </button>
                        </form>
                    </div>
                </div>
                <div class="col-md-5 embed-responsive embed-responsive-16by9">
                    <div  id="map" class="embed-responsive-item" style=" height:80%"></div>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
