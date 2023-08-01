package job_consignment_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_CONSIGNMENT_DETAILS database table.
 * 
 */
@Entity
@Table(name = "JOB_CONSIGNMENT_DETAILS")
public class JobConsignmentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobConsignmentDetailPK id;

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

	public JobConsignmentDetail() {
	}

	public JobConsignmentDetailPK getId() {
		return this.id;
	}

	public void setId(JobConsignmentDetailPK id) {
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

	public JobConsignmentDetail(JobConsignmentDetailPK id, Float qty, Character okFkag, Long qtyUnitSeqNo,
			String remark, String status) {
		super();
		this.id = id;
		this.qty = qty;
		this.okFkag = okFkag;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.remark = remark;
		this.status = status;
	}

}