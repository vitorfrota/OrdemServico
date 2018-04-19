<%@page import="sgos.model.beans.Cliente"%>
<%@page import="sgos.model.dao.ClienteDAO"%>
<%@page import="sgos.model.beans.Tecnico"%>
<%@page import="sgos.model.dao.TecnicoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- FONTE ROBOTO -->
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
        <link rel="stylesheet" href="../assets/css/estilo.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/botstrap-theme.css">
        <script src="../assets/js/jquery-1.9.1.min.js"></script>  

        <script language="JavaScript" type="text/javascript" src="../assets/js/bootstrap.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/formata.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/verifica.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/teste.js"></script>
    </head>
    <body class="bg">
        <nav class="navbar navbar-inverse" style="border-radius: 0;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" style=" " data-toggle="collapse" data-target="#menu" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../index.jsp"><img src="../assets/img/logo.png"/></a>
                </div>
                <div class="collapse navbar-collapse"  id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="../os/Ordens.jsp">Ordens de Serviço</a></li>
                        <li><a href="../cliente/Clientes.jsp">Clientes</a></li>
                        <li><a href="../tecnico/Tecnicos.jsp">Técnicos</a></li>
                        <li><a href="../servico/Servicos.jsp">Serviços</a></li>
                        <li><a href="../peca/Pecas.jsp">Peças</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container form">
            <div class="page-header">
                <h1>Abrir Ordem de Serviço</h1>
            </div>
            <article class="row">
                <div class="panel panel-default">
                    <form name="frm" id="frm" class="col-md-12" action="../ControllerOS" method="post">
                        <fieldset>
                            <legend>Dados do Cliente</legend>
                            <label>Cliente:</label>
                            <br>
                            <select name="cliente" id="cliente" class="form-control">
                                <option value="" disabled selected>Selecione o cliente</option>
                                <% ClienteDAO cdao = new ClienteDAO();
                                    for (Cliente c : cdao.listarClientes()) {
                                %>                            
                                <option><%= c.getClinome()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <br>
                        </fieldset>
                        <fieldset>
                            <legend>Dados do Aparelho</legend>
                            <div class="form-group">
                                <label for="usr">Descrição:<span class="required">*</span></label>
                                <br>
                                <input type="text" class="form-control" id="txtdesc" name="txtdesc" placeholder="Apple Iphone 5s S/N:0000" required>
                            </div>
                            <div class="form-group">
                                <label for="">Defeito:<span class="required">*</span></label>
                                <input type="text" class="form-control" id="txtdefeito" name="txtdefeito"  placeholder="Aparelho não liga" required>
                            </div>
                            <div class="form-group">
                                <label for="">Data Prevista:<span class="required">*</span></label>
                                <input type="date" class="form-control" id="txtdata" name="txtdata" required>
                            </div>
                            <label for="usr">Técnico:<span class="required">*</span></label>
                            <br>
                            <select name="tecnico" id="tecnico" class="form-control">
                                <option value="" disabled selected>Selecione o técnico</option>
                                <% TecnicoDAO tdao = new TecnicoDAO();
                                    for (Tecnico t : tdao.listarTecnicos()) {
                                %>                            
                                <option><%= t.getTecnome()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <br>
                        </fieldset>
                        <button type="submit" id="botao" name="botao" value="1" class="btn btn-primary" style="width: 100%;">Cadastrar</button>
                    </form>
                </div>
            </article>
        </div>
    </body>
</html>
