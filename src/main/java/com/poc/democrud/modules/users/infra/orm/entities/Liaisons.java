package com.poc.democrud.modules.users.infra.orm.entities;

import com.poc.democrud.modules.users.enums.LiaisonType;
import com.poc.democrud.modules.users.enums.PhoneType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "liaison", schema = "crud")
public class Liaisons implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "type", nullable = false, length = 1)
    @Enumerated(EnumType.ORDINAL)
    private LiaisonType liaisonType;

    @Column(name = "phone_type", length = 1)
    @Enumerated(EnumType.ORDINAL)
    private PhoneType phoneType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LiaisonType getLiaisonType() {
        return liaisonType;
    }

    public void setLiaisonType(LiaisonType liaisonType) {
        this.liaisonType = liaisonType;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType type) {
        this.phoneType = type;
    }
}
