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
public class Tecnico {
    
    private int tecid;
    private String tecnome;
    private String tecfone;
    private String tecemail;

    /**
     * @return the tecid
     */
    public int getTecid() {
        return tecid;
    }

    /**
     * @param tecid the tecid to set
     */
    public void setTecid(int tecid) {
        this.tecid = tecid;
    }

    /**
     * @return the tecnome
     */
    public String getTecnome() {
        return tecnome;
    }

    /**
     * @param tecnome the tecnome to set
     */
    public void setTecnome(String tecnome) {
        this.tecnome = tecnome;
    }

    /**
     * @return the tecfone
     */
    public String getTecfone() {
        return tecfone;
    }

    /**
     * @param tecfone the tecfone to set
     */
    public void setTecfone(String tecfone) {
        this.tecfone = tecfone;
    }

    /**
     * @return the tecemail
     */
    public String getTecemail() {
        return tecemail;
    }

    /**
     * @param tecemail the tecemail to set
     */
    public void setTecemail(String tecemail) {
        this.tecemail = tecemail;
    }
    
    
    
}
