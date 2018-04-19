<%@page import="sgos.model.dao.AvaliacaoDAO"%>
<%@page import="sgos.model.beans.OrdemServico"%>
<%@page import="sgos.model.dao.OrdemServicoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Relatório FastOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- FONTE ROBOTO -->
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <script language="JavaScript" type="text/javascript" src="../assets/js/jquery-1.9.1.min.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/bootstrap.js"></script>
    <body class="bg">
        <% OrdemServicoDAO odao = new OrdemServicoDAO();
            AvaliacaoDAO adao = new AvaliacaoDAO();
            List<OrdemServico> ordem = odao.relatorio();

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
                    </div>

                    <table class="table table-striped" cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Data Abertura</th>
                                <th>Situação</th>
                                <th>Descrição</th>
                                <th>Cliente</th>
                                <th>Técnico</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody class="seleciona">
                            <%                                    for (OrdemServico o : ordem) {
                            %>
                            <tr>
                                <td class="col-md-1"><%= o.getOsid()%></td>
                                <td class="col-md-1"><%= o.getOsdataabertura()%></td>
                                <td class="col-md-1"><%= o.getOssituacao()%></td>
                                <td class="col-md-1"><%= o.getOsdescaparelho()%></td>
                                <td class="col-md-1"><%= adao.consultaNomeCliente((o.getOsid()))%></td>
                                <td class="col-md-1"><%= adao.consultaNomeTecnico((o.getOsid()))%></td>
                                <td class="col-md-1">R$ <%= o.getOsvalor() %></td>
                            </tr>
                            <%
                                }
                            %>  
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td style="font-size: 24px;">TOTAL:</td>
                                <td style="font-size: 24px;">R$ <%= odao.somatotal()%></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
