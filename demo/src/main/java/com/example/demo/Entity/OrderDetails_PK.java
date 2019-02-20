package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetails_PK implements Serializable{
	  private String code;
	    private String oId;

	    public OrderDetails_PK() {
	    }

	    public OrderDetails_PK(String code, String oId) {
	        this.setCode(code);
	        this.setoId(oId);
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getoId() {
	        return oId;
	    }

	    public void setoId(String oId) {
	        this.oId = oId;
	    }
}
