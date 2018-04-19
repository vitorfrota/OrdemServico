/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.model.beans;

/**
 *
 * @author vitor_9g3eyo1
 */
public class Servico {
    
    private int serid;
    private String serdesc;
    private Double servalor;
    private String serstatus;

    /**
     * @return the serid
     */
    public int getSerid() {
        return serid;
    }

    /**
     * @param serid the serid to set
     */
    public void setSerid(int serid) {
        this.serid = serid;
    }

    /**
     * @return the serdesc
     */
    public String getSerdesc() {
        return serdesc;
    }

    /**
     * @param serdesc the serdesc to set
     */
    public void setSerdesc(String serdesc) {
        this.serdesc = serdesc;
    }

    /**
     * @return the servalor
     */
    public Double getServalor() {
        return servalor;
    }

    /**
     * @param servalor the servalor to set
     */
    public void setServalor(Double servalor) {
        this.servalor = servalor;
    }

    /**
     * @return the serstatus
     */
    public String getSerstatus() {
        return serstatus;
    }

    /**
     * @param serstatus the serstatus to set
     */
    public void setSerstatus(String serstatus) {
        this.serstatus = serstatus;
    }
    
    
    
}
