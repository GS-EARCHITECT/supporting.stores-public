package consignment_details_mgmt.services.batch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import consignment_details_mgmt.model.dto.ConsignmentDetail_DTO;
import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.master.ConsignmentDetailPK;
import consignment_details_mgmt.model.repo.cud.ConsignmentDetailsCUD_Repo;
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.services.read.I_ConsignmentMasterRead_Service;

@Service("consignmentApplyInwardsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ConsignmentDetailsCUD_Service implements I_ConsignmentApplyInwards_Service
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ConsignmentDetailService.class);

	@Autowired
	private I_ConsignmentMasterRead_Service consignmentMasterReadServ;
	
	@Autowired
	private ConsignmentDetailsCUD_Repo consignmentDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<Void> applyConsignment()
	{
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> 
		{
			
			CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future2 = consignmentMasterReadServ.getSelectConsignmentMastersCanBeProcessed();
			CopyOnWriteArrayList<ConsignmentMaster_DTO> consignmentMaster_DTOs = future2.join();  
			
			for (int i = 0; i < consignmentMaster_DTOs.size(); i++) 
			{
				
			}
			
			return;
		}, asyncExecutor);
		return future;
	}

	

	private synchronized ConsignmentDetail_DTO getConsignmentDetail_DTO(ConsignmentDetail jobDetail2) {
		ConsignmentDetail_DTO jobDetailDTO = new ConsignmentDetail_DTO();
		jobDetailDTO = new ConsignmentDetail_DTO();
		jobDetailDTO.setConsignmentSeqNo(jobDetail2.getId().getConsignmentSeqNo());
		jobDetailDTO.setAssetSeqNo(jobDetail2.getId().getAssetSeqNo());
		jobDetailDTO.setResourceSeqNo(jobDetail2.getId().getResourceSeqNo());
		jobDetailDTO.setQty(jobDetail2.getQty());
		jobDetailDTO.setQtyUnitSeqNo(jobDetail2.getQtyUnitSeqNo());
		jobDetailDTO.setRemark(jobDetail2.getRemark());
		jobDetailDTO.setStatus(jobDetail2.getStatus());
		return jobDetailDTO;
	}

	private synchronized ConsignmentDetail setConsignmentDetail_DTO(ConsignmentDetail_DTO jobDetailDTO) {
		ConsignmentDetail jobDetail = new ConsignmentDetail();
		ConsignmentDetailPK consignmentDetailPK = new ConsignmentDetailPK();
		consignmentDetailPK.setAssetSeqNo(jobDetailDTO.getAssetSeqNo());
		consignmentDetailPK.setConsignmentSeqNo(jobDetailDTO.getConsignmentSeqNo());
		consignmentDetailPK.setResourceSeqNo(jobDetailDTO.getResourceSeqNo());
		jobDetail.setId(consignmentDetailPK);
		jobDetail.setQty(jobDetailDTO.getQty());
		jobDetail.setQtyUnitSeqNo(jobDetailDTO.getQtyUnitSeqNo());
		jobDetail.setRemark(jobDetailDTO.getRemark());
		jobDetail.setStatus(jobDetailDTO.getStatus());
		return jobDetail;
	}

}