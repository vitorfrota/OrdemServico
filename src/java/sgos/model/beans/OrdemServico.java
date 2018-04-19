/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.model.beans;

import java.util.Date;

/**
 *
 * @author vitor_9g3eyo1
 */
public class OrdemServico {

        private int osid;
        private String ossituacao;
        private Double osvalor;
        private String osdefeito;
        private String oslaudo;
        private String osdescaparelho;
        private Date osdataabertura;
        private Date osdataconclusao;
        private Date osdataentrega;

    /**
     * @return the osid
     */
    public int getOsid() {
        return osid;
    }

    /**
     * @param osid the osid to set
     */
    public void setOsid(int osid) {
        this.osid = osid;
    }

    /**
     * @return the ossituacao
     */
    public String getOssituacao() {
        return ossituacao;
    }

    /**
     * @param ossituacao the ossituacao to set
     */
    public void setOssituacao(String ossituacao) {
        this.ossituacao = ossituacao;
    }

    /**
     * @return the osvalor
     */
    public Double getOsvalor() {
        return osvalor;
    }

    /**
     * @param osvalor the osvalor to set
     */
    public void setOsvalor(Double osvalor) {
        this.osvalor = osvalor;
    }

    /**
     * @return the osdefeito
     */
    public String getOsdefeito() {
        return osdefeito;
    }

    /**
     * @param osdefeito the osdefeito to set
     */
    public void setOsdefeito(String osdefeito) {
        this.osdefeito = osdefeito;
    }

    /**
     * @return the oslaudo
     */
    public String getOslaudo() {
        return oslaudo;
    }

    /**
     * @param oslaudo the oslaudo to set
     */
    public void setOslaudo(String oslaudo) {
        this.oslaudo = oslaudo;
    }

    /**
     * @return the osdescaparelho
     */
    public String getOsdescaparelho() {
        return osdescaparelho;
    }

    /**
     * @param osdescaparelho the osdescaparelho to set
     */
    public void setOsdescaparelho(String osdescaparelho) {
        this.osdescaparelho = osdescaparelho;
    }

    /**
     * @return the osdataabertura
     */
    public Date getOsdataabertura() {
        return osdataabertura;
    }

    /**
     * @param osdataabertura the osdataabertura to set
     */
    public void setOsdataabertura(Date osdataabertura) {
        this.osdataabertura = osdataabertura;
    }

    /**
     * @return the osdataconclusao
     */
    public Date getOsdataconclusao() {
        return osdataconclusao;
    }

    /**
     * @param osdataconclusao the osdataconclusao to set
     */
    public void setOsdataconclusao(Date osdataconclusao) {
        this.osdataconclusao = osdataconclusao;
    }

    /**
     * @return the osdataentrega
     */
    public Date getOsdataentrega() {
        return osdataentrega;
    }

    /**
     * @param osdataentrega the osdataentrega to set
     */
    public void setOsdataentrega(Date osdataentrega) {
        this.osdataentrega = osdataentrega;
    }

    public String getDefeito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
        
        
}
