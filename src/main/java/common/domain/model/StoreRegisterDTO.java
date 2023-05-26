package common.domain.model;

import java.io.Serializable;

public class StoreRegisterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8233236084613501443L;
	private Integer store_request_seq_no;
	private Integer requestor_seq_no;
	private String status;
	private String remark;
	private Integer service_request_seq_no;
	private Integer qty_unit_seq_no;
	private Integer item_seq_no;
	private char is_booked;
	private Integer mode_txn;
	private Float qty_booked;
	public Integer getStore_request_seq_no() {
		return store_request_seq_no;
	}
	public void setStore_request_seq_no(Integer store_request_seq_no) {
		this.store_request_seq_no = store_request_seq_no;
	}
	public Integer getRequestor_seq_no() {
		return requestor_seq_no;
	}
	public void setRequestor_seq_no(Integer requestor_seq_no) {
		this.requestor_seq_no = requestor_seq_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getService_request_seq_no() {
		return service_request_seq_no;
	}
	public void setService_request_seq_no(Integer service_request_seq_no) {
		this.service_request_seq_no = service_request_seq_no;
	}
	public Integer getQty_unit_seq_no() {
		return qty_unit_seq_no;
	}
	public void setQty_unit_seq_no(Integer qty_unit_seq_no) {
		this.qty_unit_seq_no = qty_unit_seq_no;
	}
	public Integer getItem_seq_no() {
		return item_seq_no;
	}
	public void setItem_seq_no(Integer item_seq_no) {
		this.item_seq_no = item_seq_no;
	}
	public char getIs_booked() {
		return is_booked;
	}
	public void setIs_booked(char is_booked) {
		this.is_booked = is_booked;
	}
	public Integer getMode_txn() {
		return mode_txn;
	}
	public void setMode_txn(Integer mode_txn) {
		this.mode_txn = mode_txn;
	}
	public Float getQty_booked() {
		return qty_booked;
	}
	public void setQty_booked(Float qty_booked) {
		this.qty_booked = qty_booked;
	}
	public StoreRegisterDTO(Integer store_request_seq_no, Integer requestor_seq_no, String status, String remark,
			Integer service_request_seq_no, Integer qty_unit_seq_no, Integer item_seq_no, char is_booked,
			Integer mode_txn, Float qty_booked) {
		super();
		this.store_request_seq_no = store_request_seq_no;
		this.requestor_seq_no = requestor_seq_no;
		this.status = status;
		this.remark = remark;
		this.service_request_seq_no = service_request_seq_no;
		this.qty_unit_seq_no = qty_unit_seq_no;
		this.item_seq_no = item_seq_no;
		this.is_booked = is_booked;
		this.mode_txn = mode_txn;
		this.qty_booked = qty_booked;
	}
	public StoreRegisterDTO() {
		super();
	}
	
}
