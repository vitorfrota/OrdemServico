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
public class Peca {
    
    private int pecid;
    private String pecdesc;
    private Double pecvalor;
    private String pecstatus;

    /**
     * @return the pecid
     */
    public int getPecid() {
        return pecid;
    }

    /**
     * @param pecid the pecid to set
     */
    public void setPecid(int pecid) {
        this.pecid = pecid;
    }

    /**
     * @return the pecdesc
     */
    public String getPecdesc() {
        return pecdesc;
    }

    /**
     * @param pecdesc the pecdesc to set
     */
    public void setPecdesc(String pecdesc) {
        this.pecdesc = pecdesc;
    }

    /**
     * @return the pecvalor
     */
    public Double getPecvalor() {
        return pecvalor;
    }

    /**
     * @param pecvalor the pecvalor to set
     */
    public void setPecvalor(Double pecvalor) {
        this.pecvalor = pecvalor;
    }

    /**
     * @return the pecstatus
     */
    public String getPecstatus() {
        return pecstatus;
    }

    /**
     * @param pecstatus the pecstatus to set
     */
    public void setPecstatus(String pecstatus) {
        this.pecstatus = pecstatus;
    }
    
    
    
}
