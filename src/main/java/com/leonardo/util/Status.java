package com.leonardo.util;


public enum Status {
	
	OPEN("open",1),
	ORDER_AHEAD("order ahead",2),
	CLOSED("closed",3);

    private String status;
    private int importance; 

    Status(String name, int importance) {
		this.status = name;
		this.importance = importance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}
}
