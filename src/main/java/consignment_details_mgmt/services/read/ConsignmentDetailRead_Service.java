package consignment_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import consignment_details_mgmt.model.dto.ConsignmentDetail_DTO;
import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.repo.read.ConsignmentDetailsRead_Repo;

@Service("consignmentDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ConsignmentDetailRead_Service implements I_ConsignmentDetailsRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(ConsignmentDetailService.class);

	@Autowired
	private ConsignmentDetailsRead_Repo consignmentDetailsReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getAllConsignmentDetails()  
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.findAll();
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetails(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetails(jcmSeqNos);
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsByResources(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetailsByResources(pids);
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetailsByAssets(pids);
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetailsPending();
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsDelivered() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetailsDelivered();
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetailsCanBeProcessed();
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentDetailsCannotBeProcessed();
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentResourceDetailsPending(Long cid) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentResourceDetailsPending(cid);
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentAssetDetailsPending(Long cid) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentDetail> jobList = (CopyOnWriteArrayList<ConsignmentDetail>) consignmentDetailsReadRepo.getSelectConsignmentAssetDetailsPending(cid);
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	
	private synchronized CopyOnWriteArrayList<ConsignmentDetail_DTO> getConsignmentDetail_DTOs(CopyOnWriteArrayList<ConsignmentDetail> jobDetailss) {
		ConsignmentDetail_DTO jobDTO = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDTOs = new CopyOnWriteArrayList<ConsignmentDetail_DTO>();

		for (int i = 0; i < jobDetailss.size(); i++) {
			jobDTO = getConsignmentDetail_DTO(jobDetailss.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized ConsignmentDetail_DTO getConsignmentDetail_DTO(ConsignmentDetail jobDetails2) 
	{
		ConsignmentDetail_DTO jobDetailsDTO = new ConsignmentDetail_DTO();
		jobDetailsDTO = new ConsignmentDetail_DTO();
		jobDetailsDTO.setConsignmentSeqNo(jobDetails2.getId().getConsignmentSeqNo());
		jobDetailsDTO.setAssetSeqNo(jobDetails2.getAssetSeqNo());
		jobDetailsDTO.setQty(jobDetails2.getQty());		
		jobDetailsDTO.setQtyUnitSeqNo(jobDetails2.getQtyUnitSeqNo());
		jobDetailsDTO.setResourceSeqNo(jobDetails2.getResourceSeqNo());
		jobDetailsDTO.setRemark(jobDetails2.getRemark());
		jobDetailsDTO.setStatus(jobDetails2.getStatus());
		return jobDetailsDTO;
	}

}