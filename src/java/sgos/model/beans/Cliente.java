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
public class Cliente {
    
    private int cliid;
    private String clinome;
    private String clicpf;
    private String clifone;
    private String cliemail;

    /**
     * @return the cliid
     */
    public int getCliid() {
        return cliid;
    }

    /**
     * @param cliid the cliid to set
     */
    public void setCliid(int cliid) {
        this.cliid = cliid;
    }

    /**
     * @return the clinome
     */
    public String getClinome() {
        return clinome;
    }

    /**
     * @param clinome the clinome to set
     */
    public void setClinome(String clinome) {
        this.clinome = clinome;
    }

    /**
     * @return the clicpf
     */
    public String getClicpf() {
        return clicpf;
    }

    /**
     * @param clicpf the clicpf to set
     */
    public void setClicpf(String clicpf) {
        this.clicpf = clicpf;
    }

    /**
     * @return the clifone
     */
    public String getClifone() {
        return clifone;
    }

    /**
     * @param clifone the clifone to set
     */
    public void setClifone(String clifone) {
        this.clifone = clifone;
    }

    /**
     * @return the cliemail
     */
    public String getCliemail() {
        return cliemail;
    }

    /**
     * @param cliemail the cliemail to set
     */
    public void setCliemail(String cliemail) {
        this.cliemail = cliemail;
    }
    
    
}
