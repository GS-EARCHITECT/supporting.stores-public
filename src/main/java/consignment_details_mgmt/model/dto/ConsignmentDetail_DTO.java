package consignment_details_mgmt.model.dto;

import java.io.Serializable;

public class ConsignmentDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5163229169726132531L;
	private Long resourceSeqNo;
	private Long consignmentSeqNo;
	private Long storeMovementSeqNo;
	private Long assetSeqNo;
	private Float qty;
	private Long qtyUnitSeqNo;
	private String remark;
	private String status;
	private Character okFlag;
	private Character doneFlag;

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getConsignmentSeqNo() {
		return consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Character getOkFlag() {
		return okFlag;
	}

	public void setOkFlag(Character okFlag) {
		this.okFlag = okFlag;
	}

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public ConsignmentDetail_DTO() {
		super();
	}

	public Long getStoreMovementSeqNo() {
		return storeMovementSeqNo;
	}

	public void setStoreMovementSeqNo(Long storeMovementSeqNo) {
		this.storeMovementSeqNo = storeMovementSeqNo;
	}

	public ConsignmentDetail_DTO(Long resourceSeqNo, Long consignmentSeqNo, Long storeMovementSeqNo, Long assetSeqNo,
			Float qty, Long qtyUnitSeqNo, String remark, String status, Character okFlag, Character doneFlag) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.consignmentSeqNo = consignmentSeqNo;
		this.storeMovementSeqNo = storeMovementSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.qty = qty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.remark = remark;
		this.status = status;
		this.okFlag = okFlag;
		this.doneFlag = doneFlag;
	}

}