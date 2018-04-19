<%@page import="sgos.model.dao.ServicoDAO"%>
<%@page import="sgos.model.dao.PecaDAO"%>
<%@page import="sgos.model.dao.TecnicoDAO"%>
<%@page import="sgos.model.dao.ClienteDAO"%>
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
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <script language="JavaScript" type="text/javascript" src="assets/js/jquery-1.9.1.min.js"></script>
        <script language="JavaScript" type="text/javascript" src="assets/js/bootstrap.js"></script>
    </head>
    <body>
        <% OrdemServicoDAO odao = new OrdemServicoDAO();
            ClienteDAO cdao = new ClienteDAO();
            TecnicoDAO tdao = new TecnicoDAO();
            PecaDAO pdao = new PecaDAO();
            ServicoDAO sdao = new ServicoDAO();

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
                    <a class="navbar-brand" href="index.jsp"><img src="assets/img/logo.png"/></a>
                </div>
                <div class="collapse navbar-collapse"  id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="os/Ordens.jsp">Ordens de Serviço</a></li>
                        <li><a href="cliente/Clientes.jsp">Clientes</a></li>
                        <li><a href="tecnico/Tecnicos.jsp">Técnicos</a></li>
                        <li><a href="servico/Servicos.jsp">Serviços</a></li>
                        <li><a href="peca/Pecas.jsp">Peças</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="jumbotron">
                        <h1 class="display-3">BEM VINDO!</h1>
                        <p class="lead">Para oferecer um melhor atendimento aos clientes de uma assistência técnica 
                            uma ordem de serviço bem elaborada é essencial para garantir controle e melhor manuseio de seus gestores. </p>
                        <hr class="my-4">
                        <p>Desenvolvido por Carlos José e Vitor Frota</p>
                    </div>
                </div>
                <div class="col-lg-3">

                </div>
                <div class="col-lg-3">
                    <h4>Acesso Rápido</h4>
                    <button type="button" onClick="location.href = 'os/AbrirOS.jsp'" class="btn btn-info">
                        Ordens Pendentes <span class="badge badge-warning"><%= odao.contador()%></span>
                    </button> 
                    <br>
                    <button type="button" onClick="location.href = 'cliente/CadastroCliente.jsp'" class="btn btn-primary">
                        Clientes Cadastrados <span class="badge badge-light"><%= cdao.contador()%></span>
                    </button>
                    <br>
                    <button type="button" onClick="location.href = 'tecnico/CadastroTecnico.jsp'" class="btn btn-success">
                        Técnicos Disponíveis <span class="badge badge-light"><%= tdao.contador()%></span>
                    </button> 
                    <br>
                    <button type="button" onClick="location.href = 'servico/CadastroServico.jsp'" class="btn btn-danger">
                        Serviços <span class="badge badge-light"><%= sdao.contador()%></span>
                    </button> 
                    <br>
                    <button type="button" onClick="location.href = 'peca/CadastroPeca.jsp'" class="btn btn-warning">
                        Peças Estoque <span class="badge badge-light"><%= pdao.contador()%></span>
                    </button> 
                </div>
            </div>
        </div>
    </div>
</body>
</html>
