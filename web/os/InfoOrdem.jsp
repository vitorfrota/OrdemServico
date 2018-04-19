<%@page import="sgos.model.beans.Avaliacao"%>
<%@page import="sgos.model.dao.AvaliacaoDAO"%>
<%@page import="sgos.model.beans.OrdemServico"%>
<%@page import="sgos.model.dao.OrdemServicoDAO"%>
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
        <script language="JavaScript" type="text/javascript" src="../assets/js/jquery-1.9.1.min.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/bootstrap.js"></script>
    </head>
    <body class="bg">
        <%
            AvaliacaoDAO adao = new AvaliacaoDAO();
            OrdemServicoDAO odao = new OrdemServicoDAO();
            OrdemServico o = odao.consulta(Integer.parseInt(request.getParameter("codigo")));
            String nomecliente = adao.consultaNomeCliente(Integer.parseInt(request.getParameter("codigo")));
            String nometecnico = adao.consultaNomeTecnico(Integer.parseInt(request.getParameter("codigo")));
        %>
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
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h2>Ordem de Serviço - #Protocolo: <%= o.getOsid()%></h2>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class=" col-md-12 col-lg-12 ">
                                    <table class="table table-user-information">
                                        <tbody>
                                            <tr>
                                                <td>Situação:</td>
                                                <td><%= o.getOssituacao()%></td>
                                            </tr>
                                            <tr>
                                                <td>Data Abertura:</td>
                                                <td><%= o.getOsdataabertura()%></td>
                                            </tr>
                                            <tr>
                                                <td>Descrição:</td>
                                                <td><%=o.getOsdescaparelho()%></td>
                                            </tr>
                                            <tr>
                                                <td>Defeito:</td>
                                                <td><%= o.getOsdefeito()%></td>
                                            </tr>
                                            <tr>
                                                <td>Data Prevista:</td>
                                                <td><%= o.getOsdataconclusao()%></td>
                                            </tr>
                                            <tr>
                                                <td>Cliente:</td>
                                                <td><%= nomecliente%></td>
                                            </tr>
                                            <tr>
                                                <td>Técnico:</td>
                                                <td><%= nometecnico%></td>
                                            </tr>
                                            <tr>
                                                <td>Valor:</td>
                                                <td>R$ <%= odao.calculatotal(o.getOsid())%></td>
                                            </tr>
                                            <tr>
                                                <td><button type="button" class="btn btn-warning" style="width: 100%;" onClick="location.href = 'FecharOS.jsp?codigo=<%=o.getOsid()%>'"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Editar Ordem</button></td>
                                            </tr>
                                        </tbody>
                                    </table>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
