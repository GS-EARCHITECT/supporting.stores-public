package job_consignment_details_mgmt.model.dto;

import java.io.Serializable;

public class JobConsignmentDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5163229169726132531L;
	private Long resourceSeqNo;
	private Long consignmentSeqNo;
	private Long assetSeqNo;
	private Float qty;
	private Long qtyUnitSeqNo;
	private String remark;
	private String status;
	private Character okFlag;

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

	public JobConsignmentDetail_DTO() {
		super();
	}

	public JobConsignmentDetail_DTO(Long resourceSeqNo, Long consignmentSeqNo, Long assetSeqNo, Float qty,
			Long qtyUnitSeqNo, String remark, String status, Character okFlag) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.consignmentSeqNo = consignmentSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.qty = qty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.remark = remark;
		this.status = status;
		this.okFlag = okFlag;
	}

}