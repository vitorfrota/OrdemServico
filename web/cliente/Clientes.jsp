<%@page import="sgos.model.dao.ClienteDAO"%>
<%@page import="sgos.model.beans.Cliente"%>
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
        <% ClienteDAO cdao = new ClienteDAO();
            List<Cliente> cliente = cdao.listarClientes();
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
                <div class="panel panel-default" >
                    <div class="panel-heading">
                        <h3>Clientes</h3>
                        <div class="row">
                            <div class="col-md-9">
                                <input type="text" class="form-control" alt="lista" placeholder="Faça aqui sua busca"/>   
                            </div>
                            <div class="col-md-3">
                                <button type="button" class="btn btn-info" style="width: 100%;" onClick="location.href = 'CadastroCliente.jsp'">
                                    <span class="glyphicon glyphicon-plus"></span> Novo Cliente
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="tbl-header">
                        <table cellpadding="0" cellspacing="0" border="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>Telefone</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="tbl-content">
                        <table id="lista" class="table table lista">
                            <tbody class="seleciona">
                                <%
                                    for (Cliente c : cliente) {
                                %>
                                <tr>
                                    <td class="col-md-1"><%= c.getCliid()%></td>
                                    <td class="col-md-1"><%= c.getClinome()%></td>
                                    <td class="col-md-1"><%= c.getClicpf()%></td>
                                    <td class="col-md-1"><%= c.getClifone()%></td>
                                    <td class="col-md-1"><button type="button" class="btn btn-warning" onClick="location.href = 'AlteraCliente.jsp?codigo=<%=c.getCliid()%>'"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
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
