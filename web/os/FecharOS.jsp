<%@page import="sgos.model.dao.ItemServicoDAO"%>
<%@page import="sgos.model.dao.ServicoDAO"%>
<%@page import="sgos.model.beans.Servico"%>
<%@page import="sgos.model.dao.ItemPecaDAO"%>
<%@page import="java.util.List"%>
<%@page import="sgos.model.beans.Tecnico"%>
<%@page import="sgos.model.dao.TecnicoDAO"%>
<%@page import="sgos.model.dao.AvaliacaoDAO"%>
<%@page import="sgos.model.beans.Peca"%>
<%@page import="sgos.model.dao.PecaDAO"%>
<%@page import="sgos.model.beans.OrdemServico"%>
<%@page import="sgos.model.dao.OrdemServicoDAO"%>
<%@page import="sgos.model.beans.Cliente"%>
<%@page import="sgos.model.dao.ClienteDAO"%>
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
    </head>
    <body class="bg">
        <% OrdemServicoDAO odao = new OrdemServicoDAO();
            AvaliacaoDAO adao = new AvaliacaoDAO();
            ItemPecaDAO idao = new ItemPecaDAO();
            ItemServicoDAO isdao = new ItemServicoDAO();
            OrdemServico o = odao.consulta(Integer.parseInt(request.getParameter("codigo")));
            o.setOsid(Integer.parseInt(request.getParameter("codigo")));
            List<Peca> pecas = idao.listarPecasOS(o.getOsid());
            List<Servico> servicos = isdao.listarServicosOS(o.getOsid());
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
        <div class="container form">
            <div class="page-header">
                <h1>#Protocolo: <%= o.getOsid()%></h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#os">Detalhes da OS</a></li>
                <li><a data-toggle="tab" href="#pecas">Peças</a></li>
                <li><a data-toggle="tab" href="#servicos">Serviços</a></li>
            </ul>
            <article class="row">
                <div class="panel panel-default">
                    <div class="tab-content">
                        <div id="os" class="tab-pane fade in active">
                            <form name="frm" id="frm" class="col-md-12" action="../FecharOS" method="post">
                                <fieldset>
                                    <legend>#Protocolo: <%= o.getOsid()%></legend>
                                    <input type="hidden" value="<%= o.getOsid()%>" id="id" name="id">
                                    <div class="form-group row">
                                        <div class="col-xs-6">
                                            <label for="cliente">Cliente</label>
                                            <select name="cliente" id="cliente" class="form-control">
                                                <option value="<%= adao.consultaNomeCliente(o.getOsid())%>" ><%= adao.consultaNomeCliente(o.getOsid())%></option>
                                                <% ClienteDAO cdao = new ClienteDAO();
                                                    for (Cliente c : cdao.listarClientes()) {
                                                %>                            
                                                <option><%= c.getClinome()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-xs-6">
                                            <label for="tecnico">Técnico Responsável</label>
                                            <select name="tecnico" id="tecnico" class="form-control">
                                                <option value="<%= adao.consultaNomeTecnico(o.getOsid())%>"><%= adao.consultaNomeTecnico(o.getOsid())%></option>
                                                <% TecnicoDAO tdao = new TecnicoDAO();
                                                    for (Tecnico t : tdao.listarTecnicos()) {
                                                %>                            
                                                <option><%= t.getTecnome()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-xs-4">
                                            <label for="situacao">Situação</label>
                                            <input class="form-control" readonly="readonly" name="situacao1" id="situacao1" value="<%= o.getOssituacao()%>" type="text">
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="dataabertura">Data Abertura</label>
                                            <input class="form-control" readonly="readonly" name="dataabertura" id="dataabertura" value="<%= o.getOsdataabertura()%>" type="text">
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="txtdata">Data Prevista</label>
                                            <input class="form-control" id="txtdata" readonly="readonly" name="txtdata" value="<%= o.getOsdataconclusao()%>" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-xs-6">
                                            <label for="txtdesc">Descrição Produto</label>
                                            <textarea class="form-control" name="txtdesc" value="<%= o.getOsdescaparelho()%>" rows="5" id="txtdesc"><%= o.getOsdescaparelho()%></textarea>
                                        </div>
                                        <div class="col-xs-6">
                                            <label for="txtdefeito">Defeito</label>
                                            <textarea class="form-control" name="txtdefeito" value="<%= o.getOsdefeito()%>" rows="5" id="txtdefeito"><%= o.getOsdefeito()%></textarea>
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="row">
                                    <div class="col-lg-4">
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="btn-group" style="position: center;">
                                            <button type="button" id="modal" name="modal" class="btn btn-success" data-toggle="modal" data-target="#exampleModal"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Fechar Ordem</button>
                                            <button type="submit" id="botao" name="botao" value="1" class="btn btn-warning" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Alterar</button>
                                            <button type="button" id="botao" name="botao"  class="btn btn-info" onClick="location.href = 'InfoOrdem.jsp?codigo=<%=o.getOsid()%>'" ><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Visualizar OS</button>
                                        </div>
                                        <div class="col-lg-4">

                                        </div>
                                    </div>
                                </div>
                                <!-- MODAL FECHAR ORDEM DE SERVIÇO -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h2 class="modal-title" id="exampleModalLabel">Finalizar Ordem de Serviço</2>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="usr">Laudo do Técnico:</label>
                                                    <br>
                                                    <input type="text" class="form-control" id="txtlaudo" name="txtlaudo">
                                                </div>
                                                <label for="situacao">Situação</label>
                                                <select class="form-control" name="situacao" id="situacao">
                                                    <option value="FECHADO">Fechado</option>

                                                    <option value="CANCELADO">Cancelado</option>
                                                </select>
                                                <div class="row">
                                                    <div class="col-lg-6">
                                                        <h3>Total: </h3>
                                                    </div>
                                                    <div class="col-lg-6">
                                                        <h3>R$ <%= odao.calculatotal(o.getOsid())%></h3>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" value="2" id="botao" name="botao"  class="btn btn-primary">Finalizar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- PEÇAS LISTA -->
                        <div id="pecas" class="tab-pane fade">
                            <h5>Peça</h5>
                            <div class="row">
                                <form name="frm2" id="frm2" class="col-md-12" action="../AddPeca" method="post">
                                    <input type="hidden" name="osid" id="osid" value="<%= o.getOsid()%>">
                                    <div class="col-md-9">
                                        <select name="peca" id="peca" class="form-control">
                                            <% PecaDAO pdao = new PecaDAO();
                                                for (Peca p : pdao.listarPecas()) {
                                            %>                            
                                            <option><%= p.getPecdesc()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <button type="submit" name="botao" id="botao" class="btn btn-info" style="width: 100%;" value="1">
                                            <span class="glyphicon glyphicon-plus"></span> Adicionar
                                        </button>
                                    </div>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Peça</th>
                                                <th scope="col">Ações</th>
                                                <th scope="col">Sub-total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (Peca p : pecas) {
                                            %>
                                            <tr>
                                                <th scope="row"><%= p.getPecid()%></th>
                                                <td><%= p.getPecdesc()%></td>
                                                <td><button type="submit" value="<%= p.getPecid()%>" name="botao" id="botao" class="btn bg-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> </button></td>
                                                <td id="subtotal" name="subtotal">R$ <%= p.getPecvalor()%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                            <tr>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>Total:</td>
                                                <td>R$ <%= idao.calculaTotal(o.getOsid())%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                        <div id="servicos" class="tab-pane fade">
                            <h2>Serviços</h2>
                            <div class="row">
                                <form name="frm2" id="frm2" class="col-md-12" action="../AddServico" method="post">
                                    <input type="hidden" name="osid" id="osid" value="<%= o.getOsid()%>">
                                    <div class="col-md-9">
                                        <select name="peca" id="peca" class="form-control">
                                            <% ServicoDAO sdao = new ServicoDAO();
                                                for (Servico s : sdao.listarServicos()) {
                                            %>                            
                                            <option><%= s.getSerdesc()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <button type="submit" name="botao" id="botao" class="btn btn-info" style="width: 100%;" value="20">
                                            <span class="glyphicon glyphicon-plus"></span> Adicionar
                                        </button>
                                    </div>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Serviço</th>
                                                <th scope="col">Ações</th>
                                                <th scope="col">Sub-total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (Servico s : servicos) {
                                            %>
                                            <tr>
                                                <th scope="row"><%= s.getSerid()%></th>
                                                <td><%= s.getSerdesc()%></td>
                                                <td><button type="submit" value="<%= s.getSerid()%>" name="botao" id="botao" class="btn bg-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> </button></td>
                                                <td id="subtotal" name="subtotal">R$ <%= s.getServalor()%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                            <tr>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>Total:</td>
                                                <td>R$ <%= isdao.calculaTotal(o.getOsid())%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </article>
        </div>
    </body>
</html>

