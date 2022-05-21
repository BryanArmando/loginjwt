package com.login.loginjwt.domain;

import javax.persistence.*;

@Entity
@Table(name = "info_farmecc")
public class InfoFarmecc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String nosotros;

    @Lob
    private String mision;

    @Lob
    private String vision;


    public InfoFarmecc(){
        super();
    }

    public InfoFarmecc(Integer id, String nosotros, String mision, String vision) {
        this.id = id;
        this.nosotros = nosotros;
        this.mision = mision;
        this.vision = vision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNosotros() {
        return nosotros;
    }

    public void setNosotros(String nosotros) {
        this.nosotros = nosotros;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }
}
