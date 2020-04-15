package com.andiads.nusabank.api.exception;

public class NasabahNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6543909043297701051L;

	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public NasabahNotFoundException(String rn, String fn, Object fv){
		super(String.format(
				"%s not found with %s :: '%s'"
				,rn, fn, fv));
		this.resourceName=rn;
		this.fieldName=fn;
		this.fieldValue=fv;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
	
	
}
