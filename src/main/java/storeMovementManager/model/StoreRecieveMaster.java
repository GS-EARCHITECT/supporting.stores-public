package storeMovementManager.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="STORE_RECIEVE_MASTER")
public class StoreRecieveMaster implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4055157308761080235L;

	@EmbeddedId
	private StoreMovementMasterPK id;

	@Column(name="STATUS")
	private String status;

	@Column(name="REMARK")
	private String remark;
		
	@Column(name="REQUEST_QTY")
	private Float request_qty;
		
	@Column(name="QTY_UNIT_SEQ_NO")
	private Integer qty_unit_seq_no;
	
	@Column(name="PROCESSED_QTY")
	private Float processed_qty;

	public StoreMovementMasterPK getId() {
		return id;
	}

	public void setId(StoreMovementMasterPK id) {
		this.id = id;
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

	public Float getRequest_qty() {
		return request_qty;
	}

	public void setRequest_qty(Float request_qty) {
		this.request_qty = request_qty;
	}

	public Integer getQty_unit_seq_no() {
		return qty_unit_seq_no;
	}

	public void setQty_unit_seq_no(Integer qty_unit_seq_no) {
		this.qty_unit_seq_no = qty_unit_seq_no;
	}

	public Float getProcessed_qty() {
		return processed_qty;
	}

	public void setProcessed_qty(Float processed_qty) {
		this.processed_qty = processed_qty;
	}

	public StoreRecieveMaster(StoreMovementMasterPK id, String status, String remark, Float request_qty,
			Integer qty_unit_seq_no, Float processed_qty) {
		super();
		this.id = id;
		this.status = status;
		this.remark = remark;
		this.request_qty = request_qty;
		this.qty_unit_seq_no = qty_unit_seq_no;
		this.processed_qty = processed_qty;
	}

	public StoreRecieveMaster() {
		super();
	}
	
	

}