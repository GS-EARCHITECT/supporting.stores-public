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
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.findAll();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMasters(jcmSeqNos);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersByParents(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersForParties(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersToParties(pids);
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersComingIn() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersComingIn();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersGoingOut() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersGoingOut();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersPending();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersCanBeProcessed();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersCannotBeProcessed();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentInMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentInMastersPending();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentOutMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentOutMastersPending();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersAppliedOutwards() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersAppliedOutwards();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersAppliedInwards() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ConsignmentMaster> conList = (CopyOnWriteArrayList<ConsignmentMaster>) consignmentMasterReadRepo.getSelectConsignmentMastersAppliedInwards();
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();
		jcmDTOs = conList != null ? this.getConsignmentMaster_DTOs(conList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	
	private synchronized CopyOnWriteArrayList<ConsignmentMaster_DTO> getConsignmentMaster_DTOs(CopyOnWriteArrayList<ConsignmentMaster> conMasters) {
		ConsignmentMaster_DTO conDTO = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> conDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();

		for (int i = 0; i < conMasters.size(); i++) {
			conDTO = getConsignmentMaster_DTO(conMasters.get(i));
			conDTOs.add(conDTO);
		}
		return conDTOs;
	}

	private synchronized ConsignmentMaster_DTO getConsignmentMaster_DTO(ConsignmentMaster conMaster2) 
	{
		ConsignmentMaster_DTO conMasterDTO = new ConsignmentMaster_DTO();
		conMasterDTO = new ConsignmentMaster_DTO();
		conMasterDTO.setConsignmentSeqNo(conMaster2.getConsignmentSeqNo());
		conMasterDTO.setFromLocationSeqNo(conMaster2.getFromLocationSeqNo());
		conMasterDTO.setFromPartySeqNo(conMaster2.getFromPartySeqNo());		
		conMasterDTO.setParConsignmentSeqNo(conMaster2.getParConsignmentSeqNo());
		conMasterDTO.setToLocationSeqNo(conMaster2.getToLocationSeqNo());
		conMasterDTO.setToPartySeqNo(conMaster2.getToPartySeqNo());		
		conMasterDTO.setRemark(conMaster2.getRemark());		
		return conMasterDTO;
	}

}