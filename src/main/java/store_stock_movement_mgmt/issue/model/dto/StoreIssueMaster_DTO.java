package store_stock_movement_mgmt.issue.model.dto;

import java.io.Serializable;

public class StoreIssueMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 475909619790838731L;
	private Long storeMovementSeqNo;
	private String appliedOn;
	private Long assetSeqNo;
	private Float consignQty;
	private Character doneflag;
	private Long locationSeqNo;
	private Character okflag;
	private String processedOn;
	private Float processedQty;
	private Long qtyUnitSeqNo;
	private Float qualityQty;
	private String requestOn;
	private Float requestQty;
	private Long resourceSeqNo;
	private Long storeRequestSeqNo;

	public Long getStoreMovementSeqNo() {
		return storeMovementSeqNo;
	}

	public void setStoreMovementSeqNo(Long storeMovementSeqNo) {
		this.storeMovementSeqNo = storeMovementSeqNo;
	}

	public String getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(String appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Float getConsignQty() {
		return consignQty;
	}

	public void setConsignQty(Float consignQty) {
		this.consignQty = consignQty;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public String getProcessedOn() {
		return processedOn;
	}

	public void setProcessedOn(String processedOn) {
		this.processedOn = processedOn;
	}

	public Float getProcessedQty() {
		return processedQty;
	}

	public void setProcessedQty(Float processedQty) {
		this.processedQty = processedQty;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Float getQualityQty() {
		return qualityQty;
	}

	public void setQualityQty(Float qualityQty) {
		this.qualityQty = qualityQty;
	}

	public String getRequestOn() {
		return requestOn;
	}

	public void setRequestOn(String requestOn) {
		this.requestOn = requestOn;
	}

	public Float getRequestQty() {
		return requestQty;
	}

	public void setRequestQty(Float requestQty) {
		this.requestQty = requestQty;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getStoreRequestSeqNo() {
		return storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public StoreIssueMaster_DTO(Long storeMovementSeqNo, String appliedOn, Long assetSeqNo, Float consignQty,
			Character doneflag, Long locationSeqNo, Character okflag, String processedOn, Float processedQty,
			Long qtyUnitSeqNo, Float qualityQty, String requestOn, Float requestQty, Long resourceSeqNo,
			Long storeRequestSeqNo) {
		super();
		this.storeMovementSeqNo = storeMovementSeqNo;
		this.appliedOn = appliedOn;
		this.assetSeqNo = assetSeqNo;
		this.consignQty = consignQty;
		this.doneflag = doneflag;
		this.locationSeqNo = locationSeqNo;
		this.okflag = okflag;
		this.processedOn = processedOn;
		this.processedQty = processedQty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.qualityQty = qualityQty;
		this.requestOn = requestOn;
		this.requestQty = requestQty;
		this.resourceSeqNo = resourceSeqNo;
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public StoreIssueMaster_DTO() {
		super();
	}

}