package consignment_details_mgmt.services.cud;

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

@Service("consignmentDetailCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ConsignmentDetailsCUD_Service implements I_ConsignmentDetailsCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ConsignmentDetailService.class);

	@Autowired
	private ConsignmentDetailsCUD_Repo consignmentDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ConsignmentDetail_DTO> newConsignmentDetail(
			ConsignmentDetail_DTO consignmentDetail_DTO) {
		CompletableFuture<ConsignmentDetail_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ConsignmentDetailPK consignmentDetailPK = new ConsignmentDetailPK();
			consignmentDetailPK.setAssetSeqNo(consignmentDetail_DTO.getAssetSeqNo());
			consignmentDetailPK.setConsignmentSeqNo(consignmentDetail_DTO.getConsignmentSeqNo());
			consignmentDetailPK.setResourceSeqNo(consignmentDetail_DTO.getResourceSeqNo());
			ConsignmentDetail_DTO jcmDTO = null;
			if (!consignmentDetailsCUDRepo.existsById(consignmentDetailPK)) 
			{
				jcmDTO = this.getConsignmentDetail_DTO(
						consignmentDetailsCUDRepo.save(this.setConsignmentDetail_DTO(consignmentDetail_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updConsignmentAssetDetailDone(Long id, Long aid) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentAssetDetailDone(id, aid);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentResourceDetailDone(Long id, Long rid) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentResourceDetailDone(id, rid);
			
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updConsignmentDetailAssetDoneStatus(Long id, Long aid,  Character st) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentDetailAssetDoneStatus(id, aid,  st);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentDetailResourceDoneStatus(Long id, Long rid,  Character st) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentDetailResourceDoneStatus(id, rid, st);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentResourceDetailOk(Long id, Long rid) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentResourceDetailOk(id, rid);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentAssetDetailOk(Long id, Long aid) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentAssetDetailOk(id, aid);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentResourceDetailOkStatus(Long id, Long rid, Character st) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentResourceDetailOkStatus(id, rid, st);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentAssetDetailOkStatus(Long id, Long aid, Character st) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.updConsignmentAssetDetailOkStatus(id, aid, st);
			
			return;
		}, asyncExecutor);
		return future;
	}
	
	
	@Override
	public CompletableFuture<Void> updConsignmentDetail(ConsignmentDetail_DTO consignmentDetail_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			ConsignmentDetailPK consignmentDetailPK = new ConsignmentDetailPK();
			consignmentDetailPK.setAssetSeqNo(consignmentDetail_DTO.getAssetSeqNo());
			consignmentDetailPK.setConsignmentSeqNo(consignmentDetail_DTO.getConsignmentSeqNo());
			consignmentDetailPK.setResourceSeqNo(consignmentDetail_DTO.getResourceSeqNo());
			ConsignmentDetail_DTO jcmDTO = null;

			if (consignmentDetailsCUDRepo.existsById(consignmentDetailPK)) 
			{
				consignmentDetailsCUDRepo.save(this.setConsignmentDetail_DTO(consignmentDetail_DTO));
				
			}
			return;
		}, asyncExecutor);
		return future;
	}

	
	
	@Override
	public CompletableFuture<Void> delSelectConsignmentDetails(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.delSelectConsignmentDetails(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectConsignmentDetailsByResources(CopyOnWriteArrayList<Long> rids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.delSelectConsignmentDetailsByResources(rids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> aids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.delSelectConsignmentDetailsByAssets(aids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllConsignmentDetails() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentDetailsCUDRepo.deleteAll();
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