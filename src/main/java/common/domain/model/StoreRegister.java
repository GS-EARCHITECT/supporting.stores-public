package common.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="STORE_ORDER_MASTER")
public class StoreRegister implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8271020169897971791L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_request_sequence")
	@SequenceGenerator(name = "store_request_sequence", allocationSize = 1)
	private Integer store_request_seq_no;

	@Column(name="REQUESTOR_SEQ_NO")
	private Integer requestor_seq_no;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="REMARK")
	private String remark;

	@Column(name="SERVICE_REQUEST_SEQ_NO")
	private Integer service_request_seq_no;
	
	@Column(name="QTY_UNIT_SEQ_NO")
	private Integer qty_unit_seq_no;
	
	@Column(name="ITEM_SEQ_NO")
	private Integer item_seq_no;
	
	@Column(name="IS_BOOKED")
	private char is_booked;
	
	@Column(name="QTY_ALLOCATED")
	private Float qty_allocated;

	@Column(name="QTY_REQUESTED")
	private Float qty_requested;

	@Column(name="MODE_TXN")
	private Integer mode_txn;
	
	@Column(name="QTY_BOOKED")
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

	public Float getQty_allocated() {
		return qty_allocated;
	}

	public void setQty_allocated(Float qty_allocated) {
		this.qty_allocated = qty_allocated;
	}

	public Float getQty_requested() {
		return qty_requested;
	}

	public void setQty_requested(Float qty_requested) {
		this.qty_requested = qty_requested;
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

	public StoreRegister(Integer store_request_seq_no, Integer requestor_seq_no, String status, String remark,
			Integer service_request_seq_no, Integer qty_unit_seq_no, Integer item_seq_no, char is_booked,
			Float qty_allocated, Float qty_requested, Integer mode_txn, Float qty_booked) {
		super();
		this.store_request_seq_no = store_request_seq_no;
		this.requestor_seq_no = requestor_seq_no;
		this.status = status;
		this.remark = remark;
		this.service_request_seq_no = service_request_seq_no;
		this.qty_unit_seq_no = qty_unit_seq_no;
		this.item_seq_no = item_seq_no;
		this.is_booked = is_booked;
		this.qty_allocated = qty_allocated;
		this.qty_requested = qty_requested;
		this.mode_txn = mode_txn;
		this.qty_booked = qty_booked;
	}

	public StoreRegister() {
		super();
	}
	
	
}