package com.spring.angular.xfs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Xfs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String bNumber;
    private final String bUrl;
	
    public Xfs() {
        this.bNumber = "";
        this.bUrl = "";
    }
    
    public Xfs(String bNumber, String bUrl) {
        this.bNumber = bNumber;
        this.bUrl = bUrl;
    }

    public long getId() {
        return id;
    }
    
    public String getNumber() {
        return bNumber;
    }

    public String getUrl() {
        return bUrl;
    }
    
    @Override
    public String toString() {
        return "Xfs{" + "id=" + id + ", Build_Number=" + bNumber + ", Build_url=" + bUrl + '}';
    }
}
    