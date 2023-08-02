package consignment_master_mgmt.services.read;

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
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.model.repo.read.ConsignmentMasterRead_Repo;

@Service("consignmentMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ConsignmentMasterRead_Service implements I_ConsignmentMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(ConsignmentMasterService.class);

	@Autowired
	private ConsignmentMasterRead_Repo consignmentMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getAllConsignmentMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.findAll();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMasters(jcmSeqNos);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersByRequests(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersByParents(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersForParties(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersToParties(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersComingIn() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersComingIn();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersGoingOut() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersGoingOut();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersPending();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersDelivered() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersDelivered();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersCanBeProcessed();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> jobList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersCannotBeProcessed();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	
	private synchronized CopyOnWriteArrayList<ConsignmentMaster_DTO> getConsignmentMaster_DTOs(CopyOnWriteArrayList<ConsignmentMaster> jobMasters) {
		ConsignmentMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getConsignmentMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized ConsignmentMaster_DTO getConsignmentMaster_DTO(ConsignmentMaster jobMaster2) 
	{
		ConsignmentMaster_DTO jobMasterDTO = new ConsignmentMaster_DTO();
		jobMasterDTO = new ConsignmentMaster_DTO();
		jobMasterDTO.setConsignmentSeqNo(jobMaster2.getConsignmentSeqNo());
		jobMasterDTO.setFromLocationSeqNo(jobMaster2.getFromLocationSeqNo());
		jobMasterDTO.setFromPartySeqNo(jobMaster2.getFromPartySeqNo());		
		jobMasterDTO.setParConsignmentSeqNo(jobMaster2.getParConsignmentSeqNo());
		jobMasterDTO.setStoreRequestSeqNo(jobMaster2.getStoreRequestSeqNo());
		jobMasterDTO.setToLocationSeqNo(jobMaster2.getToLocationSeqNo());
		jobMasterDTO.setToPartySeqNo(jobMaster2.getToPartySeqNo());		
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}

}