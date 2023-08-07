package consignment_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_CONSIGNMENT_DETAILS database table.
 * 
 */
@Entity
@Table(name = "STORE_CONSIGNMENT_DETAILS")
public class ConsignmentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsignmentDetailPK id;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "QTY")
	private Float qty;

	@Column(name = "OK_FLAG")
	private Character okFkag;

	@Column(name = "QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DONEFLAG")
	private Character doneFlag;

	@Column(name = "OKFLAG")
	private Character okflag;

	public ConsignmentDetail() {
	}

	public ConsignmentDetailPK getId() {
		return this.id;
	}

	public void setId(ConsignmentDetailPK id) {
		this.id = id;
	}

	public Float getQty() {
		return this.qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtyUnitSeqNo() {
		return this.qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Character getOkFkag() {
		return okFkag;
	}

	public void setOkFkag(Character okFkag) {
		this.okFkag = okFkag;
	}

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public ConsignmentDetail(ConsignmentDetailPK id, Long resourceSeqNo, Long assetSeqNo, Float qty, Character okFkag,
			Long qtyUnitSeqNo, String remark, String status, Character doneFlag, Character okflag) {
		super();
		this.id = id;
		this.resourceSeqNo = resourceSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.qty = qty;
		this.okFkag = okFkag;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.remark = remark;
		this.status = status;
		this.doneFlag = doneFlag;
		this.okflag = okflag;
	}

}