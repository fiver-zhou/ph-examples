package com.ph.common.dto;

import java.util.List;

public class PageData<T> {

	private Long total;
	private List<T> data;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}