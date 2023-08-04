package store_order_outwards_mgmt.model.dto;

import java.io.Serializable;

public class StoreOrderOutward_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5769188588883017999L;
	private Long storeRequestSeqNo;
	private Character doneflag;
	private Character isBooked;
	private Long itemSeqNo;
	private Long jobWorkSeqNo;
	private Short modeTxn;
	private Float movedQty;
	private Character okflag;
	private Float qtyAllocated;
	private Float qtyBooked;
	private Float qtyRequested;
	private Long qtyUnitSeqNo;
	private Long requestorSeqNo;
	private String fromDtTm;
	private String toDtTm;

	public StoreOrderOutward_DTO() {
	}

	public Long getStoreRequestSeqNo() {
		return storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Character getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Character isBooked) {
		this.isBooked = isBooked;
	}

	public Long getItemSeqNo() {
		return itemSeqNo;
	}

	public void setItemSeqNo(Long itemSeqNo) {
		this.itemSeqNo = itemSeqNo;
	}

	public Long getJobWorkSeqNo() {
		return jobWorkSeqNo;
	}

	public void setJobWorkSeqNo(Long jobWorkSeqNo) {
		this.jobWorkSeqNo = jobWorkSeqNo;
	}

	public Short getModeTxn() {
		return modeTxn;
	}

	public void setModeTxn(Short modeTxn) {
		this.modeTxn = modeTxn;
	}

	public Float getMovedQty() {
		return movedQty;
	}

	public void setMovedQty(Float movedQty) {
		this.movedQty = movedQty;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Float getQtyAllocated() {
		return qtyAllocated;
	}

	public void setQtyAllocated(Float qtyAllocated) {
		this.qtyAllocated = qtyAllocated;
	}

	public Float getQtyBooked() {
		return qtyBooked;
	}

	public void setQtyBooked(Float qtyBooked) {
		this.qtyBooked = qtyBooked;
	}

	public Float getQtyRequested() {
		return qtyRequested;
	}

	public void setQtyRequested(Float qtyRequested) {
		this.qtyRequested = qtyRequested;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Long getRequestorSeqNo() {
		return requestorSeqNo;
	}

	public void setRequestorSeqNo(Long requestorSeqNo) {
		this.requestorSeqNo = requestorSeqNo;
	}

	public String getFromDtTm() {
		return fromDtTm;
	}

	public void setFromDtTm(String fromDtTm) {
		this.fromDtTm = fromDtTm;
	}

	public String getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(String toDtTm) {
		this.toDtTm = toDtTm;
	}

	public StoreOrderOutward_DTO(Long storeRequestSeqNo, Character doneflag, Character isBooked, Long itemSeqNo,
			Long jobWorkSeqNo, Short modeTxn, Float movedQty, Character okflag, Float qtyAllocated, Float qtyBooked,
			Float qtyRequested, Long qtyUnitSeqNo, Long requestorSeqNo, String fromDtTm, String toDtTm) {
		super();
		this.storeRequestSeqNo = storeRequestSeqNo;
		this.doneflag = doneflag;
		this.isBooked = isBooked;
		this.itemSeqNo = itemSeqNo;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.modeTxn = modeTxn;
		this.movedQty = movedQty;
		this.okflag = okflag;
		this.qtyAllocated = qtyAllocated;
		this.qtyBooked = qtyBooked;
		this.qtyRequested = qtyRequested;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.requestorSeqNo = requestorSeqNo;
		this.fromDtTm = fromDtTm;
		this.toDtTm = toDtTm;
	}

}