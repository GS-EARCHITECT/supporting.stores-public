package store_stock_movement_mgmt.recieve.model.dto;

import java.io.Serializable;

public class StoreRecieveMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8211477168739779770L;
	private Long storeMovementSeqNo;
	private String recievedOn;
	private String appliedOn;
	private Long assetSeqNo;
	private Float consignQty;
	private String consignedOn;
	private Character doneflag;
	private Long locationSeqNo;
	private Character okflag;
	private String processedOn;
	private Long qtyUnitSeqNo;
	private Float qualityQty;
	private Float recievedQty;
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

	public String getConsignedOn() {
		return consignedOn;
	}

	public void setConsignedOn(String consignedOn) {
		this.consignedOn = consignedOn;
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

	public Float getRecievedQty() {
		return recievedQty;
	}

	public void setRecievedQty(Float recievedQty) {
		this.recievedQty = recievedQty;
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

	public String getRecievedOn() {
		return recievedOn;
	}

	public void setRecievedOn(String recievedOn) {
		this.recievedOn = recievedOn;
	}

	public StoreRecieveMaster_DTO() {
		super();
	}

	public StoreRecieveMaster_DTO(Long storeMovementSeqNo, String recievedOn, String appliedOn, Long assetSeqNo,
			Float consignQty, String consignedOn, Character doneflag, Long locationSeqNo, Character okflag,
			String processedOn, Long qtyUnitSeqNo, Float qualityQty, Float recievedQty, Long resourceSeqNo,
			Long storeRequestSeqNo) {
		super();
		this.storeMovementSeqNo = storeMovementSeqNo;
		this.recievedOn = recievedOn;
		this.appliedOn = appliedOn;
		this.assetSeqNo = assetSeqNo;
		this.consignQty = consignQty;
		this.consignedOn = consignedOn;
		this.doneflag = doneflag;
		this.locationSeqNo = locationSeqNo;
		this.okflag = okflag;
		this.processedOn = processedOn;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.qualityQty = qualityQty;
		this.recievedQty = recievedQty;
		this.resourceSeqNo = resourceSeqNo;
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

}