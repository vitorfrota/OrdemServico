<%@page import="sgos.model.beans.OrdemServico"%>
<%@page import="sgos.model.dao.OrdemServicoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- FONTE ROBOTO -->
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/tabela.css">
        <script language="JavaScript" type="text/javascript" src="../assets/js/jquery-1.9.1.min.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/bootstrap.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/quicksearch.js"></script>
    <body class="bg">
        <% OrdemServicoDAO odao = new OrdemServicoDAO();
            List<OrdemServico> ordem = odao.listarOrdens();
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3>Ordens de Serviço</h3>
                        <div class="row">
                            <div class="col-md-9">
                                <input type="text" class="form-control" alt="lista" placeholder="Faça aqui sua busca"/>   
                            </div>
                            <div class="col-md-3">
                                <button type="button" class="btn btn-info" style="width: 100%;" onClick="location.href = 'AbrirOS.jsp'">
                                    <span class="glyphicon glyphicon-plus"></span> Nova Ordem de Serviço
                                </button>
                            </div>
                        </div>
                        <div class="row">
                            <button type="button" class="btn btn-success" style=" margin-left: 1%; width: 25%;" onClick="location.href = 'Relatorio.jsp'">
                                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Relatório
                            </button>
                        </div>
                    </div>

                    <div class="tbl-header">
                        <table cellpadding="0" cellspacing="0" border="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Data Abertura</th>
                                    <th>Situação</th>
                                    <th>Descrição</th>
                                    <th>Defeito</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="tbl-content">
                        <table id="lista" class="table-striped lista">
                            <tbody class="seleciona">
                                <%
                                    for (OrdemServico o : ordem) {
                                %>
                                <tr>
                                    <td class="col-md-1"><%= o.getOsid()%></td>
                                    <td class="col-md-1"><%= o.getOsdataabertura()%></td>
                                    <td class="col-md-1"><%= o.getOssituacao()%></td>
                                    <td class="col-md-1"><%= o.getOsdescaparelho()%></td>
                                    <td class="col-md-1"><%= o.getOsdefeito()%></td>
                                    <td class="col-md-1">
                                        <button type="button" class="btn btn-success"  onClick="location.href = 'InfoOrdem.jsp?codigo=<%=o.getOsid()%>'"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> </button>
                                        <button type="button" class="btn btn-warning"  onClick="location.href = 'FecharOS.jsp?codigo=<%=o.getOsid()%>'"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> </button>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>  
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
