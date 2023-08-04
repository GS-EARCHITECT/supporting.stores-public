package store_stock_movement_mgmt.recieve.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the SALES_MASTER database table.
 * 
 */
@Embeddable
public class StoreMovementMasterPK implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 843770877676094469L;

	@Column(name="REQUEST_ON")
	private Timestamp request_on;
	
	@Column(name="ITEM_SEQ_NO")
	private Integer item_seq_no;
	
	@Column(name="STORE_REQUEST_SEQ_NO")
	private Integer store_request_seq_no;

	public Timestamp getRequest_on() {
		return request_on;
	}

	public void setRequest_on(Timestamp request_on) {
		this.request_on = request_on;
	}

	public Integer getItem_seq_no() {
		return item_seq_no;
	}

	public void setItem_seq_no(Integer item_seq_no) {
		this.item_seq_no = item_seq_no;
	}

	public Integer getStore_request_seq_no() {
		return store_request_seq_no;
	}

	public void setStore_request_seq_no(Integer store_request_seq_no) {
		this.store_request_seq_no = store_request_seq_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_seq_no == null) ? 0 : item_seq_no.hashCode());
		result = prime * result + ((request_on == null) ? 0 : request_on.hashCode());
		result = prime * result + ((store_request_seq_no == null) ? 0 : store_request_seq_no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreMovementMasterPK other = (StoreMovementMasterPK) obj;
		if (item_seq_no == null) {
			if (other.item_seq_no != null)
				return false;
		} else if (!item_seq_no.equals(other.item_seq_no))
			return false;
		if (request_on == null) {
			if (other.request_on != null)
				return false;
		} else if (!request_on.equals(other.request_on))
			return false;
		if (store_request_seq_no == null) {
			if (other.store_request_seq_no != null)
				return false;
		} else if (!store_request_seq_no.equals(other.store_request_seq_no))
			return false;
		return true;
	}

	public StoreMovementMasterPK(Timestamp request_on, Integer item_seq_no, Integer store_request_seq_no) {
		super();
		this.request_on = request_on;
		this.item_seq_no = item_seq_no;
		this.store_request_seq_no = store_request_seq_no;
	}

	public StoreMovementMasterPK() {
		super();
	}


	
}